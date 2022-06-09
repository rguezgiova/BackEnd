package com.bosonit.ejercicios.restServiceEjemplo2.Class;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void setUser(User user);
    User getUser();
}