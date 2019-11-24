package com.rto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="testVEHICLE_OWNER_ADDRESS_DTLS")
@EntityListeners(AuditingEntityListener.class)
public class OwnerAddressEntity {

	@Id
	/*@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owneraddress_dbseq_generator")
	@SequenceGenerator(name="owneraddress_dbseq_generator", sequenceName = "VHCL_ADRS_ID_SEQ")*/
	@GeneratedValue(generator = "owneraddress_dbseq_generator")
	@GenericGenerator(name="owneraddress_dbseq_generator",
					  strategy="sequence",
					  parameters={@Parameter(name="sequence_name",value="test_VHCL_ADRS_ID_SEQ")})
	@Column(name="VEHICLE_OWNER_ADDRESS_ID")
	private int vehicleOwnerAddressId;
	@Column(name="HNO")
	private String homeNumber;
	@Column(name="STREET_NAME")
	private String streetName;
	@Column(name="CITY")
	private String city;
	@Column(name="ZIP_CODE")
	private int zipCode;
	@Column(name="CREATED_DT")
	@CreatedDate
	private java.util.Date cretaedDate;
	@Column(name="UPDATED_DT")
	@LastModifiedDate
	private java.util.Date updatedDate;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="VEHICLE_OWNER_ID_FK")
	private OwnerEntity ownerEntityOfAddress;
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
	public java.util.Date getCretaedDate() {
		return cretaedDate;
	}
	public void setCretaedDate(java.util.Date cretaedDate) {
		this.cretaedDate = cretaedDate;
	}
	public java.util.Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(java.util.Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public OwnerEntity getOwnerEntityOfAddress() {
		return ownerEntityOfAddress;
	}
	public void setOwnerEntityOfAddress(OwnerEntity ownerEntityOfAddress) {
		this.ownerEntityOfAddress = ownerEntityOfAddress;
	}
}
