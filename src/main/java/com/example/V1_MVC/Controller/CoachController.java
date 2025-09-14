package com.example.V1_MVC.Controller;

import com.example.V1_MVC.Model.CoachModel;
import com.example.V1_MVC.Services.CoachService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@Tag(name = "coach", description = "Operaciones sobre el manejo y recursos de los instructores de patinaje")
@RequestMapping("/coach")
@CrossOrigin(origins = "*")
public class CoachController {

    private final CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping("/register")
    public String mostrarFormulario(Model model) {
        model.addAttribute("coach", new CoachModel());
        return "register-coach";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute CoachModel coach) {
        coachService.save(coach);
        return "redirect:/coach/list";
    }
    
    @GetMapping("/list")
    public String listar(Model model) {
        model.addAttribute("coaches", coachService.listar());
        return "list-coaches";   }
}
