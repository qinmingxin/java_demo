package com.qmx.activemq.controller;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class JmsTest extends BaseTest{
    @Autowired
    private JMSProducer jmsProducer;
 
    @Test 
    public void testJms() {
    	
        Destination destination = new ActiveMQQueue("springboot.queue.test");

        for (int i=0;i<10;i++) {
            jmsProducer.sendMessage(destination,"hello,world!" + i);
        }
    }
}