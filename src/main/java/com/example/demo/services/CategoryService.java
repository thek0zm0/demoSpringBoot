package com.example.demo.services;

import com.example.demo.entities.Category;
import com.example.demo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Anotando como service (ao que parece poderia ser component também) spring para permitir injeção
@Service
public class CategoryService
{
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll()
    {
        return categoryRepository.findAll();
    }

    public Category findById(Long id)
    {
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.get();
    }
}
