package com.example.V1_MVC.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.V1_MVC.Model.UserModel;

@Service
public interface UserService {
    
    List<UserModel> findAll();
    Optional<UserModel> findById(Long id);
    UserModel save(UserModel usuario);
    void deleteById(Long id);
    Optional<UserModel> findUserByUsername(String username);
    UserModel listarId(Long id);
    UserModel saveUser(UserModel user);
    UserDetails loadUserByUsername(String username);
        List<UserModel> listar();
    
    void deleteUserById(Long id);
}