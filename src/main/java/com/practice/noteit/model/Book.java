package com.practice.noteit.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="BookTable")
public class Book {
	/*
	 * The ElementCollection annotation used here is used to store the array of the notes belonging
	 * to a particular notebook, so that when the UI is designed, the noteController will be used on those
	 * ids instead of decoding them right from the Book Object. Also we've been encountering problem that's why 
	 * this approach was used.
	 * */
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String bookName;
	@ElementCollection(fetch=FetchType.EAGER)
	private List<String> NoteIds = new ArrayList<String>();


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<String> getNoteIds() {
		return NoteIds;
	}

	public void setNoteIds(List<String> noteIds) {
		NoteIds = noteIds;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


}
