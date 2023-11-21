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
<h1>Update Product Details</h1>
     <form action="UpdateServlet" method="Post">
     <label>Product ID :</label>
     <input type="text" name="prodId"><br/><br/>
     <label>Product Name :</label>
     <input type="text" name="prodName"><br/><br/>
     <label>Price :</label>
     <input type="text" name="price"><br/><br/>
     <label>Quantity :</label>
     <input type="text" name="quantity"><br/><br/>
     <label>Discount :</label>
     <input type ="text" name="discount"><br/><br/>
     
     <input type="submit" value="Update product">
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