package com.DAO;

import java.io.IOException;
import java.sql.Connection;
//import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import com.Product.Product;
import com.exception.DuplicateProduct;
import com.exception.EmptyProduct;
import com.exception.ProductNOTFOUNDEXCEPTION;


public class ProductDao extends HttpServlet
{
    String url="jdbc:mysql://localhost:3306/db";
    String username="root";
    String password="Ramvinith@7";

    public Connection getCon() throws ClassNotFoundException, SQLException
    {
//    	System.out.println("in connection");
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection con=DriverManager.getConnection(url,username,password);
    	return con;
    	
    }
	
	public boolean add(Product newProd) throws DuplicateProduct, ClassNotFoundException, SQLException
	{
		
        
    	
    	Connection con=getCon();
		PreparedStatement st=con.prepareStatement("Select * from Product where prodId=?");
		st.setInt(1, newProd.getProdID());
		ResultSet rs=st.executeQuery();
		if(rs.next())
			throw new DuplicateProduct();
		else
		{
			st=con.prepareStatement("insert into Product values(?,?,?,?,?)");
			st.setInt(1,newProd.getProdID());
			st.setString(2,newProd.getProdName());
			st.setInt(3,newProd.getPrice());
			st.setInt(4,newProd.getQuantity());
			st.setInt(5,newProd.getDiscount());
			st.execute();
			return true;
			
		}
		
	}
	public List<Product> display() throws SQLException, ClassNotFoundException, EmptyProduct, IOException, ProductNOTFOUNDEXCEPTION
	{ 
		
		Connection con=getCon();
		String sql="Select * from product";
		PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        Product newProd;
        List<Product> prodList=new ArrayList<>();
        
        if(rs.next())
        {
        	do
        	{
        		    newProd=new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));
        		    prodList.add(newProd);
//        			System.out.println("Product ID= "+rs.getInt(1)+", Product Name="+rs.getString(2)+", Price ="+rs.getInt(3)+", Quantity ="+rs.getInt(4)+", Discount="+rs.getInt(5));
        	}
        	while(rs.next());
        	return prodList;
        
        }
        else
        	throw new ProductNOTFOUNDEXCEPTION();

		
	}
	public boolean update(int prodId,String prodName,int price,int quantity,int discount) throws ProductNOTFOUNDEXCEPTION, SQLException, ClassNotFoundException
	{
		
		Connection con=getCon();
		PreparedStatement st=con.prepareStatement("Select * from Product where prodId=?");
		st.setInt(1, prodId);
		ResultSet rs=st.executeQuery();
		if(rs.next())
		{
			st=con.prepareStatement("Update Product set prodName=?,price=?,quantity=?,discount=? where prodId=?");
			st.setString(1, prodName);
			st.setInt(2,price);
			st.setInt(3, quantity);
			st.setInt(4, discount);
			st.setInt(5,prodId);
			st.execute();
			return true;
		}
		else
			throw new ProductNOTFOUNDEXCEPTION();	
	}
	
	
	public boolean deleteProd(int prodId)throws ProductNOTFOUNDEXCEPTION, ClassNotFoundException, SQLException
	{
	    Connection con=getCon();
		PreparedStatement st=con.prepareStatement("Select * from Product where prodId=?");
		st.setInt(1, prodId);
		ResultSet rs=st.executeQuery();
		if(rs.next())
		{
		    st=con.prepareStatement("Delete from Product where prodId=?");
		    st.setInt(1, prodId);
		    st.execute();
		    return true;
		}
		else
			throw new ProductNOTFOUNDEXCEPTION();
	}
	public Product searchProductById(int prodId) throws ProductNOTFOUNDEXCEPTION, ClassNotFoundException, SQLException
	{
		
		Connection con=getCon();
		PreparedStatement st=con.prepareStatement("Select * from Product where prodId=?");
		st.setInt(1, prodId);
		ResultSet rs=st.executeQuery();
		if(rs.next())
		{
			Product prod=new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));
			return prod;
		}
		else 
			throw new ProductNOTFOUNDEXCEPTION();
	}
	public Product searchProductByName(String prodName) throws ProductNOTFOUNDEXCEPTION, SQLException, ClassNotFoundException
	{
		Connection con=getCon();
		PreparedStatement st=con.prepareStatement("Select * from Product where prodName=?");
		st.setString(1, prodName);
		ResultSet rs=st.executeQuery();
		if(rs.next())
		{
			Product prod=new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));
			return prod;
		}
		else 
			throw new ProductNOTFOUNDEXCEPTION();
	}
	public List<Product> displayProdByPrice() throws SQLException, ClassNotFoundException
	{
		
		Connection con=getCon();
		PreparedStatement st=con.prepareStatement("Select * from Product");
		ResultSet rs=st.executeQuery();
		Product prod;
		List<Product>prodList=new ArrayList<>();
		while(rs.next())
		{
			prod=new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));
			prodList.add(prod);
		}
		return prodList;

	}
	
	public List<Product> displayProdByDiscount() throws ClassNotFoundException, SQLException
	{
		
		Connection con=getCon();
		PreparedStatement st=con.prepareStatement("Select * from Product");
		ResultSet rs=st.executeQuery();
		Product prod;
		List<Product>prodList=new ArrayList<>();
		while(rs.next())
		{
			prod=new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));
			prodList.add(prod);
		}
		return prodList;

	}

}
