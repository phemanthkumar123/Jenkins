package com.rto.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.rto.util.Identifiable;


@Entity
//@Table(name="VEHICLE_REGISTRATION_DTLS")
@Table(name="test_VEHICLE_REGISTRATION_DTLS")
@EntityListeners(AuditingEntityListener.class)
public class VehicleRegistrationDetailsEntity implements Identifiable<String>{

	@Id
	@Column(name="VEHICLE_REG_NUMBER")
	@GenericGenerator(
	        name = "vehicle_reg_num_custom_generator",
	        strategy = "com.rto.util.VehicleRegistrationCustomIdGenerator",
	        parameters = {
	            @org.hibernate.annotations.Parameter(
	                name = "sequence_name", value = "test_VHCL_REG_NUM_SEQ")
	        }
	    )
	@GeneratedValue(
	        generator = "vehicle_reg_num_custom_generator",
	        strategy = GenerationType.SEQUENCE)
	private String id;
	//private String vehicleRegNumber;
	@Column(name="REG_DT")
	@CreatedDate
	private java.util.Date regDate;
	@Column(name="REG_CENTER")
	private String regCenter;
	@Column(name="CREATED_DT")
	@CreatedDate
	private java.util.Date createdDate;
	@Column(name="UPDATED_DT")
	@LastModifiedDate
	private java.util.Date updatedDate;
	@ManyToOne
	@JoinColumn(name="VEHICLE_OWNER_ID_FK")
	private OwnerEntity ownerEntityOfVehicleReg;
	
	public java.util.Date getRegDate() {
		return regDate;
	}
	public void setRegDate(java.util.Date regDate) {
		this.regDate = regDate;
	}
	public String getRegCenter() {
		return regCenter;
	}
	public void setRegCenter(String regCenter) {
		this.regCenter = regCenter;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public OwnerEntity getOwnerEntityOfVehicleReg() {
		return ownerEntityOfVehicleReg;
	}
	public void setOwnerEntityOfVehicleReg(OwnerEntity ownerEntityOfVehicleReg) {
		this.ownerEntityOfVehicleReg = ownerEntityOfVehicleReg;
	}
	
}
