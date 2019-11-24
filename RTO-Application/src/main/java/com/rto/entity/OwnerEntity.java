package com.rto.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
/*import javax.persistence.GenerationType;*/
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="test_VEHICLE_OWNER_DTLS")
@EntityListeners(AuditingEntityListener.class)
public class OwnerEntity {

	@Id
	/*@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owner_dbseq_generator")
	@SequenceGenerator(name="owner_dbseq_generator", sequenceName = "VHCL_OWNER_ID_SEQ")*/
	@GeneratedValue(generator = "owner_dbseq_generator")
	@GenericGenerator(name="owner_dbseq_generator",
					  strategy="sequence",
					  parameters={@Parameter(name="sequence_name",value="test_VHCL_OWNER_ID_SEQ")})
	@Column(name="VEHICLE_OWNER_ID")
	private int vehicleOwnerId;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="GENDER")
	private String gender;
	@Column(name="EMAIL")
	private String email;
	@Column(name="DOB")
	private Date dob;
	@Column(name="PHNO")
	private long phoneNumber;
	@Column(name="CREATED_DT")
	@CreatedDate
	private java.util.Date createdDate;
	@Column(name="UPDATED_DT")
	@LastModifiedDate
	private java.util.Date updatedDate;
	@Column(name="SSN")
	private String ssn;
	@OneToMany(mappedBy="ownerEntityOfVehicle")
	private List<VehicleEntity> vehiclesList=new ArrayList();
	@OneToOne(mappedBy="ownerEntityOfAddress",fetch = FetchType.EAGER)
	private OwnerAddressEntity ownerAddress;
	@OneToMany(mappedBy="ownerEntityOfVehicleReg")
	private List<VehicleRegistrationDetailsEntity> vehicleRegistrationList=new ArrayList();
	public int getVehicleOwnerId() {
		return vehicleOwnerId;
	}
	public void setVehicleOwnerId(int vehicleOwnerId) {
		this.vehicleOwnerId = vehicleOwnerId;
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
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public List<VehicleEntity> getVehiclesList() {
		return vehiclesList;
	}
	public void setVehiclesList(List<VehicleEntity> vehiclesList) {
		this.vehiclesList = vehiclesList;
	}
	public OwnerAddressEntity getOwnerAddress() {
		return ownerAddress;
	}
	public void setOwnerAddress(OwnerAddressEntity ownerAddress) {
		this.ownerAddress = ownerAddress;
	}
	public List<VehicleRegistrationDetailsEntity> getVehicleRegistrationList() {
		return vehicleRegistrationList;
	}
	public void setVehicleRegistrationList(List<VehicleRegistrationDetailsEntity> vehicleRegistrationList) {
		this.vehicleRegistrationList = vehicleRegistrationList;
	}
	@Override
	public String toString() {
		return "OwnerEntity [vehicleOwnerId=" + vehicleOwnerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", email=" + email + ", dob=" + dob + ", phoneNumber=" + phoneNumber
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", ssn=" + ssn + ", vehiclesList="
				+ vehiclesList + ", ownerAddress=" + ownerAddress + ", vehicleRegistrationList="
				+ vehicleRegistrationList + "]";
	}
	
	
	
}
