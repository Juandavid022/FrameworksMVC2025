package com.example.V1_MVC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.V1_MVC.Model.UserModel;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    // Método que devuelve un Optional, lo que es una mejor práctica.
    Optional<UserModel> findByUsername(String username);

    // Método para verificar si existe un usuario con ese nombre de usuario
    boolean existsByUsername(String username);
}
