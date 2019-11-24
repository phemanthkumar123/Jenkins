package com.rto.binding;

import javax.xml.bind.annotation.XmlType;

@XmlType (propOrder={"vehicleOwnerAddressId","homeNumber","streetName","city","zipCode"})
public class OwnerAddressBinding {

	private int vehicleOwnerAddressId;
	private String homeNumber;
	private String streetName;
	private String city;
	private int zipCode;
	public int getVehicleOwnerAddressId() {
		return vehicleOwnerAddressId;
	}
	public void setVehicleOwnerAddressId(int vehicleOwnerAddressId) {
		this.vehicleOwnerAddressId = vehicleOwnerAddressId;
	}
	public String getHomeNumber() {
		return homeNumber;
	}
	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	
}
