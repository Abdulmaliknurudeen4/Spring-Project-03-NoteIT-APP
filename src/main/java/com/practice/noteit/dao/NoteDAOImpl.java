package com.practice.noteit.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practice.noteit.model.Book;
import com.practice.noteit.model.Note;

@Repository
public class NoteDAOImpl implements NoteDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private List<Note> noteReturn = new ArrayList<Note>();

	public Note save(Note note, long bookid) {
		sessionFactory.getCurrentSession().save(note);
		Session session = sessionFactory.getCurrentSession();
		Book oldbook = session.byId(Book.class).load(bookid);
		oldbook.getNoteIds().add(String.valueOf(note.getId()));
		session.flush();
		return note;
	}

	public Note get(long id) {
		return sessionFactory.getCurrentSession().get(Note.class, id);
	}

	public void update(long id, Note note) {
		Session session = sessionFactory.getCurrentSession();
		Note oldNote = session.byId(Note.class).load(id);
		oldNote.setText(note.getText());
		oldNote.setLast_modified(note.getLast_modified());
		oldNote.setType(note.getType());
		session.flush();

	}

	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Note note = session.byId(Note.class).load(id);
		session.delete(note);
	}

	public List<Note> list() {
		List<Note> notelist = sessionFactory.getCurrentSession().createQuery("from Note").list();
		return notelist;
	}

	// new Test
	public List<Note> listById(long id) {
		noteReturn = new ArrayList<Note>();
		Book bookcontainer = sessionFactory.getCurrentSession().get(Book.class, id);
		List<String> noteids = bookcontainer.getNoteIds();
		Note note = new Note();
		for (int i = 0; i < noteids.size(); i++) {
			note = sessionFactory.getCurrentSession().get(Note.class, (long) Long.valueOf(noteids.get(i)));
			System.out.println(note.toString());
			noteReturn.add(note);
		}

		return noteReturn;
	}

	/*
	 * // new Test batch delete public void deleteById(long id) { Book bookcontainer
	 * = sessionFactory.getCurrentSession().get(Book.class, id); List<String>
	 * noteids = bookcontainer.getNoteIds(); Session session =
	 * sessionFactory.getCurrentSession();
	 * 
	 * for (int i = 0; i < noteids.size(); i++) { Note deleteNote =
	 * session.byId(Note.class).load((long) Long.valueOf(noteids.get(i)));
	 * session.delete(deleteNote); }
	 * 
	 * }
	 */

}
