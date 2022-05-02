package com.jalivv.stu.service.impl;

import com.jalivv.stu.dao.ClazzDao;
import com.jalivv.stu.entity.Clazz;
import com.jalivv.stu.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzDao clazzDao;

    @Override
    public List<Clazz> findAll() {
        return clazzDao.findAll();
    }

    @Override
    public void save(Clazz clazz) {

    }
}
