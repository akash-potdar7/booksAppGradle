package com.akash.booksApp.service;

import java.util.List;

import com.akash.booksApp.model.Book;

public interface BookService {

	Book saveBook(Book book);

	List<Book> getAllBooks();

	List getGenreData();
	
}
