package com.rto.binding;

import javax.xml.bind.annotation.XmlType;

@XmlType (propOrder={"vehicleDetailsId","vehicleType","mfgYear","vehicleBrand"})
public class VehicleBinding {

	private int vehicleDetailsId;
	private String vehicleType;
	private int mfgYear;
	private String vehicleBrand;
	
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
	
	
}
