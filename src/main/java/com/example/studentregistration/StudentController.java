package com.example.studentregistration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    private final List<Student> students = new ArrayList<>();

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("students", students);
        return "index";
    }

    @PostMapping("/register")
    public String registerStudent(@ModelAttribute Student student, Model model) {
        students.add(student);
        model.addAttribute("student", new Student());
        model.addAttribute("students", students);
        model.addAttribute("successMessage", "Student registered successfully!");
        return "index";
    }
}