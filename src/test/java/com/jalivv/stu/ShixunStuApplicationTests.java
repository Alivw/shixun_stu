package com.jalivv.stu;

import com.jalivv.stu.dao.CityDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShixunStuApplicationTests {

    @Autowired
    private CityDao cityDao;

    @Test
    void contextLoads() {
        cityDao.findAll().stream().forEach(System.out::println);
    }

}
