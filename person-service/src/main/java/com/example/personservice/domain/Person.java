package com.example.personservice.domain;

import com.example.personservice.dto.PersonDto;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
@Builder
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    public void update(PersonDto personDto){
        if (personDto.getName() != null) this.setName(personDto.getName());
        if (personDto.getEmail() != null) this.setEmail(personDto.getEmail());
    }
}
