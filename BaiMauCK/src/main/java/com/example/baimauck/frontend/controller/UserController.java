package com.example.baimauck.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guys")
public class UserController {
    @GetMapping("")
    public String show(Model model){
        return "guys";
    }

}
