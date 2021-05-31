package com.example.demo.repositories;

import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
// JPA<> <Tipo da entidade, tipo da chave>
// Como user repository herda de JPA repository a anotação @repository do spring,
// Não precisamos colocar a anotação (mas se quiser...)
public interface UserRepository extends JpaRepository<User, Long>
{
}
