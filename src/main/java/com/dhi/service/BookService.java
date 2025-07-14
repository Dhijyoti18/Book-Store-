package com.dhi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dhi.dao.Book;

@Service
public interface BookService {
 public List<Book> getAll();
 public boolean saveBook(Book book);
 public void deleteById(Integer Id);
 public Book getById(Integer Id);
 public List<Book> getBookByStatus(String status);
}
