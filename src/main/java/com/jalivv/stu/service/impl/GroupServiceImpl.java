package com.jalivv.stu.service.impl;

import com.jalivv.stu.dao.GroupDao;
import com.jalivv.stu.entity.Group;
import com.jalivv.stu.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;

    @Override
    public List<Group> findAll() {

        return groupDao.findAll();
    }

    @Override
    public void save(Group group) {
        groupDao.save(group);
    }
}
