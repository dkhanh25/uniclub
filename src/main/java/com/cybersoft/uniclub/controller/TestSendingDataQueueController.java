package com.cybersoft.uniclub.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestSendingDataQueueController {
    @Autowired
    public RabbitTemplate rabbitTemplate;

    @GetMapping("")
    public ResponseEntity<?> testQueue() {
        rabbitTemplate.convertAndSend("excode04","/queuecode04","Hello queue from java coding");
        return new ResponseEntity<>("OK", HttpStatus.OK);

    }
}
