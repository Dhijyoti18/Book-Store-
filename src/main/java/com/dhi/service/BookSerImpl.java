package com.dhi.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.dhi.dao.Book;
import com.dhi.repo.BookRepo;
@Service
public class BookSerImpl implements BookService {
     private BookRepo bookRepo;
     
	public BookSerImpl(BookRepo bookRepo) {
		this.bookRepo = bookRepo;
	}
	@Override
	public List<Book> getAll() {
		return bookRepo.findAll();
	}

	@Override
	public boolean saveBook(Book book) {
		Book save = bookRepo.save(book);
		if(save.getBookId()!=null) return true;
		else return false;

	}
	public void deleteById(Integer Id) {
		bookRepo.deleteById(Id);
	}
	@Override
	public Book getById(Integer Id) {
		 Book b = bookRepo.findByBookId(Id);
		return b;
		
	}
	@Override
	public List<Book> getBookByStatus(String status) {
		return bookRepo.findByRecStatus(status);
	}

}
