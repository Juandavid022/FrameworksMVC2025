package com.example.V1_MVC.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "class_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClassModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "El nombre no puede estar vacío")
    private String name; 

    
    @Column(nullable = false, unique = true)
    @NotBlank(message = "La fecha y hora no puede estar vacía")
    private LocalDateTime schedule;

    @ManyToOne
    @JoinColumn(name = "coaches_id", referencedColumnName = "id")
    @NotBlank(message = "El coach no puede estar vacío")
    private CoachModel coach;

    }