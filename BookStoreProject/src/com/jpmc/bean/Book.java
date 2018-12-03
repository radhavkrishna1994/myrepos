package com.jpmc.bean;

import java.io.Serializable;

/* Book b1=new Book();  // call a constructor Book(){    }
 * Book b2=new Book("234","Java","HS",250.50,100)
 * 
 */
public class Book implements Comparable<Book>,Serializable{

	private String isbn; //null
	private String title; //null
	private String author;//null
	private double price; //0.0
	private long stock; //0
	private String genre;
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	private static int count;
	
	public Book() {	}
	public Book(String isbn, String title, String author, double price,
			long stock,String genre) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
		this.stock = stock;
		this.genre=genre;
	}

	public String getIsbn() {
		return isbn;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public long getStock() {
		return stock;
	}
	public void setStock(long stock) {
		this.stock = stock;
	}
		
	@Override
	public int hashCode() {
		return isbn.hashCode()+title.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}
	@Override
	public int compareTo(Book book) {
			return this.title.compareTo(book.getTitle());
	}
	
	public String toString()
	{
		return isbn+" "+title+" "+author+" "+price+" "+stock+" "+genre;
	}
	
	
}
