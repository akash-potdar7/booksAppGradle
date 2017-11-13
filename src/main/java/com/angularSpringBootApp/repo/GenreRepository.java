package com.angularSpringBootApp.repo;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.akash.booksapp.controller.entity.GenreEntity;

public interface GenreRepository extends CrudRepository<GenreEntity, Serializable> {
}
