package com.example.personservice.dto;

import com.example.personservice.domain.Person;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class PersonDto {

    private Long id;
    private String name;
    private String email;
    private List<NoteDto> noteList;

    public PersonDto(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.email = person.getEmail();
    }

    @Data
    public static class NoteDto {
        private Long id;
        private String body;
        private Long personId;
    }
}
