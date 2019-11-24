package com.rto.binding;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="registered-vehicle-details")
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType (propOrder={"owner","vehicles","address","vehicle-registrations"})
public class VehicleResultBinding {

	@XmlElement(name="owner")
	private OwnerBinding ownerBinding;
	@XmlElementWrapper(name="vehicles")
	@XmlElement(name="vehicle")
	private List<VehicleBinding> vehicleBindingList;
	@XmlElement(name="address")
	private OwnerAddressBinding ownerAddressBinding;
	@XmlElementWrapper(name="vehicle-registrations")
	@XmlElement(name="vehicle-registration")
	private List<VehicleRegistrationBinding> vehicleRegBindingList;
	public OwnerBinding getOwnerBinding() {
		return ownerBinding;
	}
	public void setOwnerBinding(OwnerBinding ownerBinding) {
		this.ownerBinding = ownerBinding;
	}
	public List<VehicleBinding> getVehicleBindingList() {
		return vehicleBindingList;
	}
	public void setVehicleBindingList(List<VehicleBinding> vehicleBindingList) {
		this.vehicleBindingList = vehicleBindingList;
	}
	public OwnerAddressBinding getOwnerAddressBinding() {
		return ownerAddressBinding;
	}
	public void setOwnerAddressBinding(OwnerAddressBinding ownerAddressBinding) {
		this.ownerAddressBinding = ownerAddressBinding;
	}
	public List<VehicleRegistrationBinding> getVehicleRegBindingList() {
		return vehicleRegBindingList;
	}
	public void setVehicleRegBindingList(List<VehicleRegistrationBinding> vehicleRegBindingList) {
		this.vehicleRegBindingList = vehicleRegBindingList;
	}
	
}


