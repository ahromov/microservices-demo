package com.example.noteservice.controller;

import com.example.noteservice.domain.Note;
import com.example.noteservice.dto.NoteDto;
import com.example.noteservice.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteRepository noteRepository;

    @PutMapping
    public Note create(@RequestBody NoteDto noteDto) {
        return noteRepository.save(Note.builder()
                .body(noteDto.getBody())
                .personId(noteDto.getPersonId())
                .build());
    }
}
