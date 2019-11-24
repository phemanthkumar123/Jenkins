package com.rto.binding;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlType (propOrder={"id","regDate","regCenter"})
public class VehicleRegistrationBinding {

	//@XmlElement(name="registration-num")
	private String id;
	//@XmlElement(name="registered-date")
	private Date regDate;
	//@XmlElement(name="registered-center")
	private String regCenter;
	//@XmlElement(name="vehicle-owner")
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getRegCenter() {
		return regCenter;
	}
	public void setRegCenter(String regCenter) {
		this.regCenter = regCenter;
	}
	
}
