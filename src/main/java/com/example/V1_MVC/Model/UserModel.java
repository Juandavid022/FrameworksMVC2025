package com.example.V1_MVC.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Entity
@Table(name = "users_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    @NotBlank(message = "El nombre de usuario es obligatorio")
    private String username;

    @Column(nullable = false, length = 40, unique = true)
    @Email(message = "Debe ser un correo válido")
    @NotBlank(message = "El email es obligatorio")
    String email;

    @NotBlank(message = "La contraseña es obligatoria 🔐")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    @Column(nullable = false, length = 100)
    private String password;

    @Enumerated(EnumType.STRING) 
    @Column(nullable = false)
    private Role role;
}
