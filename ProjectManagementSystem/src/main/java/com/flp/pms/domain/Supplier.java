package com.flp.pms.domain;

public class Supplier {
private int supplier_Id;
private String first_Name;
private String last_Name;
private String address;
private String city;
private String state;
private String pincode;
private String contact_Number;

public Supplier(){
	
}

public Supplier(int supplier_Id, String first_Name, String last_Name, String address, String city, String state,
		String pincode, String contact_Number) {
	super();
	this.supplier_Id = supplier_Id;
	this.first_Name = first_Name;
	this.last_Name = last_Name;
	this.address = address;
	this.city = city;
	this.state = state;
	this.pincode = pincode;
	this.contact_Number = contact_Number;
}

public int getSupplier_Id() {
	return supplier_Id;
}

public void setSupplier_Id(int supplier_Id) {
	this.supplier_Id = supplier_Id;
}

public String getFirst_Name() {
	return first_Name;
}

public void setFirst_Name(String first_Name) {
	this.first_Name = first_Name;
}

public String getLast_Name() {
	return last_Name;
}

public void setLast_Name(String last_Name) {
	this.last_Name = last_Name;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getPincode() {
	return pincode;
}

public void setPincode(String pincode) {
	this.pincode = pincode;
}

public String getContact_Number() {
	return contact_Number;
}

public void setContact_Number(String contact_Number) {
	this.contact_Number = contact_Number;
}

@Override
public String toString() {
	return "Supplier [supplier_Id=" + supplier_Id + ", first_Name=" + first_Name + ", last_Name=" + last_Name
			+ ", address=" + address + ", city=" + city + ", state=" + state + ", pincode=" + pincode
			+ ", contact_Number=" + contact_Number + "]";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((address == null) ? 0 : address.hashCode());
	result = prime * result + ((city == null) ? 0 : city.hashCode());
	result = prime * result + ((contact_Number == null) ? 0 : contact_Number.hashCode());
	result = prime * result + ((first_Name == null) ? 0 : first_Name.hashCode());
	result = prime * result + ((last_Name == null) ? 0 : last_Name.hashCode());
	result = prime * result + ((pincode == null) ? 0 : pincode.hashCode());
	result = prime * result + ((state == null) ? 0 : state.hashCode());
	result = prime * result + supplier_Id;
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
	Supplier other = (Supplier) obj;
	if (address == null) {
		if (other.address != null)
			return false;
	} else if (!address.equals(other.address))
		return false;
	if (city == null) {
		if (other.city != null)
			return false;
	} else if (!city.equals(other.city))
		return false;
	if (contact_Number == null) {
		if (other.contact_Number != null)
			return false;
	} else if (!contact_Number.equals(other.contact_Number))
		return false;
	if (first_Name == null) {
		if (other.first_Name != null)
			return false;
	} else if (!first_Name.equals(other.first_Name))
		return false;
	if (last_Name == null) {
		if (other.last_Name != null)
			return false;
	} else if (!last_Name.equals(other.last_Name))
		return false;
	if (pincode == null) {
		if (other.pincode != null)
			return false;
	} else if (!pincode.equals(other.pincode))
		return false;
	if (state == null) {
		if (other.state != null)
			return false;
	} else if (!state.equals(other.state))
		return false;
	if (supplier_Id != other.supplier_Id)
		return false;
	return true;
}



}
