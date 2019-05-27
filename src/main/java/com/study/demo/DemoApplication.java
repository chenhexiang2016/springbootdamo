package com.study.demo;

import com.study.demo.service.impl.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =  SpringApplication.run(DemoApplication.class, args);
        String userserviceName = context.getBean("userService").getClass().getName();
        System.out.println("userserviceName:"+userserviceName);

        String orderserviceName = context.getBean("orderService").getClass().getName();
        System.out.println("orderserviceName:"+orderserviceName);
    }
}
