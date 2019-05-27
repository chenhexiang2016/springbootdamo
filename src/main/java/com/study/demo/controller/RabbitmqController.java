package com.study.demo.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.study.demo.rabbitmq.RabbitmqSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Chenhexiang
 * @Description:
 * @Date: 2019-05-27 13:44
 */
@Controller
@RequestMapping("/rabbitmq")
public class RabbitmqController {
    @Autowired
    private RabbitmqSenderService senderService;
    private String PREFIX = "/rabbitmq/";

    @RequestMapping("/test")
    @ResponseBody
    public R testCache() {
        // 测试广播模式
//        senderService.broadcast("同学们集合啦！");
        // 测试Direct模式
//        senderService.direct("定点消息");

        // 测试topic模式
        senderService.topic("topic.message！", "topic.message");
        senderService.topic("topic.messages！", "topic.messages");
        return R.ok("Success");
    }
}
