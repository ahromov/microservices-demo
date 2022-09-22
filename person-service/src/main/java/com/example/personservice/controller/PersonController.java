package com.example.personservice.controller;

import com.example.personservice.domain.Person;
import com.example.personservice.dto.PersonDto;
import com.example.personservice.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;

    @PutMapping
    public Person create(@RequestBody PersonDto personDto) {
        return personRepository.save(Person.builder()
                .name(personDto.getName())
                .build());
    }
}
