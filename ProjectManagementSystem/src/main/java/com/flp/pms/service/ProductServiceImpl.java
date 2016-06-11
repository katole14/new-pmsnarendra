package com.flp.pms.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.flp.pms.dao.IProductDao;
import com.flp.pms.dao.ProductDaoImplForJdbc;
import com.flp.pms.dao.ProductDaoImplForMap;
import com.flp.pms.domain.Category;
import com.flp.pms.domain.Discount;
import com.flp.pms.domain.Product;
import com.flp.pms.domain.SubCategory;
import com.flp.pms.domain.Supplier;

public class ProductServiceImpl implements IProductService{
	private IProductDao iProductDao=new ProductDaoImplForJdbc();

	public List<Category> getAllCategory() {
		
		return iProductDao.getAllCategory(); 
	}

	public List<SubCategory> getAllSubCategory() {
		return iProductDao.getAllSubCategory();
	}
	
	public List<Supplier> getAllSuppliers() {
		
		return iProductDao.getAllSuppliers();
	}
	

	public List<Discount> getAllDiscounts() {
		return iProductDao.getAllDiscounts();
	}

	public void addProduct(Product product) {
		//Map<Integer, Product> maps=iProductDao.getAllProducts();
		//boolean flag=false;
		//Set<Integer> product_IDS=maps.keySet();
		int product_id_generated=generateProductId();
		
		//Generate unique Product Id
		/*if(!maps.isEmpty()){
			do{
				
				product_id_generated=generateProductId();
				for(Integer product_Id:product_IDS){
					if(product_Id==product_id_generated){
						flag=true;
						break;
					}
				}
			}while(flag);
			
			
		}*/
		product.setProduct_Id(product_id_generated);
		
		iProductDao.addProduct(product);
		
	}
	
	public int generateProductId(){
		return (int)(Math.random()*10000);
	}

	public Map<Integer, Product> getAllProducts() {
	
		return iProductDao.getAllProducts();
	}
	
	@Override
	public List<Product> viewAllProductList() {
		
		return iProductDao.viewAllProductList();
	}

	/*public List<Product>  getAllProductsList(){
		
		Collection<Product> productcollection=getAllProducts().values();
		List<Product> listAllproduct=new ArrayList<Product>();
		for (Product product:productcollection)
			listAllproduct.add(product);
		return listAllproduct;
			
	}*/
	/*public Product search_By_Name(String productname){
		Product p=null;
		List<Product> listproduct=getAllProductsList();
		for(Product pro:listproduct){
			if(pro.getProduct_Name().equalsIgnoreCase(productname)){
				p=pro;
				break;
			}
		}
		return p;
	}*/

	
	
	public Product search_By_Name(String productName) {
		List<Product> productlist=viewAllProductList();
		Product pro=new Product();
		for(Product p:productlist){
			if(p.getProduct_Name().equalsIgnoreCase(productName)){
				pro=p;
			}
		}
		return pro;
	}
	
	
	
	
	public List<Product> search_By_SupplierName(String suppilerName) {
		List<Product> porductlist=new ArrayList<>();
		List<Product> listproduct=viewAllProductList();
		for(Product pro:listproduct){
			if(pro.getSupplier().getFirst_Name().equalsIgnoreCase(suppilerName)){
				porductlist.add(pro);
				
			}
		}
		return porductlist;
	}

	public List<Product> search_By_CtaegoryName(String category_Name) {
		List<Product> productlist=new ArrayList<>();
		List<Product> listproduct=viewAllProductList();
		for(Product pro:listproduct){
			if(pro.getCategory().getCategory_Name().equalsIgnoreCase(category_Name)){
				productlist.add(pro);
				
			}
		}
		return productlist;
	}

	public List<Product> search_By_SubCategoryName(String Subcategory_Name) {
		List<Product> productlist=new ArrayList<>();
		List<Product> listproduct=viewAllProductList();
		for(Product pro:listproduct){
			if(pro.getSubCategory().getSubCategory_Name().equalsIgnoreCase(Subcategory_Name)){
				productlist.add(pro);
			
			}
			
		}
		return productlist;
	}

	public List<Product> search_By_Rating(int rating) {
		List<Product> list_product=new ArrayList<Product>();
		List<Product> productlist=viewAllProductList();
		for(Product pro:productlist){
			if(pro.getRating()==rating){
				list_product.add(pro);
			}
		}
		return list_product;
	}

	public Product search_By_ProductId(int product_Id) {
		Product p=null;
		List<Product> listproduct=viewAllProductList();
		for(Product pro:listproduct){
			if(pro.getProduct_Id()==product_Id)
				p=pro;
		}
		return p;
	}

	
	
	public void updateProductName(Product product, String productName) {
		iProductDao.updateProductName(product, productName);
	}

	public void updateExpiryDate(Product p, Date expiryD) {
		iProductDao.updateExpiryDate(p,expiryD);
	}

	public void updateMaxRetailPrice(Product product, double mrp) {
		iProductDao.updateMaxRetailPrice(product,mrp);
	}

	public void updateRating(Product product, float rating) {
		iProductDao.updateRating(product,rating);
	}

	public void updateCategory(Product product, Category category) {
		iProductDao.updateCategory(product,category);
	}

	@Override
	public void deleteProduct(int product_Id) {
		iProductDao.deleteProduct(product_Id);
		
	}

	
	

	
}
