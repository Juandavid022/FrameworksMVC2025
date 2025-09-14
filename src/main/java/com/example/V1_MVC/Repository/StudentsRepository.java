package com.example.V1_MVC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.V1_MVC.Model.StudentModel;


@Repository
public interface StudentsRepository extends JpaRepository<StudentModel, Long> {
}
