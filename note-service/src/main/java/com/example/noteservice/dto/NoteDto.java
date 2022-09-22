package com.example.noteservice.dto;

import com.example.noteservice.domain.Note;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class NoteDto {

    private Long id;
    private String body;
    private Long personId;

    public NoteDto(Note note) {
        this.id = note.getId();
        this.body = note.getBody();
        this.personId = note.getPersonId();
    }
}
