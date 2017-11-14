package com.akash.booksApp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.booksApp.entity.BookEntity;
import com.akash.booksApp.entity.GenreEntity;
import com.akash.booksApp.model.Book;
import com.akash.booksApp.model.Genre;
import com.akash.booksApp.repo.BookRepository;
import com.akash.booksApp.repo.GenreRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private GenreRepository genreRepository;

	@Override
	public Book saveBook(Book book) {
		return entityToView(bookRepository.save(viewToEntity(book)));
	}

	// Converts Entity Object to View Object
	private Book entityToView(BookEntity entity) {
		Book book = new Book();
		book.setIsbn(entity.getIsbn());
		book.setName(entity.getName());
		book.setGenreId(entity.getGenreId());
		book.setAuthor(entity.getAuthor());
		return book;
	}

	// Converts View Object to Entity Object
	private BookEntity viewToEntity(Book book) {
		BookEntity entity = new BookEntity();
		entity.setIsbn(book.getIsbn());
		entity.setName(book.getName());
		entity.setGenreId(book.getGenreId());
		entity.setAuthor(book.getAuthor());
		return entity;
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<Book>();
		Iterator<BookEntity> iterator = bookRepository.findAll().iterator();
		while (iterator.hasNext()) {
			books.add(entityToView(iterator.next()));
		}
		return books;
	}

	@Override
	public List<Genre> getGenreData() {
		List<Genre> genreList = new ArrayList<Genre>();
		Iterator<GenreEntity> iterator = genreRepository.findAll().iterator();
		while (iterator.hasNext()) {
			genreList.add(genreEntityToViewObj(iterator.next()));
		}
		return genreList;
	}

	// converts Genre Entity Object to View Object.
	private Genre genreEntityToViewObj(GenreEntity genreEntity) {
		Genre genre = new Genre();
		genre.setId(genreEntity.getId());
		genre.setGenre(genreEntity.getGenre());
		return genre;
	}

}
