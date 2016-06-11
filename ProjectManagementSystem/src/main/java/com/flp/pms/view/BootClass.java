package com.flp.pms.view;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.flp.pms.domain.Category;
import com.flp.pms.domain.Product;
import com.flp.pms.service.IProductService;
import com.flp.pms.service.ProductServiceImpl;

public class BootClass {
	public static void main(String args[]) {
		menuSelection();
	}

static void menuSelection(){
	int option;
	String  choice;
	Scanner sc=new Scanner(System.in);
	UserInteraction userInteraction=new UserInteraction();
	IProductService iProductService=new ProductServiceImpl();
	do{
	System.out.println("1.Create product"
						+ "\n2.Modify Product"
						+ "\n3.Remove Product"
						+ "\n4.View All Product"
						+ "\n5.Search Product"
						+ "\n6. Exit");
	System.out.println("Enter your option");
	option=sc.nextInt();
	switch(option){
	case 1:
		Product product=userInteraction.addProduct(iProductService.getAllCategory(),iProductService.getAllSubCategory(),
				iProductService.getAllSuppliers(),iProductService.getAllDiscounts());
		iProductService.addProduct(product);
		break;
	case 2:
		 
				int product_Id = userInteraction.getProductId();
				Product p = iProductService.search_By_ProductId(product_Id);
				if (p != null) {
					System.out.println("1.Update Product Name" + "\n2. Update Expiry Date"
							+ "\n3.Update Maximum retail price" + "\n4.Update Rating" + "\n5.Update Category ");
					int ch = sc.nextInt();

					switch (ch) {
					case 1:
						String productName = userInteraction.getProductNameForUpdate();
						iProductService.updateProductName(p, productName);
						break;
					case 2:
						Date expiry_date=userInteraction.getExpiryDateForUpdate();
						iProductService.updateExpiryDate(p,expiry_date);
						break;
					case 3:
						double mrp=userInteraction.getMRP_ForUpdate();
						iProductService.updateMaxRetailPrice(p,mrp);
						break;
					case 4:
						float rating=userInteraction.getRatingForUpdate();
						iProductService.updateRating(p,rating);
						break;
					case 5:
						Category category=userInteraction.getCategory(iProductService.getAllCategory());
						iProductService.updateCategory(p,category);

					}
				}

		break;
	case 3:
		int ProductID=userInteraction.getProductId();
		iProductService.deleteProduct(ProductID);
		break;
	case 4:
		System.out.println(iProductService.viewAllProductList());
		break;
	case 5:
		System.out.println("1.By Name"
							+ "\n2.By producer/Supplier"
							+ "\n3.By Category"
							+ "\n4.By Sub category"
							+ "\n5.By Rating");
		int opt=sc.nextInt();
		
		switch(opt){
		case 1:
			String Prod_Name	= userInteraction.searchByName();
			Product product2=iProductService.search_By_Name(Prod_Name);
			userInteraction.showProduct(product2);
			break;
		case 2:
			String suppiler_Name=userInteraction.searchBySupplier();
			List<Product> product3=iProductService.search_By_SupplierName(suppiler_Name);
			userInteraction.showAllproductByList(product3);
			break;
		case 3:
			String category_Name=userInteraction.searchByCategoryName();
			List<Product> product4=iProductService.search_By_CtaegoryName(category_Name);
			userInteraction.showAllproductByList(product4);
			break;
		case 4:
			String subCategory_Name=userInteraction.searchBySubCategoryName();
			List<Product> product5=iProductService.search_By_SubCategoryName(subCategory_Name);
			userInteraction.showAllproductByList(product5);
			break;
		case 5:
			int rating=userInteraction.searchByrating();
			List<Product> listproduct=iProductService.search_By_Rating(rating);
			userInteraction.showAllproductByList(listproduct);
			break;
		}
		
		break;
	case 6:
		System.exit(0);
		
	}
	System.out.println("You wish to continue?[Y|N]");
	choice= sc.next();
	}while(choice.equalsIgnoreCase("y"));
}



}
