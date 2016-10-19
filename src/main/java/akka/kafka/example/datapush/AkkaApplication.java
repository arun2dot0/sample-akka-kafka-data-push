package akka.kafka.example.datapush;


import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.kafka.example.datapush.configuration.ApplicationConfiguration;
import akka.kafka.example.datapush.extension.SpringExtension;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.integration.config.EnableIntegration;


/**
 * Tool to trigger messages passed to actors.
 */


@SpringBootApplication
public class AkkaApplication {

    public static void main(String[] args) throws Exception {

        ApplicationContext context =
            SpringApplication.run(AkkaApplication.class, args);

        ActorSystem system = context.getBean(ActorSystem.class);

        final LoggingAdapter log = Logging.getLogger(system, "AkkaApplication");

        log.info("Starting up");

        SpringExtension ext = context.getBean(SpringExtension.class);


        
      ActorRef supervisor = system.actorOf(
      ext.props("KafkaPushSupervisorActor"));
      supervisor.tell("tick", null);
      log.info("Started Supervisor");
      
      while (!supervisor.isTerminated()) {
          Thread.sleep(100);
      }

   
      log.info("Shutting down");

      system.shutdown();
      system.awaitTermination();
        

    }
}
