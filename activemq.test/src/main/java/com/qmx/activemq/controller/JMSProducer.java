package com.qmx.activemq.controller;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JMSProducer {
	
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(Destination destination,String message) {
        this.jmsTemplate.convertAndSend(destination,message);
    }
}