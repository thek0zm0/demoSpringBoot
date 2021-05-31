package com.example.demo.services;

import com.example.demo.entities.Order;
import com.example.demo.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Anotando como service (ao que parece poderia ser component também) spring para permitir injeção
@Service
public class OrderService
{
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll()
    {
        return orderRepository.findAll();
    }

    public Order findById(Long id)
    {
        Optional<Order> obj = orderRepository.findById(id);
        return obj.get();
    }
}
