package com.jalivv.stu.service;

import com.jalivv.stu.entity.Tag;

import java.util.List;

public interface TagService extends IService<Tag> {
    List<Tag> findByType(String type);

    void delete(List<Integer> ids);
}
