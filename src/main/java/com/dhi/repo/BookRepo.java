package com.dhi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhi.dao.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{
public Book findByBookId(Integer id);
public List<Book>  findByRecStatus(String recStatus);
}
