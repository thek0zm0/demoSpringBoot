package com.example.demo.resources;
import com.example.demo.entities.Product;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Para falarmos que esta classe é um recurso WEB, que é implementador por um controlador REST
// Devemos adicionar uma anotação em cima do nome da classe
@RestController
@RequestMapping(value = "products")
public class ProductResource
{
    @Autowired
    private ProductService productService;
    // ResponseEntity é um tipo específico do Spring para retornar repostas de Requisições WEB
    // Pra indicar que este método responde o GET do http, anotação
    @GetMapping
    public ResponseEntity<List<Product>> findAll()
    {
        List<Product> list = productService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id)
    {
        Product obj = productService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
