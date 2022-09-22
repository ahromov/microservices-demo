package com.example.noteservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NoteDto {

    private Long id;
    private String body;
    private Long personId;
}
