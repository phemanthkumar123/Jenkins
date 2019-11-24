package com.rto.command;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
//@EntityListeners(AuditingEntityListener.class)
public class OwnerCommand {

	private int id;
	private Integer ssn_1;
	private Integer ssn_2;
	private Integer ssn_3;
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	private String ssn;
	//@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date dob;
	private long phoneNumber;
	//@CreatedDate
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

	public OwnerCommand() {
		super();
	}
	
	public OwnerCommand(int id, Integer ssn_1, Integer ssn_2, Integer ssn_3, String firstName, String lastName, String gender,
			String email, Date dob, long phoneNumber) {
		super();
		this.id = id;
		this.ssn_1 = ssn_1;
		this.ssn_2 = ssn_2;
		this.ssn_3 = ssn_3;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.dob = dob;
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getSsn_1() {
		return ssn_1;
	}

	public void setSsn_1(Integer ssn_1) {
		this.ssn_1 = ssn_1;
	}

	public Integer getSsn_2() {
		return ssn_2;
	}

	public void setSsn_2(Integer ssn_2) {
		this.ssn_2 = ssn_2;
	}

	public Integer getSsn_3() {
		return ssn_3;
	}

	public void setSsn_3(Integer ssn_3) {
		this.ssn_3 = ssn_3;
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

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		if(ssn==null){
			this.ssn = getSsn_1()+" "+getSsn_2()+" "+getSsn_3();
		}
		else{
			this.ssn=ssn;
		}
	}

	@Override
	public String toString() {
		return "OwnerCommand [id=" + id + ", ssn_1=" + ssn_1 + ", ssn_2=" + ssn_2 + ", ssn_3=" + ssn_3 + ", firstName="
				+ firstName + ", lastName=" + lastName + ", gender=" + gender + ", email=" + email + ", ssn=" + ssn
				+ ", dob=" + dob + ", phoneNumber=" + phoneNumber + ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + (int) (phoneNumber ^ (phoneNumber >>> 32));
		result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
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
		OwnerCommand other = (OwnerCommand) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (phoneNumber != other.phoneNumber)
			return false;
		if (ssn == null) {
			if (other.ssn != null)
				return false;
		} else if (!ssn.equals(other.ssn))
			return false;
		return true;
	}
}
