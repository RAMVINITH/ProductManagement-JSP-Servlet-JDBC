package com.ProductServlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exception.ProductNOTFOUNDEXCEPTION;
import com.service.ProductService;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("updateServlet");
		 int prodId=Integer.parseInt(request.getParameter("prodId"));
		 String prodName=request.getParameter("prodName");
	     int price=Integer.parseInt(request.getParameter("price"));
	     int quantity=Integer.parseInt(request.getParameter("quantity"));
	     int discount=Integer.parseInt(request.getParameter("discount"));
	     
	      try {
			if(new ProductService().update(prodId, prodName, price, quantity, discount))
			{
				request.setAttribute("out", "Product updated");
				request.getRequestDispatcher("UpdateProduct.jsp").forward(request,response);
			}
		} catch (ClassNotFoundException | ProductNOTFOUNDEXCEPTION | SQLException e) {
			request.setAttribute("out", e.toString());
			request.getRequestDispatcher("UpdateProduct.jsp").forward(request,response);
		}
	}

}
