package com.bosonit.ejka1.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    @Autowired
    KafkaMessageProducer kafkaMessageProducer;

    @PostMapping("/add/{topic}")
    public ResponseEntity<String> addCustomer(@PathVariable("topic") String topic, @RequestBody String message) {
        try {
            kafkaMessageProducer.sendMessage(topic, message);
            return ResponseEntity.status(HttpStatus.OK).body("Message sent [" + message + "]");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error! Message could not be sent");
        }
    }
}