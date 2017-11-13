package com.angularSpringBootApp.repo;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.angularSpringBootApp.entity.BookEntity;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Serializable> {
}
