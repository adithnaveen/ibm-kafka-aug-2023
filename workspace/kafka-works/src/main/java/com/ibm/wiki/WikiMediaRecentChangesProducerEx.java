package com.ibm.wiki;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WikiMediaRecentChangesProducerEx {
	
	private static final Logger logger = LoggerFactory.getLogger(WikiMediaRecentChangesProducerEx.class.getName()); 
	
	public static void main(String[] args) {
		final String URL = "https://stream.wikimedia.org/v2/stream/recentchange"; 
		final String TOPIC = "mediawiki.recentchange"; 
		final String BOOTSTRAP_SERVER = "localhost:9092"; 
		
		Properties prop = new Properties(); 
		prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,BOOTSTRAP_SERVER);
		prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName()); 
		prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
	
		// create producer 
		KafkaProducer<String, String> producer = new KafkaProducer<>(prop); 
		
	}
}
