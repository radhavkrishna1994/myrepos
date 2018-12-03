<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%  String name="peter"; %>
<button  id="b1">Here</button> 
<p id="p1"></p>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
</script>
<script>

$(document).ready(function() {
	$("#b1").click(function(){
		
		$.ajax({
			  url: "http://localhost:8080/BookStoreProject/demo.jsp?name=",
			  type: "get", //send it through get method
			  /* data: { 
			    name: ${name}, 
			    userid: "234", 
			    } ,*/
			  success: function(response) {
			    
				  alert("sent")
				  $("#p1").html(response);
			  },
			  error: function(xhr) {
			    alert("Not Sent")
			  }
			}); 
});
});

</script>


<!--   $.ajax({
  url: "demo.jsp",
  type: "get", //send it through get method
  data: { 
    name: "sam", 
    userid: "234", 
    },
  success: function(response) {
    //Do Something
  },
  error: function(xhr) {
    //Do Something to handle error
  }
}); -->



</body>
</html>