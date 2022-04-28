package com.jalivv.stu.service;

import com.jalivv.stu.entity.Result;
import com.jalivv.stu.entity.User;

public interface UserService {

    Result register(User user,String code);

    User getUserByName(String name);

}
