package com.example.personservice.controller;

import com.example.personservice.dto.PersonDto;
import com.example.personservice.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/{id}")
    public PersonDto getById(@PathVariable Long id){
        return personService.getById(id);
    }

    @GetMapping
    public List<PersonDto> getAll(){
        return personService.getAll();
    }

    @PutMapping
    public PersonDto create(@RequestBody PersonDto personDto) {
        return personService.create(personDto);
    }

    @PatchMapping
    public PersonDto update(@RequestBody PersonDto personDto) {
        return personService.update(personDto);
    }
}
