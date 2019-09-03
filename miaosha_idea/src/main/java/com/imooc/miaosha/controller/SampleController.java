package com.imooc.miaosha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class SampleController {

    public String thymeleaf(Model model){
        model.addAttribute("name", "Joshua");
        return "hello";
    }



}
