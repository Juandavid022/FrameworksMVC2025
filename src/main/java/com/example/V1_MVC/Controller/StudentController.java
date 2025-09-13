package com.example.V1_MVC.Controller;

import com.example.V1_MVC.Model.StudentModel;

import com.example.V1_MVC.Services.StudentService;


import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@Tag(name = "students", description = "Operaciones sobre el manejo y recursos de los estudiantes")
@RequestMapping("/students")
@CrossOrigin(origins = "*")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/register")
    public String mostrarFormulario(Model model) {
        model.addAttribute("students", new StudentModel());
        return "register-student";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute StudentModel student) {
        studentService.save(student);
        return "redirect:/index";
    }

    @GetMapping("/list")
    public String listar(Model model) {
        model.addAttribute("student", studentService.listar());
        return "list-students";   }
}
