package com.example.noteRestApi.service;

import com.example.noteRestApi.model.Note;
import com.example.noteRestApi.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    public Note create(Note note) {
        return noteRepository.save(note);
    }

    public Optional<Note> get(Long id) {
        return noteRepository.findById(id);
    }

    public Note update(Long id, Note updateNote) {
        return noteRepository.findById(id)
                .map(note -> {
                    note.setTitle(updateNote.getTitle());
                    note.setContent(updateNote.getContent());
                    return noteRepository.save(note);
                }).orElseThrow(() -> new NoSuchElementException("Note not found with id " + id));
    }

    public void delete(Long id) {
        noteRepository.deleteById(id);
    }

    public List<Note> getAll() {
        return noteRepository.findAll();
    }
}
