package com.example.studentcourse.controller;

import com.example.studentcourse.model.Course;
import com.example.studentcourse.model.Student;
import com.example.studentcourse.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentCourseController {

    @Autowired
    private StudentCourseService service;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("students", service.getAllStudentsWithCourse());
        return "index";
    }

    @GetMapping("/addStudent")
    public String showAddStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("courses", service.getAllCourses());
        return "add-student";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        try {
            service.saveStudent(student);
        } catch (Exception e) {
            // Handle integrity violations or other exceptions
            return "redirect:/addStudent?error=IntegrityViolation";
        }
        return "redirect:/";
    }

    @GetMapping("/editStudent/{id}")
    public String showEditStudentForm(@PathVariable(value = "id") Long id, Model model) {
        Student student = service.getStudentById(id);
        model.addAttribute("student", student);
        model.addAttribute("courses", service.getAllCourses());
        return "update-student";
    }
}
