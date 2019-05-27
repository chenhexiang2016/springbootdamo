package com.study.demo.service.impl;

import com.study.demo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author: Chenhexiang
 * @Description:
 * @Date: 2019-05-12 00:26
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public String getList() {
       return "user list";
    }
}
