package com.attikovacs.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.attikovacs.spring5webapp.repositories.BookRepository;

@Controller
public class BookController {

	private BookRepository BookRepository;
	
	public BookController(BookRepository bookRepository) {
		BookRepository = bookRepository;
	}

	@RequestMapping(value = "/books")
	public String getBooks(Model model) {
		model.addAttribute("books", BookRepository.findAll());
		return "books";
	}
	
}
