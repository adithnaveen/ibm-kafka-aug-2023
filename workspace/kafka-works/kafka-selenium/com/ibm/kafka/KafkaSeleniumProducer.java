package com.ibm.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaSeleniumProducer {
	
	
	private String topic = "selenium-kafka-topic"; 
	
	public void postMessage(String message) {
		Properties prop = new Properties(); 
		prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName()); 
		prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
	
		// create producer 
		KafkaProducer<String, String> producer = new KafkaProducer<>(prop); 
		
		// create a record 
		
		ProducerRecord<String, String> producerRecord = 
				new ProducerRecord<String, String>(topic, message);  
		
		// attach the record to the producer  and send 
		producer.send(producerRecord); 
		
		// flush the producer to the the connection is closed 
		producer.flush(); 
		
		
		// finally closed 
		producer.close(); 
		
	}
}
