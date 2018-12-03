package com.jpmc.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jpmc.bean.Book;


public class CustomerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("Customer Servlet");
		String action =  request.getParameter("action");
		String path="";
		switch(action){
		case "add":
			String isbn =  request.getParameter("isbn");
			System.out.println("Isbn received:"+isbn);
			HttpSession session = request.getSession();
			List<Book> books = (List<Book>) session.getAttribute("books");
			Book book = search(books,isbn);
			List<Book> cart =null;
			cart = (List<Book>) session.getAttribute("cart");
			if(cart==null) 
				cart=new ArrayList<>();//cart is created when 1st book is added

			cart.add(book);
			session.setAttribute("cart", cart); // cart is added to the session each time
			System.out.println(cart);
			path="customerHome.jsp";
			request.getRequestDispatcher(path).forward(request, response);
			break;
			
		case "signout":
			session = request.getSession();
		    cart=(List<Book>)session.getAttribute("cart");
		    cart.clear();
		    session.invalidate();
			request.getRequestDispatcher("login.jsp").forward(request, response); 
			
			break;
			
		
		}
		
		
	}
	private double calculateBillAmount(List<Book> cart) {
	double amount=0;
		for(Book book:cart)
		{
			amount+=book.getPrice();
		}
		return amount;
			
		}
		
	
	private Book search(List<Book> books, String isbn) {

		for(Book book:books)
		{
			if(book.getIsbn().equals(isbn)) return book;
		}
		return null;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
