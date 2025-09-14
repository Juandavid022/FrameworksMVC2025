package com.example.V1_MVC.Services;

import com.example.V1_MVC.Model.ClassModel;
import com.example.V1_MVC.Repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClassServiceImpl implements ClassService  {

    @Autowired
    private ClassRepository classRepository;

    @Override
    public List<ClassModel> listar() {
        return classRepository.findAll();
    }

    @Override
    public ClassModel listarId(Long id) {
        return classRepository.findById(id).orElse(null);
    }

    @Override
    public ClassModel save(ClassModel user) {
        return classRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        classRepository.deleteById(id);
    }


}
