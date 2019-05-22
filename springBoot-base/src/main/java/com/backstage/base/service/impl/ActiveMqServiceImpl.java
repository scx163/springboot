package com.backstage.base.service.impl;

import com.backstage.base.service.ActiveMqService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

@Service
public class ActiveMqServiceImpl implements ActiveMqService {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;


    /*
     * 消息生产者
     */
    @Override
    public void sendmsg(Destination destination,String message){
        jmsMessagingTemplate.convertAndSend(destination, message);
    }
}