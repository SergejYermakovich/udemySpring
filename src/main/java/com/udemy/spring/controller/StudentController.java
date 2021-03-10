package com.udemy.spring.controller;

import com.udemy.spring.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping({"/showForm"})
    public String showForm(Model model) {
        System.out.println("showForm");

        Student student = new Student();
        model.addAttribute("student" , student);

        return "student-form";//student-form
    }

    @RequestMapping({"/processStudentForm"})
    public String processStudentForm(@ModelAttribute("student") Student student) {

        System.out.println("processStudentForm");
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return "student-confirmation";
    }



}
