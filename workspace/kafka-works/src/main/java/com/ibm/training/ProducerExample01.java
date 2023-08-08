package com.ibm.training;

import java.util.Properties;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerExample01 {
	
	private static final Logger logger = LoggerFactory.getLogger(ProducerExample01.class); 
	
	public static void main(String[] args) {
		logger.info("Hello logger");
		
		final String host = "localhost";
		final String port = "9092";
		
		
		// set all the properties then given it to kafka producer 
		
		Properties prop = new Properties(); 
		prop.put("bootstrap.servers", host +":"+port);
		prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName()); 
		prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		
		// more configurations if needed can be loaded here 
		
		
		// create producer 
		
		// create a record 
		
		// attache the record to the producer  and send 
		
		// flush the producer to the the connection is closed 
		
		// finally closed 
		
		
		
		
	}
}
