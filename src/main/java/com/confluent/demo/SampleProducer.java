package com.confluent.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class SampleProducer {

    @Autowired
    private final KafkaTemplate<Integer, String> template = null;

    @Value("${test-topic}")
    private String testTopic;

    @PostMapping(value = "/messages")
    public void sendMessages() {
        
        System.out.println("Sending Test Message");
        template.send(testTopic, 1, "Test Message");

    }

}
