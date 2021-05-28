package com.example.demo.resources;
import com.example.demo.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Para falarmos que esta classe é um recurso WEB, que é implementador por um controlador REST
// Devemos adicionar uma anotação em cima do nome da classe
@RestController
@RequestMapping(value = "users")
public class UserResource
{
    // ResponseEntity é um tipo específico do Spring para retornar repostas de Requisições WEB
    // Pra indicar que este método responde o GET do http, anotação
    @GetMapping
    public ResponseEntity<User> findAll()
    {
        User u = new User(1L,"Maria","mariazinha@gmail.com","1150349255","marigirl899");
        return ResponseEntity.ok().body(u);
    }
}
