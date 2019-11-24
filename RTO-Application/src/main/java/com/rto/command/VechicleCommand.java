package com.rto.command;

import org.springframework.format.annotation.DateTimeFormat;

public class VechicleCommand {

	private int vehicleId;
	private String vehicleType;
	private int mfgYear;
	private String vehicleBrand;
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
	public VechicleCommand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VechicleCommand(int vehicleId, String vehicleType, int mfgYear, String vehicleBrand) {
		super();
		this.vehicleId = vehicleId;
		this.vehicleType = vehicleType;
		this.mfgYear = mfgYear;
		this.vehicleBrand = vehicleBrand;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
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
	@Override
	public String toString() {
		return "VechicleCommand [vehicleId=" + vehicleId + ", vehicleType=" + vehicleType + ", mfgYear=" + mfgYear
				+ ", vehicleBrand=" + vehicleBrand + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + vehicleId;
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
		VechicleCommand other = (VechicleCommand) obj;
		if (vehicleId != other.vehicleId)
			return false;
		return true;
	}
}
