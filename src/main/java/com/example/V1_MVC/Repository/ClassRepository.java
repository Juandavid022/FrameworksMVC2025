package com.example.V1_MVC.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.V1_MVC.Model.ClassModel;
import com.example.V1_MVC.Model.CoachModel;


@Repository
public interface ClassRepository extends JpaRepository<ClassModel, Long> {
    Optional<ClassModel> findByCoach(CoachModel coach);

    // Buscar clase por coach y horario
    Optional<ClassModel> findByCoachAndSchedule(CoachModel coach, LocalDateTime schedule);
    
}
