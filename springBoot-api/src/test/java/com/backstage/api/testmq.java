package com.backstage.api;

import com.backstage.base.service.impl.ActiveMqServiceImpl;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;


@RunWith(SpringRunner.class)
@SpringBootTest
public class testmq {

    @Autowired
    private ActiveMqServiceImpl producer;

    @Test
    public void contextLoads() throws InterruptedException {
        Destination destination = new ActiveMQQueue("dyqueue");

        for(int i=0; i<1; i++){
            producer.sendmsg(destination, "myname is chhliu!!!");
        }
    }
}
