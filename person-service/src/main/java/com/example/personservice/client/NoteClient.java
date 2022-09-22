package com.example.personservice.client;


import com.example.personservice.dto.PersonDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "notes")
public interface NoteClient {

    @GetMapping("/notes/person/{personId}")
    List<PersonDto.NoteDto> getNotesByPersonId(@PathVariable Long personId);
}
