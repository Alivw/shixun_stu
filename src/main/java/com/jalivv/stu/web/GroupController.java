package com.jalivv.stu.web;

import com.jalivv.stu.entity.Clazz;
import com.jalivv.stu.entity.Group;
import com.jalivv.stu.service.ClazzService;
import com.jalivv.stu.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/group")
public class GroupController {
    @Autowired
    private GroupService groupService;


    @Autowired
    private ClazzService clazzService;


    @RequestMapping("/list")
    public String findAll(Model model) {
        List<Group> groups = groupService.findAll();
        //System.out.println("groups = " + groups);
        model.addAttribute("groups", groups);
        return "back/group/index";

    }


    @PostMapping("/save")
    public String save(Group group) {
        groupService.save(group);
        return "redirect:/group/list";
    }

    //根据班级id查询小组信息
    @RequestMapping("findByClazzId")
    @ResponseBody
    public List<Group> findByClazzId(String id){
        return groupService.findByClazzId(id);
    }
}
