package com.rto.command;

import org.springframework.format.annotation.DateTimeFormat;

public class OwnerAddressCommand {

	private int ownerAdderssId;
	private String homeNo;
	private String street;
	private String city;
	private int zipCode;
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private java.util.Date createdDate;
	//@LastModifiedDate
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private java.util.Date updatedDate;
	
	public java.util.Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(java.util.Date createdDate) {
		this.createdDate = createdDate;
	}
	public java.util.Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(java.util.Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public int getOwnerAdderssId() {
		return ownerAdderssId;
	}
	public void setOwnerAdderssId(int ownerAdderssId) {
		this.ownerAdderssId = ownerAdderssId;
	}
	public String getHomeNo() {
		return homeNo;
	}
	public void setHomeNo(String homeNo) {
		this.homeNo = homeNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
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
	@Override
	public String toString() {
		return "OwnerAddressCommand [ownerAdderssId=" + ownerAdderssId + ", homeNo=" + homeNo + ", street=" + street
				+ ", city=" + city + ", zipCode=" + zipCode + ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + "]";
	}
	
}
