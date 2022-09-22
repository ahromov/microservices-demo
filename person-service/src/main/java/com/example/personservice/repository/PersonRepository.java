package com.example.personservice.repository;

import com.example.personservice.domain.Person;
import com.example.personservice.dto.PersonDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("select new com.example.personservice.dto.PersonDto(p) from Person p")
    List<PersonDto> findAllDtos();
}
