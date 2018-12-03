package com.jpmc.dao.interfaces;

import java.util.List;

import com.jpmc.bean.Book;

public interface BookDaoInterface {

public int addBook(String isbn,String title,String author,double price,long stock,String genre);
public int deleteBook(String isbn);
public  List<Book> getAllBooks();
public  int updateStock(String isbn,long newStock);
}
