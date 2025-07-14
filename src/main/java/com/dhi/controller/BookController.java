package com.dhi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dhi.dao.Book;
import com.dhi.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bService;
	@GetMapping("/books")
     public ModelAndView displayBook() {
        	  ModelAndView mv=new ModelAndView();
        	  mv.addObject("book",bService.getBookByStatus("Y"));
        	  mv.setViewName("view.html");
        	  return mv;
          }
	@GetMapping("/addbook")
	public ModelAndView addBook() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("dbook",new Book());
		mv.setViewName("ind.html");
		return mv;
	}
	@PostMapping("/save")
	public ModelAndView saveBook(Book book) {
		ModelAndView mv=new ModelAndView();
		book.setRecStatus("Y");
		boolean b=bService.saveBook(book);
		if(b) {
			mv.addObject("sucsMsg","Book Saved Successfully");
		}
		else {
		mv.addObject("errMsg","problem occurs");
		}
		// mv.addObject("add", new Book());
		mv.setViewName("view1.html");
		return mv;
	}
	@GetMapping("/delete")
	public ModelAndView deleteBook(@RequestParam("bookId")Integer bId) {
		//bService.deleteById(bId); // This hard Delete
		//This is soft delete
		Book byId = bService.getById(bId);
		if(byId.getBookId()!=null) {
		byId.setRecStatus("N");
		bService.saveBook(byId);
		}
		ModelAndView mv=new ModelAndView();
   	  mv.addObject("book",bService.getBookByStatus("Y"));
   	  mv.setViewName("view.html");
   	  return mv;
	}
	@GetMapping("/edit") 
	public ModelAndView editRecord(@RequestParam("bookId")Integer Id) {
		ModelAndView mv=new ModelAndView();
		Book b = bService.getById(Id);
		mv.addObject("dbook",b);
		mv.setViewName("ind.html");
		return mv;
	}
	public BookController() {
		// TODO Auto-generated constructor stub
	}

}
