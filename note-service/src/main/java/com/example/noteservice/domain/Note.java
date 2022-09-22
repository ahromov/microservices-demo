package com.example.noteservice.domain;

import com.example.noteservice.dto.NoteDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Note {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "body", nullable = false)
    private String body;

    @Column(name = "person_id", nullable = false)
    private Long personId;

    public void update(NoteDto noteDto) {
        if (noteDto.getBody() != null) this.setBody(noteDto.getBody());
    }
}
