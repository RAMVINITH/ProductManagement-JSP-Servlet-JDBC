<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
</head>
<style>


div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
  
}

</style>

<body>
<H1>Product Management</H1>
<div class="centre-form">
     <form action="AddProduct.jsp" method="post">
     <input type="submit" value="Add Product">
     </form>
     
     <br/>
     
     <form action="UpdateProduct.jsp" method="Post">
     <input type="submit" value="Update product">
     </form>
     
     <br/>
     
     <form action="DeleteProduct.jsp" method="Post">
     <input type="submit" value="Delete Product">
     </form>
     
     <br/>
     
     <form action="DisplayServlet" method="Post">
     <input type="submit" value="Display All Product">
     </form>
     
     <br/>   
  </div>
</body>
</html>