
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/styles.css" rel="stylesheet"/>
</head>
<body>
Name:<%= request.getParameter("name") %>
<h2> This is a JSP page !!</h2>

<!-- This is a Scriptlet -->
<%
		Date today =  new Date();
%>

<!--  directives -->
<%@page import="java.util.*,com.jpmc.bean.Book"  %>

<!--  Expression tags -->
<h2 style=color:blue>Today is : <%= today %></h2>

<jsp:include page="header.html"/> <!--  action tags -->
<!--  declaration tags -->
<% List<Book> books = new ArrayList<>(); 
%>

<%-- <% List<Book> books = new ArrayList<>(); 
%> --%>

<%
books.add(new Book("5432","JSP","BS",120,100,"technical"));
books.add(new Book("5432","JSP","BS",120,100,"technical"));
books.add(new Book("5432","JSP","BS",120,100,"technical"));
%>

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

</tr>
<%} %>
</table>




<%! int x=10; %>
X=<%= ++x %>

<%int y=10; %>
Y=<%= ++y %>

</body>
</html>

