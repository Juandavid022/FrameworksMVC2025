package com.example.V1_MVC.Controller;

import com.example.V1_MVC.Model.ClassModel;
import com.example.V1_MVC.Services.ClassService;
import com.example.V1_MVC.Services.CoachService;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@Tag(name = "class", description = "Operaciones sobre el manejo y recursos de las clases")
@RequestMapping("/class")
@CrossOrigin(origins = "*")
public class ClassController {

    @Autowired
    private final ClassService classService;

    @Autowired
    private final CoachService coachService;


    public ClassController(ClassService classService, CoachService coachService) {
        this.classService = classService;
        this.coachService = coachService;
    }


    @GetMapping("/register")
    public String mostrarFormulario(Model model) {
        model.addAttribute("class", new ClassModel());
        model.addAttribute("coaches", coachService.listar()); 
        return "register-class";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute ClassModel coach) {
        classService.save(coach);
        return "redirect:/class/list";
    }
    
    @GetMapping("/list")
    public String listar(Model model) {
        model.addAttribute("class", classService.listar());
        return "list-class";   }
}
