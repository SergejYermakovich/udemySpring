package com.udemy.spring.controller;

import com.udemy.spring.entity.Student;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    //    @Value("#{countryOptions}")
    static Map<String, String> countryOptions = new HashMap<>();

    //    @Value("#{favouriteLanguages}")
    static Map<String, String> favouriteLanguages = new HashMap<>();

    static {
        countryOptions.put("BR","Brazil");
        countryOptions.put("FR","France");
        countryOptions.put("DE","Germany");
        countryOptions.put("US","USA");

        favouriteLanguages.put("Java","Java");
        favouriteLanguages.put("C++","C++");
        favouriteLanguages.put("Python","Python");
    }

    @RequestMapping({"/showForm"})
    public String showForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("countryOptions", countryOptions);
        model.addAttribute("favouriteLanguages", favouriteLanguages);

        return "student-form";
    }

    @RequestMapping({"/processStudentForm"})
    public String processStudentForm(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "student-form";
        }
        // log the input data
        System.out.println("student:  " + student.getFirstName() + " " + student.getLastName());

        return "student-confirmation";
    }


}
