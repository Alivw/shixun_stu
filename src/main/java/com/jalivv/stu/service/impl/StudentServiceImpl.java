package com.jalivv.stu.service.impl;

import com.jalivv.stu.dao.StudentDao;
import com.jalivv.stu.entity.Student;
import com.jalivv.stu.service.StudentService;
import com.jalivv.stu.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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
        //计算年龄
        int age = DateUtil.getAge(student.getBir());
        student.setAge(age);
        //计算生肖和星座
        String attr = DateUtil.getYear(Integer.valueOf(new SimpleDateFormat("yyyy").format(student.getBir())));
        student.setAttr(attr);
        String starts = DateUtil.getConstellation(student.getBir());
        student.setStarts(starts);
        //保存学生
        studentDao.save(student);
    }

    @Override
    public Integer counts(String searchCol, String searchValue) {
        return studentDao.counts(searchCol, searchValue);
    }
}
