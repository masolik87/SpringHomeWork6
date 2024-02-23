package ru.HomeWork6.HomeWork6.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.HomeWork6.HomeWork6.model.Note;
import ru.HomeWork6.HomeWork6.repositories.NoteRepo;


import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService {
    private NoteRepo noteRepo;

    public List<Note> findAll() {
        return noteRepo.findAll();
    }

    @Override
    public Note createNote(Note note) {
        noteRepo.save(note);
        return note;
    }

    @Override
    public Note findNoteById(Long id) {
        Optional<Note> optionalNote = noteRepo.findNoteById(id);
        return optionalNote.orElse(null);
    }

    @Override
    public Note updateNoteById(Long id, Note note) {
        Optional<Note> optionalNote = noteRepo.findNoteById(id);
        if (optionalNote.isPresent()) {
            Note updatedNote = optionalNote.get();
            updatedNote.setTitle(note.getTitle());
            updatedNote.setDescription(note.getDescription());
            noteRepo.save(updatedNote);
            return updatedNote;
        }
        return null;
    }

    @Override
    public Boolean deleteNoteById(Long id) {
        Optional<Note> optionalNote = noteRepo.findNoteById(id);
        optionalNote.ifPresent(noteRepo::delete);
        return optionalNote.isPresent();
    }

}
