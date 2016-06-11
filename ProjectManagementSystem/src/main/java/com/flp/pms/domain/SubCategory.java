package com.flp.pms.domain;

public class SubCategory {
private int subCategory_Id;
private String subCategory_Name;
private Category category;

public SubCategory(){
	
}

public SubCategory(int subCategory_Id, String subCategory_Name, Category category) {
	super();
	this.subCategory_Id = subCategory_Id;
	this.subCategory_Name = subCategory_Name;
	this.category = category;
}

public int getSubCategory_Id() {
	return subCategory_Id;
}

public void setSubCategory_Id(int subCategory_Id) {
	this.subCategory_Id = subCategory_Id;
}

public String getSubCategory_Name() {
	return subCategory_Name;
}

public void setSubCategory_Name(String subCategory_Name) {
	this.subCategory_Name = subCategory_Name;
}

public Category getCategory() {
	return category;
}

public void setCategory(Category category) {
	this.category = category;
}

@Override
public String toString() {
	return "SubCategory [subCategory_Id=" + subCategory_Id + ", subCategory_Name=" + subCategory_Name + ", category="
			+ category + "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((category == null) ? 0 : category.hashCode());
	result = prime * result + subCategory_Id;
	result = prime * result + ((subCategory_Name == null) ? 0 : subCategory_Name.hashCode());
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
	SubCategory other = (SubCategory) obj;
	if (category == null) {
		if (other.category != null)
			return false;
	} else if (!category.equals(other.category))
		return false;
	if (subCategory_Id != other.subCategory_Id)
		return false;
	if (subCategory_Name == null) {
		if (other.subCategory_Name != null)
			return false;
	} else if (!subCategory_Name.equals(other.subCategory_Name))
		return false;
	return true;
}



}
