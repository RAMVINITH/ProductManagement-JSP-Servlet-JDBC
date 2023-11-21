package com.ProductServlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Product.Product;
import com.exception.EmptyProduct;
import com.exception.ProductNOTFOUNDEXCEPTION;
import com.service.ProductService;


@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			List<Product> prodList;
				prodList = new ProductService().display();
				request.setAttribute("prodList", prodList);
				request.getRequestDispatcher("DisplayProduct.jsp").forward(request,response);	
			
		} catch (ClassNotFoundException | SQLException | EmptyProduct | ProductNOTFOUNDEXCEPTION e) {
			// TODO Auto-generated catch block
			request.setAttribute("out", e.toString());
			request.getRequestDispatcher("DisplayProduct.jsp").forward(request,response);
			e.printStackTrace();
		}
	}

}
