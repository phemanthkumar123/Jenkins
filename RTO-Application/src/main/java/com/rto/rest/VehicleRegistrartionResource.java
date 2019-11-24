package com.rto.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rto.binding.OwnerAddressBinding;
import com.rto.binding.OwnerBinding;
import com.rto.binding.VehicleBinding;
import com.rto.binding.VehicleRegistrationBinding;
import com.rto.binding.VehicleResultBinding;
import com.rto.entity.OwnerAddressEntity;
import com.rto.entity.OwnerEntity;
import com.rto.entity.VehicleEntity;
import com.rto.entity.VehicleRegistrationDetailsEntity;
import com.rto.service.VehicleRegistrationDtlsService;

@RestController
public class VehicleRegistrartionResource {

	@Autowired
	private VehicleRegistrationDtlsService vehicleService;
	
	private static final Logger logger=Logger.getLogger(VehicleRegistrartionResource.class);
	
	@GetMapping(value="/vehicle/{regNum}",produces={"application/json","application/xml"})
	public VehicleResultBinding getRegisteredVehicleByVehicleRegNum(@PathVariable("regNum")String vehicleRegNum){
		logger.info("entered into getRegisteredVehicleByVehicleRegNum() resource method with input: "+vehicleRegNum);
		VehicleRegistrationDetailsEntity registeredVehicleEntity=vehicleService.getById(vehicleRegNum);
		VehicleResultBinding result= convertFrom(registeredVehicleEntity);
		logger.info("exiting from getRegisteredVehicleByVehicleRegNum() resource method");
		return result;
	}
	
	private VehicleResultBinding convertFrom(VehicleRegistrationDetailsEntity resultEntity){
		
		logger.info("entered into convertFrom(VehicleRegistrationDetailsEntity) method with data: "+resultEntity); 
		
		VehicleResultBinding resultBinding=new VehicleResultBinding();
		
		OwnerEntity ownerEntity=resultEntity.getOwnerEntityOfVehicleReg();
		logger.info("owner entity read from VehicleRegistrationDetailsEntity: "+ownerEntity);
		OwnerBinding ownerBinding=new OwnerBinding();
		BeanUtils.copyProperties(ownerEntity,ownerBinding);;
		resultBinding.setOwnerBinding(ownerBinding);
		
		List<VehicleEntity> vehicleEntityList=ownerEntity.getVehiclesList();
		List<VehicleBinding> vehicleBindingList=new ArrayList();
		logger.info("vehicleEntities read from ownerEntity: ");
		VehicleBinding vehicleBinding=new VehicleBinding();
		for(VehicleEntity vehicleEntity:vehicleEntityList){
			logger.info("vehicleEntity");
			BeanUtils.copyProperties(vehicleEntity, vehicleBinding);
			vehicleBindingList.add(vehicleBinding);
		}
		resultBinding.setVehicleBindingList(vehicleBindingList);
		
		OwnerAddressEntity addressEntity=ownerEntity.getOwnerAddress();
		logger.info("addressEntity read from ownerEntity: "+addressEntity);
		OwnerAddressBinding ownerAddressBinding=new OwnerAddressBinding();
		BeanUtils.copyProperties(addressEntity, ownerAddressBinding);
		resultBinding.setOwnerAddressBinding(ownerAddressBinding);
		
		List<VehicleRegistrationDetailsEntity> vehicleRegEntityList=ownerEntity.getVehicleRegistrationList();
		List<VehicleRegistrationBinding> vehicleRegBindingList=new ArrayList();
		logger.info("vehicleRegEntities read from ownerEntity: ");
		VehicleRegistrationBinding vehicleRegBinding=new VehicleRegistrationBinding();
		for(VehicleRegistrationDetailsEntity vehicleRegEntity:vehicleRegEntityList){
			logger.info("vehicleRegEntity read from ownerEntity: "+vehicleRegEntity);
			BeanUtils.copyProperties(vehicleRegEntity, vehicleRegBinding);
			vehicleRegBindingList.add(vehicleRegBinding);
		}
		resultBinding.setVehicleRegBindingList(vehicleRegBindingList);
		logger.info("exting from convertFrom() method with result data: "+resultBinding);
		return resultBinding;
	}
}
