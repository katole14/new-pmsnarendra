package com.flp.pms.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.flp.pms.domain.Category;
import com.flp.pms.domain.Discount;
import com.flp.pms.domain.Product;
import com.flp.pms.domain.SubCategory;
import com.flp.pms.domain.Supplier;

public interface IProductService {
public List<Category> getAllCategory();
public List<SubCategory> getAllSubCategory();
public List<Supplier>getAllSuppliers();
public List<Discount> getAllDiscounts() ;
public void addProduct(Product product);
public Map<Integer, Product> getAllProducts();
public List<Product> viewAllProductList();
public Product search_By_Name(String productName);
public List<Product> search_By_SupplierName(String  suppiler_Name);
public List<Product> search_By_CtaegoryName(String category_Name);
public List<Product> search_By_SubCategoryName(String Subcategory_Name);
public List<Product> search_By_Rating(int rating);
public Product search_By_ProductId(int product_Id);
public void updateProductName(Product product,String productName);
public void updateExpiryDate(Product product,Date expiry_date);
public void updateMaxRetailPrice(Product product,double mrp);
public void updateRating(Product product,float rating);
public void updateCategory(Product product,Category category);
public void deleteProduct(int product_Id);
}
