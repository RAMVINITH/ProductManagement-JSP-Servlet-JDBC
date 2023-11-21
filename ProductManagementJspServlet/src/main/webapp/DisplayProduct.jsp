

<%@ page import="java.util.*" %>
<%@ page import="com.Product.Product" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
table, th, td {
  border:1px solid black;
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<body>


<h1>Product Details</h1>

<%
if(request.getAttribute("out")!=null)
{
	String res=request.getAttribute("out").toString();
%>
	<h2><%= "PRODUCT NOT FOUND" %></h2>
<% }
else{ %>
<table>
        <tr>
        <th>Product ID</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Discount</th>
        </tr>
        
        <%
        List<Product> prodList=(ArrayList<Product>)request.getAttribute("prodList");
        for(Product prod:prodList){
        %>
           <tr>
               <td><%= prod.getProdID() %></td>
               <td><%= prod.getProdName() %></td>
               <td><%= prod.getPrice() %></td>
               <td><%= prod.getQuantity() %></td>
               <td><%= prod.getDiscount() %></td>
           </tr>
        <%} %> 

</table>
<%} %>

<br/><br/>




<form action="Index.jsp" method="get">
<input type="submit" value="Back to Main Page ">
</form>




</body>
</html>