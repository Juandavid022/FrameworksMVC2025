package com.example.V1_MVC.DTO;

import lombok.Data;
import java.util.List;

@Data
public class StudentDashboardDTO {
    private String name;
    private String email;
    private String username;
    private String role;
    private List<ClassDTO> clases;

    @Data
    public static class ClassDTO {
        private String nombre;
        private String horario;
        private String notas;
        private String coach; //
    }
}
