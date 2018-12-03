package com.jpmc.dao.interfaces;

import java.util.List;

import com.jpmc.bean.Book;
import com.jpmc.bean.Customer;

public interface CustomerDaoI {
		public Customer getCustomer(String phoneNo);
		public  List<Book> getAllBooks();

}
