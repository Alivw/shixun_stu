package com.jalivv.stu.service.impl;

import com.jalivv.stu.dao.CityDao;
import com.jalivv.stu.entity.City;
import com.jalivv.stu.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {


    private static final Logger logger = LoggerFactory.getLogger(CityServiceImpl.class);


    @Autowired
    private CityDao cityDao;

    @Override
    public List<City> findAll() {

        return cityDao.findAll();

    }

    @Override
    public void save(City city) {
        cityDao.save(city);
    }
}
