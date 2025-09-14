package com.example.V1_MVC.Services;

import com.example.V1_MVC.Model.CoachModel;
import com.example.V1_MVC.Repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CoachServiceImpl implements CoachService  {

@Autowired
    private CoachRepository coachRepository;

    @Override
    public List<CoachModel> listar() {
        return coachRepository.findAll();
    }

    @Override
    public CoachModel listarId(Long id) {
        return coachRepository.findById(id).orElse(null);
    }

    @Override
    public CoachModel save(CoachModel user) {
        return coachRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        coachRepository.deleteById(id);
    }

}
