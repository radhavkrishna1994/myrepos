<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Store</title>
<link href="css/styles.css" rel="stylesheet"/>
</head>
<body>

<%@ page import="java.util.*,com.jpmc.bean.*" %>
<a href="">My Profile</a>
<% Customer customer =(Customer)session.getAttribute("customer"); %>
<%= customer.getName()%> <br/>
<%= customer.getAddress() %><br/>
<br/>
<br/>
<a href="cart.jsp">View Cart</a> <a style='float:right' href="CustomerServlet?action=signout">signout</a>
<%List<Book> books=(List<Book>)session.getAttribute("books"); %>
<table>
<% for(Book book:books) {
%>
<tr>
<td><%= book.getIsbn() %></td>
<td><%= book.getTitle() %></td>
<td><%= book.getAuthor() %></td>
<td><%= book.getPrice() %></td>
<td><%= book.getStock() %></td>
<td><%= book.getGenre() %></td>
<td><a href="CustomerServlet?action=add&isbn=<%= book.getIsbn() %>">AddToCart</a></td>
</tr>
<%} %>
</table> 
</body>
</html>