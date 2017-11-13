package com.angularSpringBootApp.repo;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.angularSpringBootApp.entity.GenreEntity;

public interface GenreRepository extends CrudRepository<GenreEntity, Serializable> {
}
