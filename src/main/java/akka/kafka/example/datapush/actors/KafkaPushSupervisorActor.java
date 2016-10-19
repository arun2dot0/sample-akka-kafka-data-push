package akka.kafka.example.datapush.actors;


import akka.actor.ActorRef;
import akka.actor.Cancellable;
import akka.actor.OneForOneStrategy;
import akka.actor.SupervisorStrategy;
import akka.actor.SupervisorStrategy.Directive;
import akka.actor.Terminated;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.Function;
import akka.kafka.example.datapush.avro.schema.EmployeeSchema;
import akka.kafka.example.datapush.dao.Employee;
import akka.kafka.example.datapush.dao.service.MigrationUtil;
import akka.kafka.example.datapush.extension.SpringExtension;
import akka.kafka.example.datapush.repo.Employeerepository;
import akka.routing.ActorRefRoutee;
import akka.routing.Routee;
import akka.routing.Router;
import akka.routing.SmallestMailboxRoutingLogic;
import scala.concurrent.duration.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static akka.actor.SupervisorStrategy.escalate;
import static akka.actor.SupervisorStrategy.restart;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * A sample supervisor which should handle exceptions and general feedback for
 * the actual {@link com.equinix.akkaflow.actors.KafkaPushSupervisorActor}
 * <p/>
 * A router is configured at startup time, managing a pool of task actors.
 */

@Scope("prototype")
@javax.inject.Named("KafkaPushSupervisorActor")
public class KafkaPushSupervisorActor extends UntypedActor {

	private final LoggingAdapter log = Logging.getLogger(getContext().system(), "KafkaPushSupervisorActor");
	private static final int ROUTE_SIZE = 100;

	@Autowired
	private Employeerepository deliveryPrefRepository;

	@Autowired
	MigrationUtil migrationUtil;


	 @Autowired
	    private SpringExtension springExtension;
	private Router router;

	Cancellable kafkaScheduler;

	@Override
	public SupervisorStrategy supervisorStrategy() {
		return strategy;
	}

	private SupervisorStrategy strategy = new OneForOneStrategy(3, Duration.create("10 second"),
			new Function<Throwable, Directive>() {
				public Directive apply(Throwable t) {
					if (t instanceof java.net.SocketTimeoutException)
						return restart();
					else
						return escalate();
				}
			});

	private void initKafkaPush() throws Exception {
		List<Routee> routees = new ArrayList<Routee>();
		ActorRef childActor = getContext()
				.actorOf(springExtension.props("KafkaPushActor"));

		for (int i = 0; i < ROUTE_SIZE; i++) {
			getContext().watch(childActor);
			routees.add(new ActorRefRoutee(childActor));
		}
		router = new Router(new SmallestMailboxRoutingLogic(), routees);
		
	}

	public List<EmployeeSchema> readOutputData() {
	/*	Pageable limitOutput = new PageRequest(0, 10);
		List<com.equinix.pue.dao.model.OutputData> listOutputData = outptuDataRepository
				.findAll(new Sort(Sort.Direction.DESC, "readingTime")).subList(0, 9);*/
		 List<Employee> listOutputData = deliveryPrefRepository.findDatatoPush("N");
		 listOutputData.forEach(dp->System.out.println("Employee from db "+dp));
		return migrationUtil.copyOutputData(listOutputData);
	}

	private void routeChild(List<EmployeeSchema> listOutputData) {
		listOutputData.forEach(outputDataStream -> {
			router.route(outputDataStream, getSelf());
		});
	}

	@Override
	public void preStart() throws Exception {
		log.info("Starting up");
		initKafkaPush();
		super.preStart();
	}

	@Override
	public void postRestart(Throwable reason) {
	}

	@Override
	public void onReceive(Object message) throws Exception {

		if (message.equals("tick")) {
			log.info("got scheduler message");
			// send another periodic tick after the specified delay
			
			 kafkaScheduler =
			 getContext().system().scheduler().scheduleOnce(Duration.create(1,
			 TimeUnit.MINUTES), getSelf(), "tick", getContext().dispatcher(),
			  null);
			 
			routeChild(readOutputData());
		} else if (message instanceof EmployeeSchema) {
			router.route(message, getSender());
		} 
		 else if (message instanceof Terminated) {
			kafkaScheduler.cancel();
			log.error("Got Terminate message  {}", message);
		} else {
			log.error("Unable to handle message {}", message);
		}
	}

	@Override
	public void postStop() throws Exception {
		log.info("Shutting down");

		super.postStop();
	}
}