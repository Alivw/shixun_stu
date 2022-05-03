package com.jalivv.stu.service;

import com.jalivv.stu.entity.Student;

import java.util.List;

public interface StudentService extends IService<Student> {


    List<Student> findAll(String searchCol, String searchValue, Integer pageNo, Integer pageSize);

    //根据条件查询学生的总记录数
    Integer counts(String searchCol,String searchValue);
}
