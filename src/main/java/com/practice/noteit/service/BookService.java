package com.practice.noteit.service;

import java.util.List;

import com.practice.noteit.model.Book;
/*
 * Services offered by Book
 * */
public interface BookService {
	// creates book
		long save(Book book);

		// retrieves book
		Book get(long id);

		// update book
		void update(long id, Book book);

		// deletes book
		void delete(long id);
		//list of Books
		List<Book> list();
}
