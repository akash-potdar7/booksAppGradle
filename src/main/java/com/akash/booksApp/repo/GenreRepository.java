package com.akash.booksApp.repo;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.akash.booksApp.entity.GenreEntity;

public interface GenreRepository extends CrudRepository<GenreEntity, Serializable> {
}
