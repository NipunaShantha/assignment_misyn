package com.misyn.assignment.service.impl;

import com.misyn.assignment.repository.CourierCompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProducerService {
    public static final String topic = "courierservice";

    public static final String message = "This is just a test message to Courier Company";

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final JavaMailSender mailSender;
    private final CourierCompanyRepository companyRepository;

    public String publishTopic(String companyCode) {
        this.kafkaTemplate.send(topic, message);
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(companyRepository.findCourierCompanyByCompanyCode(companyCode).getCompanyEmail());
        mailMessage.setFrom("");
        mailMessage.setText(message);
        mailSender.send(mailMessage);
        return null;
    }
}
