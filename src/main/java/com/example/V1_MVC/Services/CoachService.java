package com.example.V1_MVC.Services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.V1_MVC.Model.CoachModel;

@Service
public interface CoachService {
    
    void deleteById(Long id);
    CoachModel listarId(Long id);
    CoachModel save(CoachModel coach);
    List<CoachModel> listar();    
    
}