package com.study.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    private String PREFIX = "/user/";
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/user-list")
    @ResponseBody
    public Object userList() {
        HashMap hashMap = new HashMap();
        hashMap.put("codse", 111);
        hashMap.put("msg", "成功");
        return hashMap;
    }

    @RequestMapping("/")
    public String index() throws Exception{
//        new Thread().sleep(1000*10);
        return PREFIX+"index";
    }


}
