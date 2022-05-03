package com.jalivv.stu.service.impl;

import com.jalivv.stu.dao.StudentDao;
import com.jalivv.stu.entity.Student;
import com.jalivv.stu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;


    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    public List<Student> findAll(String searchCol, String searchValue, Integer pageNo, Integer pageSize) {
        Integer start = (pageNo - 1) * pageSize;
        return studentDao.findAll(searchCol,searchValue,start,pageSize);
    }
    @Override
    public void save(Student student) {

    }

    @Override
    public Integer counts(String searchCol, String searchValue) {
        return studentDao.counts(searchCol, searchValue);
    }
}
