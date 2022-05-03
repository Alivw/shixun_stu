package com.jalivv.stu.dao;

import java.util.List;

// T ：操作对象的类型，K 主键的类型
public interface BaseDao<T, K> {
    void save(T t);

    void update(T t);

    Integer delete(List<K> ks);

    T findById(K k);

    List<T> findAll();

    List<T> findByPage(Integer pageNo, Integer pageSize);

    Long findCounts();
}
