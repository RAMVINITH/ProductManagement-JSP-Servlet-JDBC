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


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int prodId=Integer.parseInt(request.getParameter("prodId"));
		try {
			
			if(new ProductService().deleteProd(prodId))
			{
				request.setAttribute("out", "Product Deleted");
				request.getRequestDispatcher("DeleteProduct.jsp").forward(request,response);
			}
		} catch (ClassNotFoundException | ProductNOTFOUNDEXCEPTION | SQLException e) {
			request.setAttribute("out", e.toString());
			request.getRequestDispatcher("DeleteProduct.jsp").forward(request,response);
		}
	}

}
