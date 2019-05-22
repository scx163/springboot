package com.backstage.api;

import java.util.Date;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class testmq2 {

    private static final String USERNAME = "admin"; //用户名
    private static final String PASSWORD = "admin";  //密码
    private static final String BROKENURL = "tcp://119.29.193.239:61616";
    private static final String Q_NAME = "MessageQueue";  //消息队列

    @Test
    public void contextLoads() {
        ConnectionFactory connectionFactory;
        Connection connection;
        Session session;
        Destination destination;
        MessageProducer producer;
        connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKENURL);
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
            destination = session.createQueue(Q_NAME);
            producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            for(int i=0;i<1;i++){
                //发送消息
                producer.send(session.createTextMessage("【"+i+"】MQTT测试你有一份收文《测试标题》需要及时处理！+"+new Date()));
            }
            producer.close();
            System.out.println("消息发送完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
