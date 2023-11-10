package com.ngu.restclienttemplate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestController {

    @GetMapping(value = "/welcome")
    public String welcome(Model model) {
        model.addAttribute("data", "Привет");
        return "welcome";
    }

}
