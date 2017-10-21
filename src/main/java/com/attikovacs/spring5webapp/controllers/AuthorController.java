package com.attikovacs.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.attikovacs.spring5webapp.repositories.AuthorRepository;

@Controller
public class AuthorController {

	private AuthorRepository AuthorRepository;
	
	public AuthorController(AuthorRepository authorRepository) {
		AuthorRepository = authorRepository;
	}

	@RequestMapping(value = "/authors")
	public String getAuthors(Model model) {
		model.addAttribute("authors", AuthorRepository.findAll());
		return "authors";
	}
	
}
