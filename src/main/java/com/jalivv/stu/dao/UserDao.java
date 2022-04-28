package com.jalivv.stu.dao;

import com.jalivv.stu.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    void register(User user);

    User getUserByUserName(String name);
}
