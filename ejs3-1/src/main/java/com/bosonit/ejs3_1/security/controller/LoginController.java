package com.bosonit.ejs3_1.security.controller;

import com.bosonit.ejs3_1.person.application.port.PersonService;
import com.bosonit.ejs3_1.person.domain.Person;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LoginController {
    @Autowired
    private PersonService personService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam("username") String username, @RequestParam("password") String password) throws Exception {
        Person personFound = personService.getUserByUsername(username);
        if (personFound == null) {
            throw new Exception("User not found");
        }
        String personPassword = personFound.getPassword();
        if (!password.equals(personPassword)) {
            throw new Exception("Something when wrong");
        }
        String role = personFound.getRoles().toString();
        return new ResponseEntity<>(getJwtToken(username, role), HttpStatus.OK);
    }

    private String getJwtToken(String username, String role) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(role);
        String token = Jwts.builder().setId("softtekJWT").setSubject(username).claim("authorities", grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + 600000)).signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();
        return "Bearer " + token;
    }
}