package com.study.demo.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.study.demo.activemq.Producer;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.Destination;

@Controller
@RequestMapping(value = "/activemq")
public class ActivemqTestController {
    @Autowired
    private Producer producer;

    @RequestMapping("/produce")
    @ResponseBody
    public R produceTest() {
        Destination destination = new ActiveMQQueue("mytest.queue01");

        for(int i=0; i<100; i++){
            producer.sendMessage(destination, "myname is chx!!!");
        }

        return R.ok("Success");
    }


}
