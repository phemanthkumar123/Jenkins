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
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="test_VEHICLE_DTLS")
@EntityListeners(AuditingEntityListener.class)
public class VehicleEntity {

	@Id
	/*@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicle_dbseq_generator")
	@SequenceGenerator(name="vehicle_dbseq_generator", sequenceName = "VHCL_DTLS_ID_SEQ")*/
	@GeneratedValue(generator = "vehicle_dbseq_generator")
	@GenericGenerator(name="vehicle_dbseq_generator",
					  strategy="sequence",
					  parameters={@Parameter(name="sequence_name",value="test_VHCL_DTLS_ID_SEQ")})
	@Column(name="VEHICLE_DTLS_ID")
	private int vehicleDetailsId;
	@Column(name="VEHICLE_TYPE")
	private String vehicleType;
	@Column(name="MFG_YEAR")
	private int mfgYear;
	@Column(name="VEHICLE_BRAND")
	private String vehicleBrand;
	@Column(name="CREATED_DT")
	@CreatedDate
	private java.util.Date createdDate;
	@Column(name="UPDATED_DT")
	@LastModifiedDate
	private java.util.Date updatedDate;
	@ManyToOne
	@JoinColumn(name="VEHICLE_OWNER_ID_FK")
	private OwnerEntity ownerEntityOfVehicle;
	public int getVehicleDetailsId() {
		return vehicleDetailsId;
	}
	public void setVehicleDetailsId(int vehicleDetailsId) {
		this.vehicleDetailsId = vehicleDetailsId;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public int getMfgYear() {
		return mfgYear;
	}
	public void setMfgYear(int mfgYear) {
		this.mfgYear = mfgYear;
	}
	public String getVehicleBrand() {
		return vehicleBrand;
	}
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
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
	public OwnerEntity getOwnerEntityOfVehicle() {
		return ownerEntityOfVehicle;
	}
	public void setOwnerEntityOfVehicle(OwnerEntity ownerEntityOfVehicle) {
		this.ownerEntityOfVehicle = ownerEntityOfVehicle;
	}
}
