package com.ProductServlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Product.Product;
import com.exception.DuplicateProduct;
import com.exception.ProductNOTFOUNDEXCEPTION;
import com.service.ProductService;


@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int min=1,max=100;
		int prodId=(int) (Math.random()*(max-min+1)+min);
		String prodName=request.getParameter("prodName");
		int price=Integer.parseInt(request.getParameter("Price"));
		int quantity=Integer.parseInt(request.getParameter("Quantity"));
		int discount=Integer.parseInt(request.getParameter("Discount"));
//		System.out.println(prodName+" "+price+" "+quantity+" "+discount);
		Product newProd=new Product(prodId,prodName,price,quantity,discount);
		ProductService ser=new ProductService();
		try {
			if(ser.add(newProd))
			{
				request.setAttribute("out", "Product Added");
				request.getRequestDispatcher("AddProduct.jsp").forward(request,response);
			}	
		} 
		catch (ClassNotFoundException | DuplicateProduct | SQLException e)
		{
			// TODO Auto-generated catch block
			request.setAttribute("out", e.toString());
			request.getRequestDispatcher("AddProduct.jsp").forward(request,response);
		}
			
		
	
	}

}
