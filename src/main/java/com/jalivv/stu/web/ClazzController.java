package com.jalivv.stu.web;

import com.jalivv.stu.entity.Clazz;
import com.jalivv.stu.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/clazz")
public class ClazzController {


    @Autowired
    private ClazzService clazzService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Clazz> clazzList = clazzService.findAll();
        model.addAttribute("clazzes", clazzList);
        return "back/clazz/index";
    }
}
