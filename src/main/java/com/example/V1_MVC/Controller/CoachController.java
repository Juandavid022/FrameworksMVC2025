package com.example.V1_MVC.Controller;

import com.example.V1_MVC.Model.CoachModel;
import com.example.V1_MVC.Services.CoachService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@Tag(name = "Instructores", description = "Operaciones sobre el manejo y recursos de los instructores de patinaje")
@RequestMapping("/coach")
@CrossOrigin(origins = "*")
public class CoachController {

    private final CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping("/register")
    @Operation(summary = "Registro de instructores", description = "Permite el registro de nuevos instructores en el sistema.")
    public String mostrarFormulario(Model model) {
        model.addAttribute("coach", new CoachModel());
        return "register-coach";
    }

    @PostMapping("/save")
    @Operation(summary = "Guardar instructor", description = "Guarda un nuevo instructor en el sistema.")
    public String guardar(@ModelAttribute CoachModel coach) {
        coachService.save(coach);
        return "redirect:/coach/list";
    }
    
    @GetMapping("/list")
    @Operation(summary = "Lista de instructores", description = "Muestra la lista de todos los instructores registrados en el sistema.")
    public String listar(Model model) {
        model.addAttribute("coaches", coachService.listar());
        return "list-coaches";   }
}
