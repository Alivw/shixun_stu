package com.jalivv.stu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString
public class City {

    private Integer id;

    private String name;
    private Date createtime;


    /**
     * 就业人数
     */
    private Integer numbers;
}
