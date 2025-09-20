package com.example.V1_MVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@RequestMapping("/")
@Tag(name = "Index", description = "Operaciones para la gestión de las paginas basicas de la aplicacion")
public class indexController {

    @GetMapping("index")
    @Operation(summary = "Página de inicio", description = "Muestra la página de inicio de la aplicación.")
    public String index() {
        return "index";
    }

    @GetMapping("inicio")
    @Operation(summary = "Página de inicio", description = "Muestra la página de inicio de la aplicación.")
    public String inicio() {
        return "index";
    }

    @GetMapping("mision")
    @Operation(summary = "Página de mision", description = "Muestra la página de la mision de la compañia.")
    public String mision() {
        return "mision";
    }

    @GetMapping("vision")
    @Operation(summary = "Página de visión", description = "Muestra la página de la visión de la compañia.")
    public String vision() {
        return "vision";
    }

    @GetMapping("valores")
    @Operation(summary = "Página de valores", description = "Muestra la página de los valores que rigen a la compañia.")
    public String valores() {
        return "valores";
    }

    @GetMapping("servicios")
    @Operation(summary = "Página de servicios", description = "Muestra la página de los servicios que ofrece la compañia.")
    public String servicios() {
        return "servicios";
    }

    @GetMapping("dsbdStudents")
    @Operation(summary = "Dashboard estudiantes", description = "Muestra la página de inicio para los estudiantes.")
    public String dashboardStudents() {
        return "dashboard-students";
    }
}
