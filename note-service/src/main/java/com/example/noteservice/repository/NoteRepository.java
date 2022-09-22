package com.example.noteservice.repository;

import com.example.noteservice.domain.Note;
import com.example.noteservice.dto.NoteDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query("select new com.example.noteservice.dto.NoteDto(n) from Note n where n.personId = ?1")
    List<NoteDto> findAllDtosByPersonId(Long personId);

    @Query("select new com.example.noteservice.dto.NoteDto(n) from Note n")
    List<NoteDto> findAllDtos();
}
