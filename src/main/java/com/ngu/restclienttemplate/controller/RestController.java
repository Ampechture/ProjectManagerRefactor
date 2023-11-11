package com.ngu.restclienttemplate.controller;

import com.ngu.restclienttemplate.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestController {

    @Autowired
    private GroupService groupService;

    @GetMapping(value = "/")
    public String redirect() {
        return "redirect:/main";
    }

    @GetMapping(value = "/main")
    public String welcome(Model model) {
        model.addAttribute("data", "Привет");
        return "main";
    }

    @GetMapping(value = "list/groups")
    private String getListGroup(Model model) {
        model.addAttribute("groups", groupService.getGroups());
        return "group-list";
    }

    @GetMapping(value = "list/students")
    private String getListStudent(Model model) {
        model.addAttribute("students", groupService.generateMockStudents(null));
        return "student-list";
    }


}
