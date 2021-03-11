package com.udemy.spring.controller;

import com.udemy.spring.entity.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Value("#{countryOptions}")
    private Map<String, String> countryOptions;

    @Value("#{favouriteLanguages}")
    private Map<String, String> favouriteLanguages;

    @RequestMapping({"/showForm"})
    public String showForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("countryOptions", countryOptions);
        model.addAttribute("favouriteLanguages", favouriteLanguages);

        return "student-form";
    }

    @RequestMapping({"/processStudentForm"})
    public String processStudentForm(@ModelAttribute("student") Student student, Model model) {
        model.addAttribute("student", student);

        // log the input data
        System.out.println("student:  " + student.getFirstName() + " " + student.getLastName());

        return "student-confirmation";
    }


}
