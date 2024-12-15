package com.example.noteRestApi.repository;

import com.example.noteRestApi.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
