package akka.kafka.example.datapush.actors;

import akka.actor.ActorRef;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.kafka.example.datapush.avro.schema.EmployeeSchema;
import akka.kafka.example.datapush.dao.service.MigrationUtil;
import akka.kafka.example.datapush.extension.SpringExtension;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;


@Scope("prototype")
@javax.inject.Named("KafkaPushActor")
public class KafkaPushActor extends UntypedActor {

	
	private final LoggingAdapter log = Logging.getLogger(getContext().system(), "KafkaPushActor");

	@Autowired
	@Qualifier(value="inputToKafka")
	private MessageChannel channel;
	 @Autowired
	    private SpringExtension springExtension;
	
	@Autowired
	MigrationUtil migrationUtil;

	@Override
	public void preStart() {
		log.info("Starting up");
	}
	
	
	
	@Override
	public void onReceive(Object message) throws Exception {
		EmployeeSchema deliveryPrefOutput = (EmployeeSchema) message;
		log.info("Got Message to send");
		log.info(deliveryPrefOutput.toString());
	
		channel.send(MessageBuilder.withPayload(deliveryPrefOutput)
				.build());
		 ActorRef actor = getContext().actorOf(springExtension.props(
	                "MarkOutputSentActor"));
		actor.tell(migrationUtil.findOutput(deliveryPrefOutput), getSelf());
	}
	
	
}

