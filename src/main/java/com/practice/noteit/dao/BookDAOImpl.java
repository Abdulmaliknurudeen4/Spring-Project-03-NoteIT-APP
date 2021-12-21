package com.practice.noteit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practice.noteit.model.Book;
import com.practice.noteit.model.Note;

@Repository
public class BookDAOImpl implements BookDAO{
	/*
	 * DAO implementation class that handles the transactions for the Book 
	 * */

	@Autowired
	private SessionFactory sessionFactory;
	
//save Book method into the database
	public long save(Book book) {
		sessionFactory.getCurrentSession().save(book);
		return book.getId();
	}

//return Book
	public Book get(long id) {
		return sessionFactory.getCurrentSession().get(Book.class, id);
	}
//update Book
	public void update(long id, Book book) {
		Session session = sessionFactory.getCurrentSession();
		Book oldBook = session.byId(Book.class).load(id);
		oldBook.setBookName(book.getBookName());
		oldBook.setNoteIds(book.getNoteIds());
		session.flush();
		
	}
//delete book and all the notes belonging to that book
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Book book = session.byId(Book.class).load(id);
		long book_id = book.getId();
		if(!(book.getNoteIds()==null)) {
			List<String> noteids = book.getNoteIds();
			for (int i = 0; i < noteids.size(); i++) {
				Note deleteNote = session.byId(Note.class).load((long) Long.valueOf(noteids.get(i)));
				session.delete(deleteNote);
			}
		}
		session.delete(book);
	}


	//List of Books in The Database
	public List<Book> list() {
		List<Book> list = sessionFactory.getCurrentSession().createQuery("from Book").list();
		return list;
	}



}
