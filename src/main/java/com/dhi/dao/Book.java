package com.dhi.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer bookId;
 private String name;
 private Double price;
 private String recStatus;
	public String getRecStatus() {
	return recStatus;
}

 public void setRecStatus(String recStatus) {
	this.recStatus = recStatus;
 }

	public Integer getBookId() {
	return bookId;
}

 public void setBookId(Integer bookId) {
	this.bookId = bookId;
 }

 public String getName() {
	return name;
 }

 public void setName(String name) {
	this.name = name;
 }

 public Double getPrice() {
	return price;
 }

 public void setPrice(Double price) {
	this.price = price;
 }

	@Override
public String toString() {
	return "Book [bookId=" + bookId + ", name=" + name + ", price=" + price + "]";
}

	public Book() {
		// TODO Auto-generated constructor stub
	}

}
