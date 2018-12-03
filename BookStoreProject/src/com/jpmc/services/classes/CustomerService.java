package com.jpmc.services.classes;

import java.util.List;

import com.jpmc.bean.Book;
import com.jpmc.bean.Customer;
import com.jpmc.dao.classes.CustomerDao;
import com.jpmc.dao.interfaces.CustomerDaoI;
import com.jpmc.services.interfaces.CustomerServiceI;

public class CustomerService implements CustomerServiceI {
private CustomerDaoI customerDao;
	@Override
	public Customer getCustomer(String phoneNo) {
		customerDao=new CustomerDao();
		return customerDao.getCustomer(phoneNo);
		
	}
	@Override
	public List<Book> getAllBooks() {
		customerDao=new CustomerDao();
		return customerDao.getAllBooks();
	}

	

}
