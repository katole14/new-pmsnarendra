package com.flp.pms.domain;

import java.util.Date;
import java.util.List;

public class Product {
	
	// pojo class instance variable;
private int product_Id;
private String product_Name;
private String description;
private Date manufacturing_Date;
private Date expiry_Date;
private double maximum_Retail_Price;
private Category category;
private SubCategory subCategory;
private Supplier supplier;
private List<Discount> discounts;
private int quantity;
private float rating;

// No argument constructor
public Product(){
	
}

// full argument constructor
public Product(int product_Id, String product_Name, String description, Date manufacturing_Date, Date expiry_Date,
		double maximum_Retail_Price, Category category, SubCategory subCategory, Supplier supplier,
		List<Discount> discounts, int quantity, float rating) {
	super();
	this.product_Id = product_Id;
	this.product_Name = product_Name;
	this.description = description;
	this.manufacturing_Date = manufacturing_Date;
	this.expiry_Date = expiry_Date;
	this.maximum_Retail_Price = maximum_Retail_Price;
	this.category = category;
	this.subCategory = subCategory;
	this.supplier = supplier;
	this.discounts = discounts;
	this.quantity = quantity;
	this.rating = rating;
}
//public getter and setter
public int getProduct_Id() {
	return product_Id;
}

public void setProduct_Id(int product_Id) {
	this.product_Id = product_Id;
}


public String getProduct_Name() {
	return product_Name;
}


public void setProduct_Name(String product_Name) {
	this.product_Name = product_Name;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


public Date getManufacturing_Date() {
	return manufacturing_Date;
}


public void setManufacturing_Date(Date manufacturing_Date) {
	this.manufacturing_Date = manufacturing_Date;
}


public Date getExpiry_Date() {
	return expiry_Date;
}


public void setExpiry_Date(Date expiry_Date) {
	this.expiry_Date = expiry_Date;
}


public double getMaximum_Retail_Price() {
	return maximum_Retail_Price;
}


public void setMaximum_Retail_Price(double maximum_Retail_Price) {
	this.maximum_Retail_Price = maximum_Retail_Price;
}


public Category getCategory() {
	return category;
}


public void setCategory(Category category) {
	this.category = category;
}


public SubCategory getSubCategory() {
	return subCategory;
}


public void setSubCategory(SubCategory subCategory) {
	this.subCategory = subCategory;
}


public Supplier getSupplier() {
	return supplier;
}


public void setSupplier(Supplier supplier) {
	this.supplier = supplier;
}


public List<Discount> getDiscounts() {
	return discounts;
}


public void setDiscounts(List<Discount> discounts) {
	this.discounts = discounts;
}


public int getQuantity() {
	return quantity;
}


public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public float getRating() {
	return rating;
}

public void setRating(float rating) {
	this.rating = rating;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((category == null) ? 0 : category.hashCode());
	result = prime * result + ((description == null) ? 0 : description.hashCode());
	result = prime * result + ((discounts == null) ? 0 : discounts.hashCode());
	result = prime * result + ((expiry_Date == null) ? 0 : expiry_Date.hashCode());
	result = prime * result + ((manufacturing_Date == null) ? 0 : manufacturing_Date.hashCode());
	long temp;
	temp = Double.doubleToLongBits(maximum_Retail_Price);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + product_Id;
	result = prime * result + ((product_Name == null) ? 0 : product_Name.hashCode());
	result = prime * result + quantity;
	result = prime * result + Float.floatToIntBits(rating);
	result = prime * result + ((subCategory == null) ? 0 : subCategory.hashCode());
	result = prime * result + ((supplier == null) ? 0 : supplier.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Product other = (Product) obj;
	if (category == null) {
		if (other.category != null)
			return false;
	} else if (!category.equals(other.category))
		return false;
	if (description == null) {
		if (other.description != null)
			return false;
	} else if (!description.equals(other.description))
		return false;
	if (discounts == null) {
		if (other.discounts != null)
			return false;
	} else if (!discounts.equals(other.discounts))
		return false;
	if (expiry_Date == null) {
		if (other.expiry_Date != null)
			return false;
	} else if (!expiry_Date.equals(other.expiry_Date))
		return false;
	if (manufacturing_Date == null) {
		if (other.manufacturing_Date != null)
			return false;
	} else if (!manufacturing_Date.equals(other.manufacturing_Date))
		return false;
	if (Double.doubleToLongBits(maximum_Retail_Price) != Double.doubleToLongBits(other.maximum_Retail_Price))
		return false;
	if (product_Id != other.product_Id)
		return false;
	if (product_Name == null) {
		if (other.product_Name != null)
			return false;
	} else if (!product_Name.equals(other.product_Name))
		return false;
	if (quantity != other.quantity)
		return false;
	if (Float.floatToIntBits(rating) != Float.floatToIntBits(other.rating))
		return false;
	if (subCategory == null) {
		if (other.subCategory != null)
			return false;
	} else if (!subCategory.equals(other.subCategory))
		return false;
	if (supplier == null) {
		if (other.supplier != null)
			return false;
	} else if (!supplier.equals(other.supplier))
		return false;
	return true;
}

@Override
public String toString() {
	return "Product [product_Id=" + product_Id + ", product_Name=" + product_Name + ", description=" + description
			+ ", manufacturing_Date=" + manufacturing_Date + ", expiry_Date=" + expiry_Date + ", maximum_Retail_Price="
			+ maximum_Retail_Price + ", category=" + category + ", subCategory=" + subCategory + ", supplier="
			+ supplier + ", discounts=" + discounts + ", quantity=" + quantity + ", rating=" + rating + "]\n";
}



}
