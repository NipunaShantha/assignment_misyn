package com.misyn.assignment.service.impl;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @KafkaListener(topics = "courierservice", groupId = "couriercompanygroup")
    public void consumerFromTopic(String message) {
        System.out.println(message);
    }
}
