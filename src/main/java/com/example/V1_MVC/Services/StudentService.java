package com.example.V1_MVC.Services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.V1_MVC.Model.StudentModel;

@Service
public interface StudentService {
    
    void deleteById(Long id);
    StudentModel listarId(Long id);
    StudentModel save(StudentModel student);
    List<StudentModel> listar();    
    
}