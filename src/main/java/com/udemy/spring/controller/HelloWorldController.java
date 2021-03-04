package com.udemy.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({"/hello"})
public class HelloWorldController {

    @RequestMapping({"/showForm"})
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping({"/processForm"})
    public String processForm(@RequestParam("studentName") String name, Model model) {
        model.addAttribute("studentName", name);
        return "helloworld";
    }

    @RequestMapping({"/processForm_v2"})
    public String letsShoutDude(HttpServletRequest request, Model model) {
        String name = request.getParameter("studentName");
        String greeting = "Yo, " + name.toUpperCase() + "!!!";
        model.addAttribute("studentName", name);
        model.addAttribute("greeting", greeting);
        return "helloworld";
    }

    @RequestMapping({"/processForm_v3"})
    public String processForm_v3(@RequestParam("studentName") String studentName, Model model) {
        String greeting = "hey from v3, " + studentName.toUpperCase() + "!!!";
        model.addAttribute("studentName", studentName);
        model.addAttribute("greeting", greeting);
        return "helloworld";
    }
}
