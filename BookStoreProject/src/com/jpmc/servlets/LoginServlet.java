package com.jpmc.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jpmc.bean.Book;
import com.jpmc.bean.Customer;
import com.jpmc.bean.User;
import com.jpmc.dao.classes.LoginDao;
import com.jpmc.dao.interfaces.LoginDaoI;
import com.jpmc.services.classes.CustomerService;
import com.jpmc.services.classes.LoginService;
import com.jpmc.services.interfaces.CustomerServiceI;
import com.jpmc.services.interfaces.LoginServiceI;


public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		LoginServiceI loginService=new LoginService();
		CustomerServiceI customerService=null;
		//System.out.println(login.validateUser(new User("2222222222", "sam", "")));
		User user=new User(request.getParameter("phoneNo"), request.getParameter("password"),"");
		user = loginService.validateUser(user);
		System.out.println(user);
		String path="";
		String errorMessage="User Not Valid";
		if(user==null)
		{
			path="login.jsp";
			 request.setAttribute("message", errorMessage);
		}
		else 
		{
			if(user.getRole().equalsIgnoreCase("admin")) path="adminHome.jsp";
			else	{
				customerService = new CustomerService();
				Customer customer  = customerService.getCustomer(user.getPhoneNo());
				List<Book> books = customerService.getAllBooks();
				session =  request.getSession();
				session.setAttribute("customer",customer);
				session.setAttribute("books",books);
				path="customerHomeEl.jsp";
			//	System.out.println(customer);
			}
		}
		request.getRequestDispatcher(path).forward(request, response);
		/*
		 * if user is null go to login.jsp with error message
		 * else if role is admin go to adminHome.jsp
		 * else if role is customer 
		 * 	  get Customer from db based on phone number
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
