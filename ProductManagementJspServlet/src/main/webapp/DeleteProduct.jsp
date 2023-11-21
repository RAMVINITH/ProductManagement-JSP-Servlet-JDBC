<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>


form {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
  
}

</style>
<body>
<h1>Delete Product</h1>
<form action="DeleteServlet" method="post">
<Label>Enter the Product ID :</Label>
<input type="text" name="prodId">
<input type="submit" value="Delete">
</form>
<form action="Index.jsp" method="get">
<input type="submit" value="Back to Main Page ">
</form>
<% 
   if(request.getAttribute("out")!=null)
   {
   String res=request.getAttribute("out").toString();

%>
<h1><%= res%></h1>
<%}%>

</body>
</html>