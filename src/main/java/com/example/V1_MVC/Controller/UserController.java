package com.example.V1_MVC.Controller;

import com.example.V1_MVC.Model.UserModel;
import com.example.V1_MVC.Repository.UserRepository;
import com.example.V1_MVC.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api/users")
@Tag(name = "Usuario", description = "Operaciones para la gestión de los usuarios")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    
    @GetMapping("/listar")
    @Operation(summary = "Lista todos los usuarios", description = "Devuelve un listado completo de los usuarios")
    public List<UserModel> listar() {
        return userRepository.findAll();
    }

    
    @GetMapping("/{id}")
    @Operation(summary = "Lista usuario por id", description = "Devuelve un usuario por su id")
    public ResponseEntity<UserModel> obtenerUsuario(@PathVariable Long id) {
        UserModel usuario = userService.listarId(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }



    @PostMapping("/guardar")
    @Operation(summary = "Guardar usuario", description = "Permite guardar un nuevo usuario")
    public UserModel guardarUsuario(@RequestBody UserModel user) {
        return userService.saveUser(user);
    }

    
    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Eliminar usuario", description = "Permite eliminar un usuario por su id")
    public ResponseEntity<UserModel> eliminarUsuario(@PathVariable Long id) {
         UserModel usuario = userService.listarId(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteById(id);
        return ResponseEntity.ok(usuario);
    }


    
}
