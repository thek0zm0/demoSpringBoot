package com.example.demo.config;


import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

// Dizendo ao spring que esta é uma classe de configuração
// Linkando essa configuração ao profile Test
// Esta classe servira como database Seeding
@Configuration
@Profile(value = "test")
public class TestConfig implements CommandLineRunner
{
    // Mecanismo de injeção de dependência do Spring
    @Autowired
    private UserRepository userRepository;

    // Utilizamos commandLineRunner para que isto seja executado com o programa automaticamente
    @Override
    public void run(String... args) throws Exception
    {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1,u2));
    }
}
