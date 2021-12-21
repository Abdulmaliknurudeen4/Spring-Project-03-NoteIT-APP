package com.practice.noteit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.noteit.dao.BookDAO;
import com.practice.noteit.model.Book;

@Service
public class BookServiceImpl implements BookService {
	// Autowiring the DAO into the Service layer
	@Autowired
	private BookDAO bookDAO;

	// Service method that saves book
	@Transactional
	public long save(Book book) {
		// TODO Auto-generated method stub
		return bookDAO.save(book);
	}

	// Service method that get book
	@Transactional
	public Book get(long id) {
		// TODO Auto-generated method stub
		return bookDAO.get(id);
	}

	// Service method that updates book
	@Transactional
	public void update(long id, Book book) {
		bookDAO.update(id, book);

	}

	// Service method that deletes book
	@Transactional
	public void delete(long id) {
		bookDAO.delete(id);

	}

	// Service method that returns list of books
	@Transactional
	public List<Book> list() {
		// TODO Auto-generated method stub
		return bookDAO.list();
	}

}
