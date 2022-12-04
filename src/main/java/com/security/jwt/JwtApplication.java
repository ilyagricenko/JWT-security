package com.security.jwt;

import com.security.jwt.domain.Role;
import com.security.jwt.domain.User;
import com.security.jwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class JwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {

        return args -> {
          userService.saveRole(new Role(null, "ROLE_USER"));
          userService.saveRole(new Role(null, "ROLE_MANAGER"));
          userService.saveRole(new Role(null, "ROLE_ADMIN"));
          userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

          userService.saveUser(new User(null, "Sasuke Uchiha", "sasuke", "1111", new ArrayList<>()));
          userService.saveUser(new User(null, "Naruto Uzumaki", "naruto", "1234", new ArrayList<>()));
          userService.saveUser(new User(null, "Kakashi Hatake", "kakashi", "4321", new ArrayList<>()));
          userService.saveUser(new User(null, "Sakura Haruno", "sakura", "1111", new ArrayList<>()));

            userService.addRoleToUser("sasuke", "ROLE_USER");
            userService.addRoleToUser("sasuke", "ROLE_MANAGER");
            userService.addRoleToUser("naruto", "ROLE_MANAGER");
            userService.addRoleToUser("kakashi", "ROLE_ADMIN");
            userService.addRoleToUser("sakura", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("sakura", "ROLE_ADMIN");
            userService.addRoleToUser("sakura", "ROLE_USER");
        };
    }
}
