package com.angularSpringBootApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.angularSpringBootApp.model.Book;
import com.angularSpringBootApp.model.Genre;
import com.angularSpringBootApp.service.BookService;

@RestController
@RequestMapping(value = "/api")
public class BookController {

	@Autowired
	BookService bookService;

	public BookController() {
		System.out.println("Hitting");
	}

	// To test RequestMapping
	@RequestMapping("/")
	public String getHello() {
		return "Working..!";
	}

	@RequestMapping(value = "/allBooks", method = RequestMethod.GET)
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
	public Book saveBook(@RequestBody Book book) {
		System.out.println("in saveBook()");
		System.out.println("book name= " + book.getGenreId());
		return bookService.saveBook(book);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getGenreData", method = RequestMethod.GET)
	public List<Genre> getGenreDropDownData() {
		System.out.println("in getGenreDropDownData()");
		return bookService.getGenreData();
	}

}
