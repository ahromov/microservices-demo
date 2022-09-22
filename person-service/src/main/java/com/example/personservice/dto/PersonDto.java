package com.example.personservice.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonDto {

    private Long id;
    private String name;
    private List<NoteDto> noteList;
}
