package com.example.personservice.client;


import com.example.personservice.dto.PersonDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "notes")
public interface NoteClient {

    @GetMapping("/notes/person/{personId}")
    @CircuitBreaker(name = "notes", fallbackMethod = "getEmptyNotesList")
    List<PersonDto.NoteDto> getNotesByPersonId(@PathVariable Long personId);

    default List<PersonDto.NoteDto> getEmptyNotesList(Throwable throwable) {
        return List.of(new PersonDto.NoteDto());
    }
}
