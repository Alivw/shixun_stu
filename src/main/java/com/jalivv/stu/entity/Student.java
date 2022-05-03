package com.jalivv.stu.entity;

import lombok.AllArgsConstructor;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class Student {

    private String  id;
    private String  name;
    private Integer age;
    private Date bir;
    private String phone;
    private String qq;
    //生肖
    private String attr;
    //星座
    private String starts;
    //备注
    private String mark;
    //城市id
    private String cityId;
    //班级id
    private String clazzId;
    //小组id
    private String groupId;


    private Clazz clazz;//定义一个班级对象用来保存当前学生所在的班级信息
    //在实体类中添加一个城市对象
    private City city;  //定义一个城市对象用来保存当前学生的就业城市信息

    private Group group;//定义一个小组对象用来保存当前学生所属小组信息

    private List<Tag> tags;//定义一个集合用来保存学生所对应的标签信息
}
