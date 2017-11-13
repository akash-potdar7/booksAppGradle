package com.angularSpringBootApp.entity;

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
	private GenreEntity genreEntity;

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

	public BookEntity(Integer isbn, String name, GenreEntity genreEntity, String author) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.genreEntity = genreEntity;
		this.author = author;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="genre")
	public GenreEntity getGenreEntity() {
		return genreEntity;
	}

	public void setGenreEntity(GenreEntity genreEntity) {
		this.genreEntity = genreEntity;
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
		result = prime * result + ((genreEntity == null) ? 0 : genreEntity.hashCode());
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
		if (genreEntity == null) {
			if (other.genreEntity != null)
				return false;
		} else if (!genreEntity.equals(other.genreEntity))
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
		return "BookEntity [isbn=" + isbn + ", name=" + name + ", genreEntity=" + genreEntity + ", author=" + author
				+ "]";
	}

}
