package com.jalivv.stu.dao;

import com.jalivv.stu.entity.Group;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GroupDao extends BaseDao<Group,Integer>{
    List<Group> findByClazzId(String id);
}
