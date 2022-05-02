package com.jalivv.stu.web;

import com.jalivv.stu.entity.Tag;
import com.jalivv.stu.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Tag> tagList = tagService.findAll();
        model.addAttribute("tags", tagList);
        return "back/tag/index";
    }


    @PostMapping("/save")
    public String save(Tag tag) {
        tagService.save(tag);
        return "redirect:/tag/list";
    }

    //根据标签的类型查询对应的标签信息
    @RequestMapping("/find/{type}")
    @ResponseBody
    public List<Tag> findByType(@PathVariable("type") String type){
        return tagService.findByType(type);
    }

}
