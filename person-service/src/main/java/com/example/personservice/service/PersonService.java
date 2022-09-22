package com.example.personservice.service;

import com.example.personservice.client.NoteClient;
import com.example.personservice.domain.Person;
import com.example.personservice.dto.PersonDto;
import com.example.personservice.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final NoteClient noteClient;

    public PersonDto getById(Long personId) {
        Person person = personRepository.findById(personId).orElseThrow();
        List<PersonDto.NoteDto> notes = noteClient.getNotesByPersonId(person.getId());
        PersonDto personDto = new PersonDto(person);
        personDto.setNoteList(notes);
        return personDto;
    }

    public List<PersonDto> getAll() {
        List<PersonDto> personDtos = personRepository.findAllDtos();
        personDtos.forEach(personDto -> personDto.setNoteList(noteClient.getNotesByPersonId(personDto.getId())));
        return personDtos;
    }

    public PersonDto create(PersonDto personDto) {
        Person person = Person.builder()
                .name(personDto.getName())
                .email(personDto.getEmail())
                .build();
        return new PersonDto(personRepository.save(person));
    }

    public PersonDto update(PersonDto personDto) {
        Person person = personRepository.findById(personDto.getId()).orElseThrow();
        person.update(personDto);
        return new PersonDto(personRepository.save(person));
    }
}
