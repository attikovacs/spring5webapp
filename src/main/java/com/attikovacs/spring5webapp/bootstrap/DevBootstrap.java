package com.attikovacs.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.attikovacs.spring5webapp.model.Author;
import com.attikovacs.spring5webapp.model.Book;
import com.attikovacs.spring5webapp.model.Publisher;
import com.attikovacs.spring5webapp.repositories.AuthorRepository;
import com.attikovacs.spring5webapp.repositories.BookRepository;
import com.attikovacs.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;

	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initialLoad();
	}

	private void initialLoad() {
		//Eric
        Author eric = new Author("Eric", "Evans");
        Publisher hc = new Publisher("Harper Collins","1111 Budapest Ó utca 1.");
        Book  ddd = new Book("Domain Driven Design", "1234", hc);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(hc);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher wrox = new Publisher("Wrox","Geneva Rue de Grand Pré 66.");
        Book noEJB = new Book("J2EE Development without EJB", "23444", wrox);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        publisherRepository.save(wrox);
        bookRepository.save(noEJB);
	}

}
