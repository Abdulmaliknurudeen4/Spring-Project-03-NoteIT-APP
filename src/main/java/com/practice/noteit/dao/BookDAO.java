package com.practice.noteit.dao;

import java.util.List;

import com.practice.noteit.model.Book;

/*
 * Interface that describes the function of the BookDAO
 * */
public interface BookDAO {
	// creates book
	long save(Book book);

	// retrieves book
	Book get(long id);

	// update book
	void update(long id, Book book);

	// deletes book
	void delete(long id);

	List<Book> list();
}
