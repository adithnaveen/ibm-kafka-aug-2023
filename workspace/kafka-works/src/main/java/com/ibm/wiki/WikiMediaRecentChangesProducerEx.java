package com.ibm.wiki;

import java.net.URI;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.EventSource.Builder;
import com.launchdarkly.eventsource.MessageEvent;

public class WikiMediaRecentChangesProducerEx {
	
	private static final Logger logger = LoggerFactory.getLogger(WikiMediaRecentChangesProducerEx.class.getName()); 
	
	public static void main(String[] args) throws InterruptedException {
		final String URL = "https://stream.wikimedia.org/v2/stream/recentchange"; 
		final String TOPIC = "mediawiki.recentchange"; 
		final String BOOTSTRAP_SERVER = "localhost:9092"; 
		
		Properties prop = new Properties(); 
		prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,BOOTSTRAP_SERVER);
		prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName()); 
		prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
	
		// create producer 
		KafkaProducer<String, String> producer = new KafkaProducer<>(prop); 
		
		
		// the envent handler will help me to trigger when the event occurs 
		// especially when a message arrives 
		
		
		EventHandler eventHandler = new WikiEventHandler(producer, TOPIC); 
		
		// ctrl + 2 + l 
		Builder builder = new EventSource.Builder(eventHandler, URI.create(URL)); 
		
		EventSource eventSource  = builder.build(); 
		
		eventSource.start(); 
		
		TimeUnit.MINUTES.sleep(2);
		
	}
}
