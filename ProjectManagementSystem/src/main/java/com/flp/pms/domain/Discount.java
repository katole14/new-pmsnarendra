package com.flp.pms.domain;

import java.util.Date;

public class Discount {
private int discount_Id;
private String discount_Name;
private String discription;
private double discount_percentage;
private Date valid_through;

public Discount(){
	
}

public Discount(int discount_Id, String discount_Name, String discription, double discount_percentage,
		Date valid_through) {
	super();
	this.discount_Id = discount_Id;
	this.discount_Name = discount_Name;
	this.discription = discription;
	this.discount_percentage = discount_percentage;
	this.valid_through = valid_through;
}

public int getDiscount_Id() {
	return discount_Id;
}

public void setDiscount_Id(int discount_Id) {
	this.discount_Id = discount_Id;
}

public String getDiscount_Name() {
	return discount_Name;
}

public void setDiscount_Name(String discount_Name) {
	this.discount_Name = discount_Name;
}

public String getDiscription() {
	return discription;
}

public void setDiscription(String discription) {
	this.discription = discription;
}

public double getDiscount_percentage() {
	return discount_percentage;
}

public void setDiscount_percentage(double discount_percentage) {
	this.discount_percentage = discount_percentage;
}

public Date getValid_through() {
	return valid_through;
}

public void setValid_through(Date valid_through) {
	this.valid_through = valid_through;
}

@Override
public String toString() {
	return "Discount [discount_Id=" + discount_Id + ", discount_Name=" + discount_Name + ", discription=" + discription
			+ ", discount_percentage=" + discount_percentage + ", valid_through=" + valid_through + "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + discount_Id;
	result = prime * result + ((discount_Name == null) ? 0 : discount_Name.hashCode());
	long temp;
	temp = Double.doubleToLongBits(discount_percentage);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((discription == null) ? 0 : discription.hashCode());
	result = prime * result + ((valid_through == null) ? 0 : valid_through.hashCode());
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
	Discount other = (Discount) obj;
	if (discount_Id != other.discount_Id)
		return false;
	if (discount_Name == null) {
		if (other.discount_Name != null)
			return false;
	} else if (!discount_Name.equals(other.discount_Name))
		return false;
	if (Double.doubleToLongBits(discount_percentage) != Double.doubleToLongBits(other.discount_percentage))
		return false;
	if (discription == null) {
		if (other.discription != null)
			return false;
	} else if (!discription.equals(other.discription))
		return false;
	if (valid_through == null) {
		if (other.valid_through != null)
			return false;
	} else if (!valid_through.equals(other.valid_through))
		return false;
	return true;
}






}
