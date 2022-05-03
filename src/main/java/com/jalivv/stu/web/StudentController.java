package com.jalivv.stu.web;

import com.jalivv.stu.entity.Student;
import com.jalivv.stu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //查询学生列表
    @RequestMapping("/list")
    public String findAll(Model model,String searchCol,String searchValue){
        List<Student> students=studentService.findAll(searchCol,searchValue);
        //model作用域类型request
        model.addAttribute("students",students);
        model.addAttribute("searchCol", searchCol);
        model.addAttribute("searchValue", searchValue);
        return "back/student/index";
    }

}
