package akka.kafka.example.datapush.configuration;

import akka.actor.ActorSystem;
import akka.kafka.example.datapush.extension.SpringExtension;
import kafka.utils.ZkUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.SmartLifecycle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.expression.common.LiteralExpression;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.kafka.outbound.KafkaProducerMessageHandler;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.messaging.MessageHandler;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
//import org.springframework.integration.kafka.serializer.avro.AvroDatumSupport;
//import org.springframework.integration.kafka.serializer.avro.AvroReflectDatumBackedKafkaDecoder;

import kafka.admin.AdminUtils;
import kafka.common.TopicExistsException;
import kafka.utils.ZKStringSerializer$;
import kafka.utils.ZkUtils;
import org.I0Itec.zkclient.ZkClient;



@Configuration
@Lazy
@EnableIntegration
//@PropertySource("classpath:application.properties")
@EnableAutoConfiguration(exclude = HibernateJpaAutoConfiguration.class)
@EnableJpaRepositories(basePackages = {"akka.kafka.example.datapush.repo"})
@ComponentScan(basePackages ={"akka.kafka.example.datapush.configuration","akka.kafka.example.datapush.dao.service","akka.kafka.example.datapush.extension","akka.kafka.example.datapush.actors"})
@EntityScan(basePackages = {"akka.kafka.example.datapush.dao"})
@EnableTransactionManagement
@ImportResource({"classpath:outbound-kafka-integration.xml"})
public class ApplicationConfiguration {

    // The application context is needed to initialize the Akka Spring
    // Extension
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private SpringExtension springExtension;

    /**
     * Actor system singleton for this application.
     */
    @Bean
    public ActorSystem actorSystem() {

        ActorSystem system = ActorSystem
            .create("AkkaDataMigrationPush", akkaConfiguration());
        // Initialize the application context in the Akka Spring Extension
        springExtension.initialize(applicationContext);
        return system;
    }

    /**
     * Read configuration from application.conf file
     */
    @Bean
    public Config akkaConfiguration() {
        return ConfigFactory.load();
    }

  
    
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
       JpaTransactionManager transactionManager = new JpaTransactionManager();
       transactionManager.setEntityManagerFactory(emf);
  
       return transactionManager;
    }
    
   
}
