package com.practice.noteit.service;

import java.util.List;

import com.practice.noteit.model.Note;

/*
 * Services offered by Note
 * */
public interface NoteService {
	// save note to database
	Note save(Note note, long bookid);

	// get a note with a specific id
	Note get(long id);

	// update a note with a specific id
	void update(long id, Note note);

	// delete a note from the database
	void delete(long id);

	// returns list of notes from the database
	List<Note> list();

	// get list of Notes by the book id they belong to
	List<Note> listById(long id);

}
