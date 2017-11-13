package com.angularSpringBootApp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angularSpringBootApp.entity.BookEntity;
import com.angularSpringBootApp.entity.GenreEntity;
import com.angularSpringBootApp.model.Book;
import com.angularSpringBootApp.model.Genre;
import com.angularSpringBootApp.repo.BookRepository;
import com.angularSpringBootApp.repo.GenreRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private GenreRepository genreRepository;

	@Override
	public Book saveBook(Book book) {
		System.out.println(book.getGenre().toString());
		System.out.println(book.getAuthor());
		System.out.println(book.getName());
		System.out.println(book.getIsbn());
		return entityToView(bookRepository.save(viewToEntity(book)));
	}

	// Converts Entity Obj to View Obj
	private Book entityToView(BookEntity entity) {
		Book book = new Book();
		book.setIsbn(entity.getIsbn());
		book.setName(entity.getName());
		book.setGenre(genreEntityToViewObj(entity.getGenreEntity()));
		book.setAuthor(entity.getAuthor());
		return book;
	}

	// Converts View Obj to Entity Obj
	private BookEntity viewToEntity(Book book) {
		BookEntity entity = new BookEntity();
		entity.setIsbn(book.getIsbn());
		entity.setName(book.getName());
		entity.setGenreEntity(genreViewToEntityObj(book.getGenre()));
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

	// converts Genre Entity Obj to View Obj.
	private Genre genreEntityToViewObj(GenreEntity genreEntity) {
		Genre genre = new Genre();
		genre.setId(genreEntity.getId());
		genre.setGenre(genreEntity.getGenre());
		return genre;
	}

	// converts Genre View Obj to Entity Obj.
	private GenreEntity genreViewToEntityObj(Genre genre) {
		GenreEntity genreEntity = new GenreEntity();
		genreEntity.setId(genre.getId());
		genreEntity.setGenre(genre.getGenre());
		return genreEntity;
	}

}
