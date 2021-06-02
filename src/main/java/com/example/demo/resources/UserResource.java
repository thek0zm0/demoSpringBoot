package com.example.demo.resources;
import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

// Para falarmos que esta classe é um recurso WEB, que é implementador por um controlador REST
// Devemos adicionar uma anotação em cima do nome da classe
@RestController
@RequestMapping(value = "users")
public class UserResource
{
    @Autowired
    private UserService userService;
    // ResponseEntity é um tipo específico do Spring para retornar repostas de Requisições WEB
    // Pra indicar que este método responde o GET do http, anotação
    @GetMapping
    public ResponseEntity<List<User>> findAll()
    {
        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id)
    {
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    // Inserção
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj)
    {
        obj = userService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj)
    {
        obj = userService.update(id,obj);
        return ResponseEntity.ok().body(obj);
    }
}
