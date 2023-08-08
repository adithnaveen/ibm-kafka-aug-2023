package com.ibm.training;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerExample2 {

	private static final Logger logger = LoggerFactory.getLogger(ProducerExample2.class);

	public static void main(String[] args) {

		final String host = "localhost";
		final String port = "9092";

		// set all the properties then given it to kafka producer
		// more configurations if needed can be loaded here
		Properties prop = new Properties();
		prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, host + ":" + port);
		prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		// create producer
		KafkaProducer<String, String> producer = new KafkaProducer<>(prop);

		// create a record

		for (int i = 0; i < 100; i++) {
			ProducerRecord<String, String> producerRecord = 
					new ProducerRecord<String, String>("topic-partition-3",
					"hello from java" + i);

			// attach the record to the producer and send
			producer.send(producerRecord);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			logger.info("Record sent to kafka");
		}

		// flush the producer to the the connection is closed
		producer.flush();

		// finally closed
		producer.close();

	}
}
