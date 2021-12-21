package com.practice.noteit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.noteit.model.Note;
import com.practice.noteit.service.NoteService;

@CrossOrigin("*")
@RestController
public class NoteController {
	@Autowired
	private NoteService noteService;

	// Get all the Notes
	@GetMapping("/api/note")
	public ResponseEntity<List<Note>> list() {
		List<Note> list = noteService.list();
		return ResponseEntity.ok().body(list);
	}

	// Save a Note to a particular book with the id parsed
	@PostMapping("/api/note/bybookId/save/{id}")
	public ResponseEntity<?> save(@RequestBody Note note, @PathVariable("id") long id) {
		Note returnNote = noteService.save(note, id);
		return ResponseEntity.ok().body(returnNote);
	}

	// Update a Single Note Object'
	@PutMapping("/api/note/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Note note) {
		noteService.update(id, note);
		return ResponseEntity.ok().body("Note has been Updated");

	}

	// Delete a Single Note Object
	@DeleteMapping("/api/note/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		noteService.delete(id);
		return ResponseEntity.ok().body("Note has been Deleted");
	}

//Get Notes by Book Id under Testing
	// Works
	@GetMapping("/api/note/bybookId/{id}")
	public ResponseEntity<List<Note>> NotesbyId(@PathVariable("id") long id) {
		List<Note> NoteReturned = noteService.listById(id);
		return ResponseEntity.ok().body(NoteReturned);
	}

}
