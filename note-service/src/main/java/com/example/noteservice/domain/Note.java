package com.example.noteservice.domain;

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
public class Note {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "first_name")
    private String body;

    @Column(name = "person_id")
    private Long personId;
}
