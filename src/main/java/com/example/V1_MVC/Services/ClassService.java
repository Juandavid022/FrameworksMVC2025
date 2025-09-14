package com.example.V1_MVC.Services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.V1_MVC.Model.ClassModel;

@Service
public interface ClassService {
    
    void deleteById(Long id);
    ClassModel listarId(Long id);
    ClassModel save(ClassModel coach);
    List<ClassModel> listar();    
    
    
}