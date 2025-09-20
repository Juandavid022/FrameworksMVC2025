package com.example.V1_MVC.Controller;

import com.example.V1_MVC.Model.ClassModel;
import com.example.V1_MVC.Services.ClassService;
import com.example.V1_MVC.Services.CoachService;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@Tag(name = "Clases", description = "Operaciones sobre el manejo y recursos de las clases")
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
    @Operation(summary = "Registro de clases", description = "Permite el registro de nuevas clases en el sistema.")
    public String mostrarFormulario(Model model) {
        model.addAttribute("class", new ClassModel());
        model.addAttribute("coaches", coachService.listar()); 
        return "register-class";
    }

    @PostMapping("/save")
    @Operation(summary = "Guardar clase", description = "Guarda una nueva clase en el sistema.")
    public String guardar(@ModelAttribute ClassModel coach) {
        classService.save(coach);
        return "redirect:/class/list";
    }
    
    @GetMapping("/list")
    @Operation(summary = "Lista de clases", description = "Muestra la lista de todas las clases registradas en el sistema.")
    public String listar(Model model) {
        model.addAttribute("class", classService.listar());
        return "list-class";   }
}
