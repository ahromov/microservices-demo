package com.example.noteservice.controller;

import com.example.noteservice.dto.NoteDto;
import com.example.noteservice.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @GetMapping("/person/{personId}")
    public List<NoteDto> getAllByPersonId(@PathVariable Long personId) {
        return noteService.getAllByPersonId(personId);
    }

    @GetMapping
    public List<NoteDto> getAll() {
        return noteService.getAll();
    }

    @PutMapping
    public NoteDto create(@RequestBody NoteDto noteDto) {
        return noteService.save(noteDto);
    }

    @PatchMapping
    public NoteDto update(@RequestBody NoteDto noteDto) {
        return noteService.update(noteDto);
    }
}
