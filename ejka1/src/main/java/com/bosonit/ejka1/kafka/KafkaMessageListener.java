package com.bosonit.ejka1.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageListener {

    @KafkaListener(topics = "${message.topic.name:giovanni}", groupId = "${message.group.name:kafkagroup}")
    public void listenTopic1(String message) {
        System.out.println("Received Message of topic1 in  listener: " + message);
    }

    @KafkaListener(topics = "${message.topic.name2:laura}", groupId = "${message.group.name:kafkagroup}")
    public void listenTopic2(String message) {
        System.out.println("Received Message of topic2 in  listener " + message);
    }
}
