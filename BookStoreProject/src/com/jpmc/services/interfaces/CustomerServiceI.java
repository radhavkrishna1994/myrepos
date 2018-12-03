package com.jpmc.services.interfaces;

import java.util.List;

import com.jpmc.bean.Book;
import com.jpmc.bean.Customer;

public interface CustomerServiceI {
	public Customer getCustomer(String phoneNo);
	public List<Book> getAllBooks();
}
