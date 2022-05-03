package com.jalivv.stu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain=true)
public class Group {
    private String id;
    private String name;
    private String content;
    private String clazzId;

    private Clazz clazz;//用来保存当前小组班级信息
}

