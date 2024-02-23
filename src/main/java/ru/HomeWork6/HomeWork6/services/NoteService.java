package ru.HomeWork6.HomeWork6.services;

import ru.HomeWork6.HomeWork6.model.Note;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    List<Note> findAll();

    Note createNote(Note note);

    Note findNoteById(Long id);

    Note updateNoteById(Long id, Note note);

    Boolean deleteNoteById(Long id);
}