package com.attikovacs.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.attikovacs.spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
