package com.example.noteservice.service;

import com.example.noteservice.domain.Note;
import com.example.noteservice.dto.NoteDto;
import com.example.noteservice.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public List<NoteDto> getAllByPersonId(Long personId) {
        return noteRepository.findAllDtosByPersonId(personId);
    }

    public List<NoteDto> getAll() {
        return noteRepository.findAllDtos();
    }

    public NoteDto save(NoteDto noteDto) {
        Note note = Note.builder()
                .body(noteDto.getBody())
                .personId(noteDto.getPersonId())
                .build();
        return new NoteDto(noteRepository.save(note));
    }

    public NoteDto update(NoteDto noteDto) {
        Note note = noteRepository.findById(noteDto.getId()).orElseThrow();
        note.update(noteDto);
        return new NoteDto(noteRepository.save(note));
    }
}
