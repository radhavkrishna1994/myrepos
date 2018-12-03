package com.jpmc.dao.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jpmc.bean.Book;
import com.jpmc.bean.Customer;
import com.jpmc.dao.interfaces.CustomerDaoI;

public class CustomerDao implements CustomerDaoI {
	private Connection connection;

	public CustomerDao(){ connection = DbConnection.getConnection();}

	@Override
	public Customer getCustomer(String phoneNo) {
		String template =  "select * from Customer where phoneNo=? ";
		try{
			PreparedStatement pstmt=connection.prepareStatement(template);
			pstmt.setString(1, phoneNo);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				Customer customer = new Customer(rs.getLong(1),
						rs.getString("name"), rs.getString("address"),
						rs.getString("email"), rs.getString("phoneNo"));
				return customer;
			}
			return null;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return null;
	}

	public List<Book> getAllBooks() {
		List<Book> bookList=new ArrayList<>();
		try{
			String query = "select * from Book";
			PreparedStatement pstmt=connection.prepareStatement(query);
			
			/*Statement stmt=connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);*/
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
	Book book=new Book(rs.getString("isbn"),rs.getString("title"),
			rs.getString(3),rs.getDouble(4),rs.getLong(5),rs.getString(6));
	
			bookList.add(book);
			}
			return bookList;
				
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

}
