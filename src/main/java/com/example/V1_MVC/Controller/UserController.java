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
@RestController   // 👈 Esto es importante para Postman
@RequestMapping("/api/users")  // 👈 Ruta separada para APIs
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    // ✅ Listar todos los usuarios
    @GetMapping("/listar")
    public List<UserModel> listar() {
        return userRepository.findAll();
    }

    // ✅ Buscar un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<UserModel> obtenerUsuario(@PathVariable Long id) {
        UserModel usuario = userService.listarId(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }



    // ✅ Guardar un usuario
    @PostMapping("/guardar")
    public UserModel guardarUsuario(@RequestBody UserModel user) {
        return userRepository.save(user);
    }

    // ✅ Eliminar usuario por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserModel> eliminarUsuario(@PathVariable Long id) {
         UserModel usuario = userService.listarId(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteUserById(id);
        return ResponseEntity.ok(usuario);
    }
}
