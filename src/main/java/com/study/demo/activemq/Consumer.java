package com.study.demo.activemq;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * activemq支持两种模式：点对点模式，发布/订阅模式
 * MOM, JMS
 */
//@Component
public class Consumer {
    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
//    @JmsListener(destination = "mytest.queue01")
    public void receiveQueue(String text) {
        System.out.println("Consumer收到的报文为:"+text);
    }

}
