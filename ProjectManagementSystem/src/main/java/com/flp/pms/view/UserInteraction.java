package com.flp.pms.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.flp.pms.domain.Category;
import com.flp.pms.domain.Discount;
import com.flp.pms.domain.Product;
import com.flp.pms.domain.SubCategory;
import com.flp.pms.domain.Supplier;
import com.flp.pms.util.Validate;

public class UserInteraction {
	int productId;
	String productName;
	String productDiscription;
	Date manufacturingDate;
	Date expirydate;
	double price;
	int quantity;
	//SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
	public Product addProduct(List<Category> categories,List<SubCategory> subCategories,List<Supplier> suppliers,List<Discount> discounts){
		boolean flag=false;
		Scanner sc=new Scanner(System.in);
		Product product=new Product();
		
		
		do{
		System.out.println("Enter Product Name");
		productName=sc.nextLine();
		flag=Validate.isvalidateName(productName);
		if(!flag)
			System.out.println("Invalid Product Name");
		}while(!flag);
		product.setProduct_Name(productName);
		
		System.out.println("Enter Product Description");
		productDiscription=sc.nextLine();
		product.setDescription(productDiscription);
		String date;
		flag=false;
		do{
		System.out.println("Enter Manufacturing Date of the product [dd-MMM-yyyy]");
		 date=sc.next();
	
			flag=Validate.isValidDate(date);
			if(!flag)
				System.out.println("Invalid Date Format");
			//manufacturingDate=sdf.parse(date);
			
		}while(!flag);
		product.setManufacturing_Date(new Date(date));
		
	
		
		 
		 
		//prompt ExpiryDate
			String expiry_Date;
			boolean ex_flag=false;
			
			//Check valid Expiry Date
			do{
				
				//Validate Date Format
				do{
				System.out.println("Enter Expiry Date:[dd-MMM-yyyy]");
				expiry_Date=sc.next();
				flag=Validate.isValidDate(expiry_Date);
				if(!flag)
					System.out.println("* Invalid Date Format!");
				
				}while(!flag);
			
				ex_flag=Validate.isvalidExpirDate(new Date(expiry_Date));
				
				if(!ex_flag)
					System.out.println("* Expiry Date must be future Date!");
			}while(!ex_flag);
			product.setExpiry_Date(new Date(expiry_Date));
			
		
		
		System.out.println("Enter maximum retail price of the product");
		price=sc.nextDouble();
		product.setMaximum_Retail_Price(price);
		
		do{
		System.out.println("Enter product Quantity");
		quantity=sc.nextInt();
		flag=Validate.isValidquantity(quantity);
		if(!flag)
			System.out.println("Quantity must be greater than 1");
		}while(!flag);
		product.setQuantity(quantity);
	
		
		

		
		//prompt Ratings
		float ratings=0.0f;
		do{
		System.out.println("Enter Product Ratings:");
		ratings=sc.nextFloat();
		flag=Validate.isValidRating(ratings);
		if(!flag)
				System.out.println("* Ratings Should be between 1.0 and 5.0!");
		}while(!flag);
		product.setRating(ratings);
		
		

		//prompt valid category object
		Category category=getCategory(categories);
		product.setCategory(category);
		
		//Prompt SubCategory Details
		SubCategory subCategory=getSubCategory(subCategories, category);
		product.setSubCategory(subCategory);
		
		
		//prompt Supplier Details
		Supplier supplier=getSupplier(suppliers);
		product.setSupplier(supplier);
	
		
		//Prompt Dicsount Details
		List<Discount> discounts2=getDiscounts(discounts);
		product.setDiscounts(discounts2);
		return product;
		
	}
	
	public Category getCategory(List<Category> categories){
		//Choose Category
		Category category=null;
		boolean flag=false;
		
		Scanner sc=new Scanner(System.in);
		int choice;	
		
		do{
			System.out.println("Choose Catgeory Id:");
			for(Category category1:categories)
				System.out.println(category1.getCategory_Id() +"\t" +category1.getCategory_Name() +
						"\t"+category1.getDescription());
			choice=sc.nextInt();
			
			
			
			//Validate the Category
			for(Category category1:categories){
				if(choice==category1.getCategory_Id())
				{
					category=category1;
					flag=true;
					break;
				}               
			}
			if(!flag)
				System.out.println("* Please choose Valid Category ID!");
		}while(!flag);
		
		return category;
	}
	
	

