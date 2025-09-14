package com.example.V1_MVC.Services;

import com.example.V1_MVC.Model.UserModel;
import com.example.V1_MVC.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class UserServiceImpl implements UserService, UserDetailsService  {

@Autowired
    private UserRepository userRepository;

    @Override
    public List<UserModel> listar() {
        return userRepository.findAll();
    }

    @Override
    public UserModel listarId(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        return new User(
                user.getUsername(),
                user.getPassword(),
                Collections.emptyList() 
        );
    }
}
