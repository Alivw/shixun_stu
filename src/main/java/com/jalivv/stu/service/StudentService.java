package com.jalivv.stu.service;

import com.jalivv.stu.entity.Student;

import java.util.List;

public interface StudentService extends IService<Student> {


    List<Student> findAll(String searchCol, String searchValue);
}
