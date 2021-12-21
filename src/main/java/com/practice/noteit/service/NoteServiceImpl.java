package com.practice.noteit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.noteit.dao.NoteDAO;
import com.practice.noteit.model.Note;

@Service
public class NoteServiceImpl implements NoteService {
//Autowiring DAO of note into the Service layer
	@Autowired
	private NoteDAO noteDao;

//Service method that save note
	@Transactional
	public Note save(Note note, long bookid) {
		return noteDao.save(note, bookid);
	}

	// Service method that get note
	@Transactional
	public Note get(long id) {
		return noteDao.get(id);
	}

	// Service method that update note
	@Transactional
	public void update(long id, Note note) {
		noteDao.update(id, note);

	}

	// Service method that drops note
	@Transactional
	public void delete(long id) {
		noteDao.delete(id);

	}

	// Service method that get list of notes
	@Transactional
	public List<Note> list() {
		return noteDao.list();
	}

	@Transactional
	public List<Note> listById(long id) {
		// TODO Auto-generated method stub
		return noteDao.listById(id);
	}

	

}
