package com.bosonit.dba1.persona.infraestructure.controller;

import com.bosonit.dba1.persona.application.port.AddPersonaPort;
import com.bosonit.dba1.persona.application.port.DeletePersonaPort;
import com.bosonit.dba1.persona.application.port.GetPersonaPort;
import com.bosonit.dba1.persona.application.port.UpdatePersonaPort;
import com.bosonit.dba1.persona.domain.Persona;
import com.bosonit.dba1.persona.infraestructure.dto.input.PersonaInputDto;
import com.bosonit.dba1.persona.infraestructure.dto.output.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/persona")
@RestController
public class PersonaController {
    @Autowired
    AddPersonaPort addPersonaPort;
    @Autowired
    DeletePersonaPort deletePersonaPort;
    @Autowired
    GetPersonaPort getPersonaPort;
    @Autowired
    UpdatePersonaPort updatePersonaPort;
    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    public PersonaOutputDto addPersona(@Valid @RequestBody PersonaInputDto personaInputDto) {
        return addPersonaPort.addPersona(personaInputDto);
    }

    @GetMapping("/{id}")
    public PersonaOutputDto getPersonaId(@PathVariable("id") String id) {
        return getPersonaPort.getPersonaId(id);
    }

    @GetMapping("/nombre/{nombre}")
    public List<PersonaOutputDto> getPersonaName(@PathVariable("nombre") String usuario) throws Exception {
        return getPersonaPort.getPersonaName(usuario);
    }

    @GetMapping
    public List<PersonaOutputDto> getPersonas() {
        return getPersonaPort.getPersonas();
    }

    @PutMapping("/{id}")
    public PersonaOutputDto updatePersona(@PathVariable("id") String id, @Valid @RequestBody PersonaInputDto personaInputDto) {
        return updatePersonaPort.updatePersona(id, personaInputDto);
    }

    @DeleteMapping("/{id}")
    public void deletePersona(@PathVariable("id") String id) {
        deletePersonaPort.deletePersona(id);
    }

    @GetMapping("/filter")
    public Page<PersonaOutputDto> getFilteredPersonas(@RequestParam Map<String, String> params, @RequestParam("page") int page, @PageableDefault Pageable pageable) {
        if (checkParams(params)) {
            return getPersonaPort.getPersonasPageable(pageable).map(PersonaOutputDto::new);
        }
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> queryPersona = criteriaBuilder.createQuery(Persona.class);
        Root<Persona> personaRoot = queryPersona.from(Persona.class);
        List<String> fields = List.of("user", "name", "surname", "createdDate");
        List<Predicate> predicates =  new ArrayList<>();
        params.forEach((field, value) -> {
            if (fields.contains(field)) {
                if (field.equals("createdDate")) {
                    Date creationDate = parseDate(value);
                    if (params.get("after_before") == null) {
                        predicates.add(criteriaBuilder.equal(personaRoot.get(field), creationDate));
                    } else {
                        if (params.get("after_before").equals("after")) {
                            predicates.add(criteriaBuilder.greaterThan(personaRoot.get(field), creationDate));
                        } else if (params.get("after_before").equals("before")) {
                            predicates.add(criteriaBuilder.lessThan(personaRoot.get(field), creationDate));
                        }
                    }
                }
            } else {
                predicates.add(criteriaBuilder.lessThan(personaRoot.get(field), value));
            }
        });
        queryPersona.select(personaRoot).where(predicates.toArray(new Predicate[predicates.size()]));
        List<PersonaOutputDto> personasList = entityManager.createQuery(queryPersona).setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize()).getResultStream().map(PersonaOutputDto::new).collect(Collectors.toList());
        CriteriaQuery<Long> queryCount = criteriaBuilder.createQuery(Long.class);
        Root<Persona> rootCount = queryCount.from(Persona.class);
        queryCount.select(criteriaBuilder.count(rootCount)).where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()])));
        Long count = entityManager.createQuery(queryCount).getSingleResult();
        return new PageImpl<PersonaOutputDto>(personasList, pageable, count);
    }

    private boolean checkParams(Map<String, String> params) {
        params.remove("size");
        params.remove("page");
        return params.isEmpty();
    }

    private Date parseDate(String value) {
        Date creationDate;
        try {
            creationDate = new SimpleDateFormat("yyyy-MM-dd").parse(value);
        } catch (ParseException exception) {
            throw new RuntimeException(exception);
        }
        return creationDate;
    }
}