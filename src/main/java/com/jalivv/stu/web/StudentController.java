package com.jalivv.stu.web;

import com.jalivv.stu.entity.Student;
import com.jalivv.stu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Currency;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //查询学生列表
    @RequestMapping("/list")
    public String findAll(Model model,String searchCol,String searchValue,Integer pageNo){
        pageNo = pageNo == null ? 1 : pageNo;

        Integer pageSize = 2;
        List<Student> students=studentService.findAll(searchCol,searchValue,pageNo,pageSize);

        Integer counts = studentService.counts(searchCol, searchValue);
        Integer pages = counts % pageSize == 0 ? counts / pageSize : counts / pageSize + 1;

        //model作用域类型request
        model.addAttribute("students",students);
        model.addAttribute("page",pageNo);
        model.addAttribute("pages",pages);
        model.addAttribute("counts",counts);
        //设置searchCol和searchValue在request域中进行数据的回显
        model.addAttribute("searchCol", searchCol);
        model.addAttribute("searchValue", searchValue);
        return "back/student/index";
    }

}
