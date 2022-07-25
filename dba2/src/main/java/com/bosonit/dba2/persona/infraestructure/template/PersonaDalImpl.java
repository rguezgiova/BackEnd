package com.bosonit.dba2.persona.infraestructure.template;

import com.bosonit.dba2.persona.domain.Persona;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonaDalImpl implements PersonaDal {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Persona addPersona(Persona persona) {
        return mongoTemplate.save(persona);
    }

    @Override
    public Persona findById(String id) {
        return mongoTemplate.findById(id, Persona.class);
    }

    @Override
    public List<Persona> findByName(String name) {
        Query query = new Query().addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.find(query, Persona.class);
    }

    @Override
    public List<Persona> getAll() {
        return mongoTemplate.findAll(Persona.class);
    }

    @Override
    public void deletePersona(Persona persona) {
        mongoTemplate.remove(persona);
    }

    @Override
    public Persona updatePersona(String id, Persona persona) {
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update();
        if (persona.getUser() != null) {
            update.set("user", persona.getUser());
        }
        if (persona.getPassword() != null) {
            update.set("password", persona.getPassword());
        }
        if (persona.getName() != null) {
            update.set("name", persona.getName());
        }
        if (persona.getSurname() != null) {
            update.set("surname", persona.getSurname());
        }
        UpdateResult result = mongoTemplate.updateFirst(query, update, Persona.class);
        if (result != null) {
            return mongoTemplate.findById(id, Persona.class);
        } else {
            return null;
        }
    }
}