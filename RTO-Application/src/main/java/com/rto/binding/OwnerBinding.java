package com.rto.binding;

import java.util.Date;

import javax.xml.bind.annotation.XmlType;

@XmlType (propOrder={"vehicleOwnerId","ssn","firstName","lastName","gender","email","dob","phoneNumber"})
public class OwnerBinding {

	private int vehicleOwnerId;
	private String ssn;
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	private Date dob;
	private long phoneNumber;
	
	public int getVehicleOwnerId() {
		return vehicleOwnerId;
	}
	public void setVehicleOwnerId(int vehicleOwnerId) {
		this.vehicleOwnerId = vehicleOwnerId;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
