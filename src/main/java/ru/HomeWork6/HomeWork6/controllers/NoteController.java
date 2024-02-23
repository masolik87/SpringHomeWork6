package ru.HomeWork6.HomeWork6.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.HomeWork6.HomeWork6.model.Note;
import ru.HomeWork6.HomeWork6.services.NoteService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    @GetMapping
    public ResponseEntity<List<Note>> findAllNotes() {
        return ResponseEntity.ok(noteService.findAll());
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        return new ResponseEntity<>(noteService.createNote(note), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> findNoteById(@PathVariable("id") Long id) {
        Note note = noteService.findNoteById(id);
        return note != null ? ResponseEntity.ok(note) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNoteById(@PathVariable("id") Long id, @RequestBody Note note) {
        Note updateNote = noteService.updateNoteById(id, note);
        return updateNote != null ? ResponseEntity.ok(updateNote) : ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNoteById(@PathVariable("id") Long id) {
        return noteService.deleteNoteById(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
