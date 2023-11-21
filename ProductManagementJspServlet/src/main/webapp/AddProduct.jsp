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
<h1>Enter the Product Details</h1>
     <form action="AddServlet" method="Post">
     <label>Product Name :</label>
     <input type="text" name="prodName"><br/><br/>
     <label>Price :</label>
     <input type="text" name="Price"><br/><br/>
     <label>Quantity :</label>
     <input type="text" name="Quantity"><br/><br/>
     <label>Discount :</label>
     <input type ="text" name="Discount"><br/><br/>
     <input type="submit" value="Add Product">
     </form>
     
<% 
   if(request.getAttribute("out")!=null)
   {
   String res=request.getAttribute("out").toString();

%>
<h1><%= res%></h1>
<%}%>
<form action="Index.jsp" method="get">
<input type="submit" value="Back to Main Page ">
</form>

</body>
</html>