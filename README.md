Sample Project for getting Data from MySQL  and pushing to Kafka using Akka Actor model . 

How to run .. 

1.Setup Mysql (5.6.5 or later ) with create table and load scripts
2.Run Kafka .. I run it in docker as its easier
3.Compile Project and Run

1. Setup MySql . 

Install Mysql and setup table with some data 

create table employee
( id MEDIUMINT NOT NULL AUTO_INCREMENT,
   first_name varchar(20),
  last_name  varchar(20),
  title     varchar(20),
  created_date DATETIME DEFAULT   CURRENT_TIMESTAMP,
  modified_date  DATETIME ON UPDATE CURRENT_TIMESTAMP,
  dat_sent_flag varchar(1) default 'N',
  PRIMARY KEY(id)
  );
  
 
  insert into employee( first_name , last_name , title) values ( 'Sundar', 'Pichai','ceo');
  insert into employee( first_name , last_name , title) values ( 'Ellen', 'Friedman','Architect');
  insert into employee( first_name , last_name , title) values ( 'Krzysztof', 'Otrebski','Akka Expert');
  insert into employee( first_name , last_name , title) values ( 'Martin', 'Odersky','Lead Scala Designer');
  insert into employee( first_name , last_name , title) values ( 'Patrick', 'McFadin','Cassandra Evangelist');
  insert into employee( first_name , last_name , title) values ( 'Dick', 'Wall ','Software Developer ');
  insert into employee( first_name , last_name , title) values ( 'Helena', 'EdelSon ','Big Data Engineer');
      
      
      Select * from employee
 
 
2. Setup Kafka in Docker 

Here are instructions to setup for  spotify/kafka , you can use kafka without docker as well

Docker ( using docker machine)

docker pull spotify/kafka

docker run --name mykafka -d -p 2181:2181 -p 9092:9092 --env ADVERTISED_HOST=$(docker-machine ip) --env ADVERTISED_PORT=9092 --env KAFKA_HEAP_OPTS="-Xmx256M -Xms128M"  --env ZK_CONNECT=kafka7zookeeper:2181/root/path  spotify/kafka


Create and Test Topic

docker run --rm spotify/kafka /opt/kafka_2.11-0.8.2.1/bin/kafka-topics.sh --create --zookeeper $(docker-machine ip):2181 --replication-factor 1 --partitions 1 --topic kafka_test
docker run --rm spotify/kafka /opt/kafka_2.11-0.8.2.1/bin/kafka-topics.sh --list --zookeeper $(docker-machine ip):2181

Debug messages in Topic

docker exec mykafka /bin/bash
( in the docker container execute the next command)
/opt/kafka_2.11-0.8.2.1/bin/kafka-console-consumer.sh --zookeeper localhost:2181 --topic kafka_test


3.Setup and Execute Project

Kafka is published in Avro format  . Its compressed and much faster than sending as String . 
Avro format in Employee.avsc

If you change the avro , delete the generated Schema class ( EmployeeSchema.java) and regenerate using mvn generate-sources


Compile using mvn clean install 

Run as mvn spring-boot:run



Generate Avro 
Example has the avro for Employee schema . Generated during maven generate-sources , update the schema for your use case



Execute the Project
mvn clean install
mvn spring:boot run 







