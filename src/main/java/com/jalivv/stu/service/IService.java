package com.jalivv.stu.service;

import java.util.List;

public interface IService<T> {

    List<T> findAll();

    void save(T t);

}
