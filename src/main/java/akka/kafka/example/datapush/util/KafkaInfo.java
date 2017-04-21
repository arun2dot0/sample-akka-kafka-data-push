package akka.kafka.example.datapush.util;

import java.util.logging.Logger;

public class KafkaInfo {
	
	Logger log = Logger.getLogger(KafkaInfo.class.getName());
	public void sentStatus(Object o )
	{
		log.info("Output from Kafka "+ o.toString());
	}

}
