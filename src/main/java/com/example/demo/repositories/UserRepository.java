package com.example.demo.repositories;

import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
// JPA<> <Tipo da entidade, tipo da chave>
public interface UserRepository extends JpaRepository<User, Long>
{
}
