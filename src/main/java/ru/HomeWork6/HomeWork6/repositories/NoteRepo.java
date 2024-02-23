package ru.HomeWork6.HomeWork6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.HomeWork6.HomeWork6.model.Note;

import java.util.Optional;

public interface NoteRepo extends JpaRepository<Note, Long> {

    public Optional<Note> findNoteById(Long id);
}
