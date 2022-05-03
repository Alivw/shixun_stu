package com.jalivv.stu.service;

import com.jalivv.stu.entity.Group;

import java.util.List;

public interface GroupService extends IService<Group>{
    List<Group> findByClazzId(String id);
}
