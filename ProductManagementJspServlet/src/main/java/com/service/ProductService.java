package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.exception.DuplicateProduct;
import com.exception.EmptyProduct;
import com.exception.ProductNOTFOUNDEXCEPTION;
import com.DAO.ProductDao;
import com.Product.Product;

public class ProductService {
	
	 ProductDao dao=new ProductDao();

	
	public boolean add(Product newProd) throws DuplicateProduct, ClassNotFoundException, SQLException
	{
		return dao.add(newProd);
		
		
	}
	
	public List<Product> display() throws ClassNotFoundException, SQLException, EmptyProduct, IOException, ProductNOTFOUNDEXCEPTION
	{ 
		List<Product> prodList=dao.display();
		return prodList;
	}
	
	public boolean update(int prodId,String prodName,int price,int quantity,int discount) throws ProductNOTFOUNDEXCEPTION, ClassNotFoundException, SQLException
	{
		return dao.update(prodId, prodName, price, quantity, discount); 
	}
	
	
	public boolean deleteProd(int prodId)throws ProductNOTFOUNDEXCEPTION, ClassNotFoundException, SQLException
	{
		return dao.deleteProd(prodId);
	}
	public void searchProductById(int prodId) throws ProductNOTFOUNDEXCEPTION, ClassNotFoundException, SQLException
	{
		Product prod=dao.searchProductById(prodId);
		if(prod!=null)
		{
			System.out.println("Product ID : " + prod.getProdID());
			System.out.println("Product name : " + prod.getProdName());
			System.out.println("Price : "+prod.getPrice() );
			System.out.println("Quantity : "+prod.getQuantity());
			System.out.println("Discount : "+ prod.getDiscount());
		}
		else
			throw new ProductNOTFOUNDEXCEPTION();
		
	}
	public void searchProductByName(String prodName) throws ProductNOTFOUNDEXCEPTION, ClassNotFoundException, SQLException
	{
		Product prod=dao.searchProductByName(prodName);
		if(prod!=null)
		{
			System.out.println("Product ID : " + prod.getProdID());
			System.out.println("Product name : " + prod.getProdName());
			System.out.println("Price : "+prod.getPrice() );
			System.out.println("Quantity : "+prod.getQuantity());
			System.out.println("Discount : "+ prod.getDiscount());
		}
		else
			throw new ProductNOTFOUNDEXCEPTION();
			

	}
	public void displayProdByPrice() throws ClassNotFoundException, SQLException, EmptyProduct
	{
		List<Product> newList = dao.displayProdByPrice();
		if(newList.isEmpty())
			throw new EmptyProduct();
		else
		{
			Collections.sort(newList, new Comparator<Product>() {
				public int compare(Product obj, Product obj1) {
					if(obj.getPrice()  > obj1.getPrice()) {
						return 1;
					}
					else if(obj.getPrice() == obj1.getPrice()) {
						return 0;
					}
					return -1;
	 			}
			});

			for(Product obj : newList)
			System.out.println("Product ID= "+obj.getProdID()+", Product Name="+obj.getProdName()+", Price ="+obj.getPrice()+", Quantity ="+obj.getQuantity()+", Discount="+obj.getDiscount());
		}

	}
	
	public void displayProdByDiscount() throws ClassNotFoundException, SQLException, EmptyProduct
	{
       
		
		List<Product> newList = dao.displayProdByDiscount();;
		if(newList.isEmpty())
			throw new EmptyProduct();
		else
		{
			Collections.sort(newList, new Comparator<Product>() {
				public int compare(Product obj, Product obj1) {
					if(obj.getDiscount()  > obj1.getDiscount()) {
						return 1;
					}
					else if(obj.getDiscount() == obj1.getDiscount()) {
						return 0;
					}
					return -1;
	 			}
			});

			for(Product obj : newList)
			System.out.println("Product ID= "+obj.getProdID()+", Product Name="+obj.getProdName()+", Price ="+obj.getPrice()+", Quantity ="+obj.getQuantity()+", Discount="+obj.getDiscount());
		}


	}


}
