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

import com.practice.noteit.model.Book;
import com.practice.noteit.model.Note;
import com.practice.noteit.service.BookService;

@CrossOrigin("*")
@RestController
public class BookController {
	@Autowired
	private BookService bookService;

	// Get a Book
	@GetMapping("/api/book")
	public ResponseEntity<List<Book>> list() {
		List<Book> list = bookService.list();
		return ResponseEntity.ok().body(list);
	}

	// Save a Book
	@PostMapping("/api/book")
	public ResponseEntity<?> save(@RequestBody Book book) {
		long id = bookService.save(book);
		return ResponseEntity.ok().body("Book Created");
	}

	// Update a Single Book Object'
	@PutMapping("/api/book/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Book book) {
		bookService.update(id, book);
		return ResponseEntity.ok().body("Book has been Updated");

	}

	// Delete a Single Book Object
	@DeleteMapping("/api/book/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		bookService.delete(id);
		return ResponseEntity.ok().body("Book has been Deleted");
	}

}
