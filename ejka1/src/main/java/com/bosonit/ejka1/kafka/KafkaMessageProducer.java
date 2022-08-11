package com.bosonit.ejka1.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import org.springframework.kafka.support.SendResult;

import java.util.ArrayList;

@Component
public class KafkaMessageProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value(value = "${message.topic.name:giovanni}")
    private String topicName;

    public void sendMessage(String topic, String message) {
        if (topic == null || topic.trim().equals("")) {
            topic = topicName;
        }
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable exception) {
                System.out.println("Unable to send message [" + message + "] due to: " + exception.getMessage());
            }
            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Sent message [" + message + "] with offset [" + result.getRecordMetadata().offset() + "]");
            }
        });
    }
}