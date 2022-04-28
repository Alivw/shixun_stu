package com.jalivv.stu.service.impl;

import com.jalivv.stu.dao.UserDao;
import com.jalivv.stu.entity.Result;
import com.jalivv.stu.entity.User;
import com.jalivv.stu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public Result register(User user, String code) {



        // 查询 用户名是否存在
        User u = getUserByName(user.getName());
        if (u != null) {
            throw new RuntimeException("该用户已存在");
        }
        user.setRegtime(new Date());
        user.setStatus(1);
        userDao.register(user);
        return new Result().setMessage("注册成功").setStatus(true);
    }

    @Override
    public User getUserByName(String name) {
        return userDao.getUserByUserName(name);
    }
}
