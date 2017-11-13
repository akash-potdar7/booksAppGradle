package com.akash.booksApp.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class BookEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	// @SequenceGenerator(name="seq",sequenceName="oracle_seq")
	// //https://stackoverflow.com/questions/20603638/what-is-the-use-of-annotations-id-and-generatedvaluestrategy-generationtype
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ISBN")
	private Integer isbn;

	@Column(name = "NAME")
	private String name;

	@Column(name = "GENRE")
	private Integer genreId;

	@Column(name = "AUTHOR")
	private String author;

	public BookEntity() {
	}

	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public BookEntity(Integer isbn, String name, Integer genreId, String author) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.genreId = genreId;
		this.author = author;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="genre")
	public Integer getGenreId() {
		return genreId;
	}

	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((genreId == null) ? 0 : genreId.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookEntity other = (BookEntity) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (genreId == null) {
			if (other.genreId != null)
				return false;
		} else if (!genreId.equals(other.genreId))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BookEntity [isbn=" + isbn + ", name=" + name + ", genreId=" + genreId + ", author=" + author
				+ "]";
	}

}
