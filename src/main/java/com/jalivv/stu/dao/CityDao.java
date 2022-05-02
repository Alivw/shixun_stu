package com.jalivv.stu.dao;

import com.jalivv.stu.entity.City;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CityDao extends BaseDao<City, Integer> {

}
