package com.jalivv.stu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

//班级实体对象
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Clazz {
    private String id;
    private String name;
    private String tagId;//标签外键

    private Tag tag;
}
