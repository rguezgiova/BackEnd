package com.bosonit.ejercicios.restServiceEjemplo2.Class;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    User user;

    public void setUser(User newUser) {
        user = newUser;
    }

    @Override
    public User getUser() {
        return user;
    }
}