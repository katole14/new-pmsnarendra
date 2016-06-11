package com.flp.pms.util;

import java.util.Date;

public class Validate {
public static boolean isvalidateName(String product_name){
	return product_name.matches("[A-Z][a-z1-9_$]*");
}

public static boolean isValidDate(String givenDate){
	return givenDate.matches("([1-9]|[1-2]\\d{1})-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)-[12][7890]\\d{2}");
}

public static boolean isvalidExpirDate(Date expirydate){

	
	//if(today.getDate()<expdate.getDate()&& today.getMonth()<expdate.getMonth() && today.getYear()<expdate.getYear())
		return expirydate.after(new Date());
	
	}

public static boolean isValidRating(float rating){
	if (rating>0.0 && rating<=5.0)
		return true;
	else return false;
}

public static boolean isValidcontactNo(String contactNo){
	return contactNo.matches("\\d{10}");
}


public static boolean isValidquantity(int quantity){
	if(quantity>0)
		return true;
	else
		return false;
}

}
