package com.jpmc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jpmc.bean.Book;
import com.jpmc.dao.classes.BookDao;
import com.jpmc.dao.classes.DbConnection;
import com.jpmc.dao.interfaces.BookDaoInterface;

public class BookServlet extends HttpServlet {
	private Connection connection;
	private String ccNo;
	private String driverClass;
	public void init()
	{
		/*ccNo = getServletConfig().getInitParameter("CustomerCare");
		driverClass = getServletContext().getInitParameter("DriverClass");*/
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*System.out.println("Call us on.."+ccNo);
		System.out.println("Driver class:"+driverClass);*/
		String action = request.getParameter("action");
		String path="";
		switch(action){
		case "store":
	
		BookDaoInterface bookDao = new BookDao();
		List<Book> books = bookDao.getAllBooks();
		request.setAttribute("books",books);
	/*	PrintWriter out=response.getWriter();
		out.print("<table border='1'>");
		
		for(Book b:books)
		{
			out.print("<tr>");
		    out.print("<td>"+b.getTitle()+"</td>");
			out.print("<td>"+b.getPrice()+"</td>");
			out.print("<td>"+b.getStock()+"</td>");
			out.print("<td>"+b.getGenre()+"</td>");
			out.print("</tr>");
		}
		
		out.print("</table");*/ 
		path="store.jsp";
		break;
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDaoInterface bookDao = new BookDao();
		String isbn =  request.getParameter("isbn");
		String title =  request.getParameter("title");
		String author =  request.getParameter("author");
		double price = Double.parseDouble(request.getParameter("price"));
		long stock	= Long.parseLong(request.getParameter("stock"));
		String genre =  request.getParameter("genre");
		int n = bookDao.addBook(isbn, title, author, price, stock, genre);
		PrintWriter out=response.getWriter();
		out.print(n +" records added!");
		
		
	}

}