	//Choose Sub Category
	public SubCategory getSubCategory(List<SubCategory> categories,Category category){
		SubCategory subCategory=null;
		Scanner scanner=new Scanner(System.in);
		int option;
		boolean flag=false;
		
		do{
			System.out.println("Choose Product Sub Category:");
			for(SubCategory  subCategory2:categories){
				if(subCategory2.getCategory().getCategory_Id()==category.getCategory_Id())
					System.out.println(subCategory2.getSubCategory_Id() + "\t" + subCategory2.getSubCategory_Name());
					}
			option=scanner.nextInt();
			
			
			//Check Valid SubCategory
			for(SubCategory subCategory2:categories){
				if(option==subCategory2.getSubCategory_Id())
					{
						subCategory=subCategory2;
						flag=true;
						break;
					}
			}
			
			if(!flag)
				System.out.println("* Please choose valid Sub category!");
		
		}while(!flag);
		
		
		return subCategory;
	}
	
	
	public Supplier getSupplier(List<Supplier> suppliers){
		Supplier supplier=null;
		boolean flag=false;
		Scanner scn=new Scanner(System.in);
		int choice;
		
		do{
		System.out.println("Enter Suppiler ID");
		for(Supplier supplier2:suppliers)
			System.out.println(supplier2.getSupplier_Id() +"\t" +supplier2.getFirst_Name() +
					"\t"+supplier2.getLast_Name()+"\t"+supplier2.getAddress()+"\t"+supplier2.getCity()+"\t"+supplier2.getState()
					+"\t"+supplier2.getPincode()+"\t"+supplier2.getContact_Number());
		choice=scn.nextInt();
		
		for(Supplier supplier2:suppliers){
			if(choice== supplier2.getSupplier_Id()){
				supplier=supplier2;
				flag=true;
				break;
				}
		}
		 
			if(!flag)
				System.out.println("Please Choose Valid ");
		}while(!flag);
		return supplier;
	}
	
	
	
	
	
	
	public List<Discount> getDiscounts(List<Discount> discounts){
		List<Discount> discounts2=new ArrayList<Discount>();
		Scanner sc=new Scanner(System.in);
		int option=0;
		boolean flag=false;
		String choice=null;
		
		
		do{
			flag=false;
			do{
				System.out.println("Choose Dicounts for the Product:");
				for(Discount discount:discounts){
					//check valid discounts
					if(discount.getValid_through().after(new Date())){
						//System.out.println(discount.getValidThru());
						System.out.println(discount.getDiscount_Id() + "\t" 
							+discount.getDiscount_Name() + "\t"
							+discount.getDiscription() +"\t"
							+discount.getDiscount_percentage());
					}
							
				}
				option=sc.nextInt();
				
				
				//Validate Discount
			L3:	for(Discount discount:discounts){
					if(discount.getDiscount_Id()==option)
					{
						discounts2.add(discount);
						flag=true;
						break L3;
					}
				}
				
				if(!flag)
					System.out.println("* Choose Valid Discount Id!");
				
			}while(!flag);
			
			System.out.println("You wish to add more discounts for this product?[Y|N]");
			choice=sc.next();
			
		}while(choice.charAt(0)=='y' || choice.charAt(0)=='Y');
		
		return discounts2;
	}
	
	public String searchByName(){
		String productName;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Product Name");
		productName=sc.next();
		return productName;
	}
	
	public void showProduct(Product pro){
		if (pro!=null)
			System.out.println(pro);
		else
			System.out.println("Product Not Found");
		
	}
	
	
	public String searchBySupplier(){
		String supplierName;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the supplier Name");
		supplierName=sc.next();
		return supplierName;
	}
	
	public String searchByCategoryName(){
		String categoryName;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the category Name");
		categoryName=sc.next();
		return categoryName;
	}
	
	public String searchBySubCategoryName(){
		String subCategoryName;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the sub category Name");
		subCategoryName=sc.next();
		return subCategoryName;
	}
	
	public int searchByrating(){
		int rating;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Rating of the Product");
		rating=sc.nextInt();
		return rating;
	}
	
	public void showAllproductByList(List<Product> productList){
		if(productList.isEmpty()){
			System.out.println("Product not found ");
		}
		else{
			for(Product p:productList){
				System.out.println(p);
			}
		}
	}
	
	public int getProductId(){
		int prod_Id;
		//String opt;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Product ID ");
		prod_Id=sc.nextInt();
		//System.out.println("Sure you want remove that Product [Y/N]");
		
		return prod_Id;
	}
	
	
	/*public void removingTheProduct(Map<Integer, Product> products,Product product){
		Set<Integer> productkeys=products.keySet();
		for(int products_Ids:productkeys){
			l1:if(product.getProduct_Id()==products_Ids){
				products.remove(product.getProduct_Id(),product);
				System.out.println("Product remove successfully");
				break l1;
			}
			else{
				System.out.println("Enter correct product Id ");
			}
		}
	}*/
	
	
	
	public String getProductNameForUpdate(){
		String product_name;
		Scanner sc=new Scanner(System.in);
		boolean flag=false;
		do{
		System.out.println("Enter product name for Update");
		product_name=sc.next();
		flag=Validate.isvalidateName(product_name);
		if(!flag)
			System.out.println("Invalid product Name");
		}while(!flag);
		return product_name;
	}
	
	public Date getExpiryDateForUpdate(){
		String expiry_Date;
		boolean flag = false;
		boolean ex_flag = false;
		
		Scanner sc = new Scanner(System.in);
		do {

			// Validate Date Format
			do {
				System.out.println("Enter Expiry Date:[dd-MMM-yyyy]");
				expiry_Date = sc.next();
				flag = Validate.isValidDate(expiry_Date);
				if (!flag)
					System.out.println("* Invalid Date Format!");

			} while (!flag);

			ex_flag = Validate.isvalidExpirDate(new Date(expiry_Date));

			if (!ex_flag)
				System.out.println("* Expiry Date must be future Date!");
		} while (!ex_flag);
		return new Date(expiry_Date);
	}
	
	public double getMRP_ForUpdate(){
		double mrp;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter New Maximum retail price");
		mrp=sc.nextDouble();
		return mrp;
	}
	
	public float getRatingForUpdate(){
		float rating;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter new Rating for the product");
		rating=sc.nextFloat();
		return rating;
	}
	
	
	//public Category getCategoryForUpdate()
	
	
	

}
