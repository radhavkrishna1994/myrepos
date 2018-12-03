<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
body
{
background-color: rgb(100,150,10);
font-family: sans-serif;
font-size: 18px;
}
input[type="text"],input[type="password"],input[type="date"]
,input[type="submit"]
{
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
	border-radius:15px;
}
#form
{
background-color: grey;
    border: 3px solid #f1f1f1;
	width:20%;
	padding:60px;
	border-radius:15px;
	margin: 0 auto;

}
#s:hover {
    opacity: 0.5;
	background-color:rgb(22, 100, 54);
}
</style>
</head>
<body>

<% if(session!=null) session.invalidate(); %>

<form id="form" action="LoginServlet" method="get">
<% String message = (String)request.getAttribute("message");
if(message!=null){
%>
<p style='color:red'><%= message %></p>
<% request.removeAttribute("message");} %>
<input type="text" name="phoneNo"  placeholder="phoneNo"/><br/>
<input type="password" name="password" placeholder="password"/><br/>
<!-- <select name="role">
<option value="admin">admin</option>
<option value="user">user</option>
</select> -->
<input id ="s" type="submit" value="login"/>

</form>
</body>
</html>