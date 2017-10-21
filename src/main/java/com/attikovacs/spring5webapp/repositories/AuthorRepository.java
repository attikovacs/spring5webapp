package com.attikovacs.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.attikovacs.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
