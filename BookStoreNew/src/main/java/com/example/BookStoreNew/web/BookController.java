package com.example.BookStoreNew.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.BookStoreNew.domain.Book;
import com.example.BookStoreNew.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@RequestMapping(value= {"/", "booklist"})
	public String Booklist(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	@RequestMapping(value= {"/add"})
	public String addbook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}
	
	@RequestMapping(value= {"/edit/{id}"})
	public String Editbook(Model model) {
		model.addAttribute("book", new Book());
		return "editbook";
	}

	@RequestMapping(value= "/saveEdit", method=RequestMethod.POST)
	public String saveEdit(Book newbook) {
		repository.save(newbook);
		return "redirect:booklist";                                                                                                                                                                                     
	}
	@RequestMapping(value= "/save", method=RequestMethod.POST)
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	@RequestMapping(value= "/delete/{id}", method=RequestMethod.GET)
	public String DeleteBook(@PathVariable("id")Long Bookid, Model model) {
		repository.deleteById(Bookid);
		return "redirect:../booklist";
	}
	
	

}
