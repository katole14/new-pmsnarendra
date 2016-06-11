package com.flp.pms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.flp.pms.domain.Category;
import com.flp.pms.domain.Discount;
import com.flp.pms.domain.Product;
import com.flp.pms.domain.SubCategory;
import com.flp.pms.domain.Supplier;
import com.mysql.jdbc.Statement;

public class ProductDaoImplForJdbc implements IProductDao {
	public List<Category> getAllCategory(){
		List<Category> categories=new ArrayList<Category>();
		Category category=null;
		Connection conn= getMySqlConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {
			String sql="select * from category";
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()){
				category=new Category();
				category.setCategory_Id(rs.getInt("category_Id"));
				category.setCategory_Name(rs.getString("category_Name"));
				category.setDescription(rs.getString("description"));
				categories.add(category);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				if(stmt!=null)
				stmt.close();
				if(conn!=null)
					conn.close();
				if (rs!=null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
		
		return categories;
	}

	
	public List<Supplier> getAllSuppliers(){
		List<Supplier> suppliers=new ArrayList<Supplier>();
		Supplier supplier=null;
		Connection conn=getMySqlConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String sql="select * from supplier";
		try {
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()){
				supplier=new Supplier();
				supplier.setSupplier_Id(rs.getInt("supplierId"));
				supplier.setFirst_Name(rs.getString("firstName"));
				supplier.setLast_Name(rs.getString("lastName"));
				supplier.setAddress(rs.getString("address"));
				supplier.setCity(rs.getString("city"));
				supplier.setState(rs.getString("state"));
				supplier.setPincode(rs.getString("pincode"));
				supplier.setContact_Number(rs.getString("contactno"));
				suppliers.add(supplier);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				if(stmt!=null)
				stmt.close();
				if(conn!=null)
					conn.close();
				if (rs!=null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		return suppliers;
	}
	
	
	public List<SubCategory> getAllSubCategory(){
		List<Category> categories=getAllCategory();
		
		List<SubCategory> subCategories=new ArrayList<SubCategory>();
		SubCategory subCategory=null;
		Category category=null;
		Connection conn=getMySqlConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String sql="select * from subcategory";
		try {
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()){
				subCategory=new SubCategory();
				subCategory.setSubCategory_Id(rs.getInt("sub_category_Id"));
				subCategory.setSubCategory_Name(rs.getString("sub_category_Name"));
				int category_id=rs.getInt("category_Id");
				for(Category c:categories){
					if(c.getCategory_Id()==category_id){
						subCategory.setCategory(c);
					}
				}
				subCategories.add(subCategory);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
				try {
					if(stmt!=null)
					stmt.close();
					if(conn!=null)
						conn.close();
					if (rs!=null)
						rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return subCategories;
	}
	
	
	
	
	public List<Discount> getAllDiscounts(){
		List<Discount> discounts=new ArrayList<Discount>();
		Discount discount=null;
		Connection conn=getMySqlConnection();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String sql="select * from discount";
		try {
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()){
				discount=new Discount();
				discount.setDiscount_Id(rs.getInt("discountId"));
				discount.setDiscount_Name(rs.getString("discountName"));
				discount.setDiscription(rs.getString("description"));
				discount.setDiscount_percentage(rs.getDouble("discount_percentage"));
				discount.setValid_through(rs.getDate("validThru"));
				discounts.add(discount);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				if(stmt!=null)
				stmt.close();
				if(conn!=null)
					conn.close();
				if (rs!=null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		return discounts;
	}
	
	
	public void addProduct(Product product){
		int count1=0;
		int count2=0;
		ResultSet rs=null;
		String sql1="insert into product(productName,description,manufacturing_date,expiry_date,max_retail_price,"
				+ "category_Id,sub_category_Id,supplierId,quantity,ratings)values (?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt=getMySqlConnection().prepareStatement(sql1);
			stmt.setString(1, product.getProduct_Name());
			stmt.setString(2, product.getDescription());
			stmt.setDate(3, new java.sql.Date(product.getManufacturing_Date().getTime()));
			stmt.setDate(4, new java.sql.Date(product.getExpiry_Date().getTime()));
			stmt.setDouble(5, product.getMaximum_Retail_Price());
			stmt.setInt(6, product.getCategory().getCategory_Id());
			stmt.setInt(7, product.getSubCategory().getSubCategory_Id());
			stmt.setInt(8, product.getSupplier().getSupplier_Id());
			stmt.setInt(9, product.getQuantity());
			stmt.setDouble(10, product.getRating());
			count1=stmt.executeUpdate();
			String sql2="select * from product";
			PreparedStatement stmt1=getMySqlConnection().prepareStatement(sql2);
			int id=0;
			rs=stmt1.executeQuery();
			while(rs.next()){
				id=rs.getInt("productId");
			}
			String sql3="insert into productdiscounttable value(?,?)";
			PreparedStatement stmt2=getMySqlConnection().prepareStatement(sql3);
			List<Discount> discounts=product.getDiscounts();
			for(Discount d:discounts){
				stmt2.setInt(1, id);
				stmt2.setInt(2, d.getDiscount_Id());
				count2=stmt2.executeUpdate();
			}
			//System.out.println(count1);
			//System.out.println(count2);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	Connection getMySqlConnection(){
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root", "India123");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}


	
	public Map<Integer, Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Product> viewAllProductList() {
		List<Product> productList=new ArrayList<Product>();
		Connection conn=null;
		PreparedStatement pst=null;
		
		ResultSet rs=null;
		ResultSet rs1=null;
		
		
		try{
			
			
			conn=getMySqlConnection();
			String sql="select * from product";
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				Product product=new Product();
				product.setProduct_Id(rs.getInt("productId"));
				product.setProduct_Name(rs.getString("productName"));
				product.setDescription(rs.getString("description"));
				product.setManufacturing_Date(rs.getDate("manufacturing_date"));
				product.setExpiry_Date(rs.getDate("expiry_date"));
				product.setMaximum_Retail_Price(rs.getDouble("max_retail_price"));
				product.setQuantity(rs.getInt("quantity"));
				product.setRating(rs.getFloat("ratings"));
				
				int category_Id=rs.getInt("category_Id");
				for(Category c:getAllCategory()){
					if(c.getCategory_Id()==category_Id){
						product.setCategory(c);
					}
				}
				
				
				int subcategoryid=rs.getInt("sub_category_Id");
				for(SubCategory sub:getAllSubCategory()){
					if(sub.getSubCategory_Id()==subcategoryid){
						product.setSubCategory(sub);
					}
				}
				
				
				int supllier_id=rs.getInt("supplierId");
				for(Supplier s:getAllSuppliers()){
					if (s.getSupplier_Id()==supllier_id){
						product.setSupplier(s);
					}
				}
				
				
				
				String sql1="select * from productdiscounttable where productId=?";
				
				PreparedStatement pst1=conn.prepareStatement(sql1);
				pst1.setInt(1, product.getProduct_Id());
				rs1=pst1.executeQuery();
				List<Discount> appliedDiscount=new ArrayList<Discount>();
				while(rs1.next()){
					Discount d=new Discount();
					int disId=rs1.getInt(2);
					for(Discount dis:getAllDiscounts()){
						if(disId==dis.getDiscount_Id()){
							appliedDiscount.add(dis);
						}
					}
				}
				product.setDiscounts(appliedDiscount);
				productList.add(product);
				
			}
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}


	@Override
	public void updateProductName(Product product, String productName) {
		
		Connection conn=null;
		PreparedStatement pst=null;
		String sql="update  product set productName=? where productId=?";
		conn=getMySqlConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, productName);
			pst.setInt(2, product.getProduct_Id());
			pst.executeUpdate();
			int count=pst.executeUpdate();
			if(count<=0)
				System.out.println("product Name is not updated ");
			else
				System.out.println("product Name updated successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	@Override
	public void updateExpiryDate(Product product, java.util.Date expiryDate) {
		Connection conn=null;
		PreparedStatement pst=null;
		String sql="update product set expiry_date=? where productId=?";
		conn=getMySqlConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setDate(1,new java.sql.Date (expiryDate.getTime()));
			pst.setInt(2, product.getProduct_Id());
			pst.executeUpdate();
			int count=pst.executeUpdate();
			if(count<=0)
				System.out.println("Product Expiry Date is not Updated");
			else
				System.out.println("Product Expiry Date updated Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public void updateMaxRetailPrice(Product product, double mrp) {
		Connection conn=null;
		PreparedStatement pst=null;
		String sql="update product set max_retail_price=? where productId=?";
		conn=getMySqlConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setDouble(1, mrp);
			pst.setInt(2, product.getProduct_Id());
			pst.executeUpdate();
			int count=pst.executeUpdate();
			if (count<=0)
				System.out.println("Product Maximum Retail Price is not updated ");
			else 
				System.out.println("Product Maximum Retail Price is updated Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public void updateRating(Product product, float rating) {
		Connection conn=null;
		PreparedStatement pst=null;
		String sql="update product set ratings=? where productId=?";
		conn=getMySqlConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setFloat(1, rating);
			pst.setInt(2, product.getProduct_Id());
			pst.executeUpdate();
			int count=pst.executeUpdate();
			if(count<=0)
				System.out.println("Product Rating is not updated");
			else
				System.out.println("product rating is updated successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public void updateCategory(Product product, Category category) {
		Connection conn=null;
		PreparedStatement pst=null;
		String sql="update product set category_Id=? where productId=?";
		conn=getMySqlConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, category.getCategory_Id());
			pst.setInt(2, product.getProduct_Id());
			pst.executeUpdate();
			int count=pst.executeUpdate();
			if(count<=0)
				System.out.println("Product category is not updated");
			else
				System.out.println("Product category is updated successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	@Override
	public void deleteProduct(int product_Id) {
		Connection conn=null;
		PreparedStatement pst=null;
		String sql="delete from product where productId=?";
		String sql1="delete from productdiscounttable where productId=?";
		conn=getMySqlConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, product_Id);
			pst.executeUpdate();
			int count=pst.executeUpdate();
			pst=conn.prepareStatement(sql1);
			pst.setInt(1, product_Id);
			pst.executeUpdate();
			if(count<0)
				System.out.println("Product is not removed ");
			else
				System.out.println("Product Remove Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	
	
	
	
	
	
	
}
