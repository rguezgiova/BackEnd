package com.bosonit.bs4_1.classes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value = "perfil2")
public class Perfil2Impl implements PerfilesService {

    @Value("${perfil2}")
    private String perfil;

    @Override
    public void miFuncion() {
        System.out.println(perfil);
    }
}