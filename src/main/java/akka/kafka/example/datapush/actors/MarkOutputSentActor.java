package akka.kafka.example.datapush.actors;


import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.kafka.example.datapush.dao.Employee;
import akka.kafka.example.datapush.dao.service.MigrationUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Scope("prototype")
@javax.inject.Named("MarkOutputSentActor")
public class MarkOutputSentActor extends UntypedActor {

	private final LoggingAdapter log = Logging.getLogger(getContext().system(), "MarkOutputSentActor");

	@Autowired
	MigrationUtil migrationUtil;

	@Override
	@Transactional
	public void onReceive(Object message) throws Exception {
	
			Employee output = (Employee) message;
			output.setDataSentFlag("Y");
			migrationUtil.persistOutput(output);
			log.info("Output Marked as Sent ");

	}
}
