package com.jalivv.stu.dao;

import com.jalivv.stu.entity.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagDao extends BaseDao<Tag, Integer> {

    List<Tag> findByType(String type);
}
