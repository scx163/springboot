package com.backstage.base.service;


import javax.jms.Destination;

public interface ActiveMqService {
    void sendmsg(Destination destination, String msg);
}