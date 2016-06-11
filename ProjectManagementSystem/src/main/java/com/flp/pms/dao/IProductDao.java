package com.flp.pms.dao;


import java.util.Date;
import java.util.List;
import java.util.Map;

import com.flp.pms.domain.Category;
import com.flp.pms.domain.Discount;
import com.flp.pms.domain.Product;
import com.flp.pms.domain.SubCategory;
import com.flp.pms.domain.Supplier;

public interface IProductDao {
public List<Category> getAllCategory();
public List<SubCategory> getAllSubCategory();
public List<Supplier> getAllSuppliers();
public List<Discount> getAllDiscounts();

public void addProduct(Product product);
public Map<Integer, Product> getAllProducts();
public List<Product> viewAllProductList();
public void updateProductName(Product product,String productName);
public void updateExpiryDate(Product product,Date expiryDate);
public void updateMaxRetailPrice(Product product, double mrp);
public void updateRating(Product product,float rating);
public void updateCategory(Product product,Category category);
public void deleteProduct(int product_Id);
}
