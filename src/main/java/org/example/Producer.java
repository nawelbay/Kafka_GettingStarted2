package org.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class Producer {
    public static void main(String[] args) throws InterruptedException {
        String topicName = "test-topic";

        Properties props = new Properties();
        props.put("bootstrap.servers", "kafka:9092"); // Kafka hostname and port
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        org.apache.kafka.clients.producer.Producer<String, String> producer = new KafkaProducer<>(props);
  while(true) {


      for (int i = 0; i < 10; i++) {
          producer.send(new ProducerRecord<>(topicName, Integer.toString(i), "Message " + i));
          System.out.println("Sent message: " + i);
          Thread.sleep(1000);
      }
  }

    }
}