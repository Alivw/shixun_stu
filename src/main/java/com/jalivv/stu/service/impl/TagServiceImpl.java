package com.jalivv.stu.service.impl;

import com.jalivv.stu.dao.TagDao;
import com.jalivv.stu.entity.Tag;
import com.jalivv.stu.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Override
    public List<Tag> findAll() {

        return tagDao.findAll();
    }

    @Override
    public void save(Tag tag) {
        tag.setCreatetime(new Date());
        tagDao.save(tag);
    }

    @Override
    public List<Tag> findByType(String type) {
        return tagDao.findByType(type);

    }

    @Override
    public void delete(List<Integer> ids) {
        Integer row = tagDao.delete(ids);
        if (row == 0) {
            throw new RuntimeException("删除的记录不存在");
        }
    }
}
