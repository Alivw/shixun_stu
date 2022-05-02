package com.jalivv.stu.web;


import com.jalivv.stu.entity.City;
import com.jalivv.stu.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/city")
@Controller
public class CityController {


    @Autowired
    private CityService cityService;

    @GetMapping("/list")
    public String findAll(Model model) {
        List<City> list = cityService.findAll();
        model.addAttribute("cities", list);
        return "back/city/index";
    }

    @PostMapping("/save")
    public String save(City city){
        //todo 参数验证
        if (StringUtils.isEmpty(city.getName())) {

        }
        cityService.save(city);
        return "redirect:/city/list";
    }
}
