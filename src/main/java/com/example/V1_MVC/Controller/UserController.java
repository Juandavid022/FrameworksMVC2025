package com.example.V1_MVC.Controller;

import com.example.V1_MVC.Model.UserModel;
import com.example.V1_MVC.Repository.UserRepository;
import com.example.V1_MVC.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "users", description = "Operaciones sobre el manejo y recursos de los usuarios")
@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    
    @GetMapping("/listar")
    public List<UserModel> listar() {
        return userRepository.findAll();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<UserModel> obtenerUsuario(@PathVariable Long id) {
        UserModel usuario = userService.listarId(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }



    @PostMapping("/guardar")
    public UserModel guardarUsuario(@RequestBody UserModel user) {
        return userRepository.save(user);
    }

    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserModel> eliminarUsuario(@PathVariable Long id) {
         UserModel usuario = userService.listarId(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteById(id);
        return ResponseEntity.ok(usuario);
    }
}
