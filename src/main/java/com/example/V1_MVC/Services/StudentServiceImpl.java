package com.example.V1_MVC.Services;

import com.example.V1_MVC.Model.StudentModel;
import com.example.V1_MVC.Repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentsRepository studentRepository;

    @Override
    public List<StudentModel> listar() {
        return studentRepository.findAll();
    }

    @Override
    public StudentModel findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public StudentModel listarId(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public StudentModel save(StudentModel user) {
        return studentRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

}
