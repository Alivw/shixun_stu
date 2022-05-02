package com.jalivv.stu.dao;

import com.jalivv.stu.entity.Tag;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagDao extends BaseDao<Tag, Integer> {

}
