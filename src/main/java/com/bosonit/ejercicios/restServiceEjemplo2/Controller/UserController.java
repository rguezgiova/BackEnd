package com.bosonit.ejercicios.restServiceEjemplo2.Controller;

import com.bosonit.ejercicios.restServiceEjemplo2.Class.User;
import com.bosonit.ejercicios.restServiceEjemplo2.Class.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public User setUser(@RequestBody User user) {
        userService.setUser(user);
        return user;
    }

    @GetMapping("/id/{id}")
    public String getId(@PathVariable int id) {
        return "User ID: " + id;
    }

    @PutMapping
    public User putUser(@RequestParam int id, @RequestParam String nombre) {
        return User.builder()
                    .id(id)
                    .nombre(nombre)
                    .build();
    }
}