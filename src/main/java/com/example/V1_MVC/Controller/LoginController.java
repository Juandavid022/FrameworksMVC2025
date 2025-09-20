package com.example.V1_MVC.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    // Página de login
    @GetMapping("/login")
    public String login() {
        return "login"; // Debes tener un login.html en templates
    }

    // Redirección después del login según rol
    @GetMapping("/")
    public String defaultAfterLogin(Authentication authentication) {
        if (authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/inicio"; // Vista para admin
        } else if (authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_COACH"))) {
            return "redirect:/inicio"; // Vista para coach
        } else if (authentication.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_STUDENT"))) {
            return "redirect:/students/dashboard"; // Vista para estudiante
        }
        return "redirect:/"; // Redirección por defecto si no tiene rol
    }
}
