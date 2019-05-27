package com.study.demo.service.impl;

import org.springframework.stereotype.Service;

/**
 * @Author: Chenhexiang
 * @Description:
 * @Date: 2019-05-12 00:44
 */
@Service("orderService")
public class OrderImpl {
    public void getList() {
        System.out.println("order list");
    }
}
