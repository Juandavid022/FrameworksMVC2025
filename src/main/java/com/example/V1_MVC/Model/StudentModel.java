package com.example.V1_MVC.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @Column(nullable = false)
    private String birthday; 

    @Column(nullable = false)
    private String genere;

    @Column(nullable = false, length = 40, unique = true)
    @Email(message = "Debe ser un correo válido")
    @NotBlank(message = "El email es obligatorio")
    String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String status;


}