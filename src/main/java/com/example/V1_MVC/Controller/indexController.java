package com.example.V1_MVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class indexController {

    @GetMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("inicio")
    public String inicio() {
        return "index";
    }

    @GetMapping("mision")
    public String mision() {
        return "mision"; // Esto carga mision.html desde templates
    }

    @GetMapping("vision")
    public String vision() {
        return "vision"; // Esto carga mision.html desde templates
    }

    @GetMapping("valores")
    public String valores() {
        return "valores"; // Esto carga mision.html desde templates
    }

    @GetMapping("servicios")
    public String servicios() {
        return "servicios"; // Esto carga mision.html desde templates
    }

    @GetMapping("dsbdStudents")
    public String dashboardStudents() {
        return "dashboard-students";
    }
}
