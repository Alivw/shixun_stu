package com.jalivv.stu.dao;

import com.jalivv.stu.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentDao extends BaseDao<Student,Integer>{


    List<Student> findAll(@Param("col") String searchCol, @Param("val") String searchValue);
}
