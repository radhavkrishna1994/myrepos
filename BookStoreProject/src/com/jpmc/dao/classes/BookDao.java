package com.jpmc.dao.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jpmc.bean.Book;
import com.jpmc.dao.interfaces.BookDaoInterface;

public class BookDao implements BookDaoInterface{
	private Connection connection;	
	public BookDao()
		{
			connection=DbConnection.getConnection();
		}
	@Override
	public int addBook(String isbn, String title, String author, double price,
			long stock,String genre) {
		try{
		String template ="insert into book values(?,?,?,?,?,?)";
		PreparedStatement pstmt = connection.prepareStatement(template);
		
		pstmt.setString(1, isbn);  pstmt.setString(2, title);
		pstmt.setString(3, author);pstmt.setDouble(4, price);
		pstmt.setLong(5, stock);
		pstmt.setString(6,genre);
		
		return pstmt.executeUpdate();
				
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteBook(String isbn) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
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

	@Override
	public int updateStock(String isbn, long newStock) {
		
		return 0;
	}

}
