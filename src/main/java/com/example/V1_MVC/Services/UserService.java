package com.example.V1_MVC.Services;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.example.V1_MVC.Model.UserModel;

@Service
public interface UserService {
    
    void deleteById(Long id);
    UserModel listarId(Long id);
    UserModel saveUser(UserModel user);
    UserDetails loadUserByUsername(String username);
    List<UserModel> listar();    
    
}