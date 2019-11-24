package com.rto.service;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rto.controller.VehicleRegistrationDtlsController;
import com.rto.entity.OwnerEntity;
import com.rto.entity.VehicleRegistrationDetailsEntity;
import com.rto.repository.VehicleOwnerDtlsRepo;
import com.rto.repository.VehicleRegistrationDtlsRepo;

@Service
public class VehicleRegistrationDtlsService {
	
	@Autowired
	public VehicleRegistrationDtlsRepo regRepository;
	@Autowired
	public VehicleOwnerDtlsRepo ownerRepo;
	
	private static final Logger logger=Logger.getLogger(VehicleRegistrationDtlsService.class);
	
	public VehicleRegistrationDetailsEntity saveVehicleRegistrationDetailsEntity(int ownerId){
		logger.info("entered into saveVehicleRegistrationDetailsEntity() method with data as bellow:");
		logger.info("with owner as:"+ownerId);
		VehicleRegistrationDetailsEntity vehicleRegData=new VehicleRegistrationDetailsEntity();
		vehicleRegData.setRegCenter("Hyd_Center");
		OwnerEntity ownerEntity=ownerRepo.findById(ownerId).get();
		ownerEntity.getVehicleRegistrationList().add(vehicleRegData);
		vehicleRegData.setOwnerEntityOfVehicleReg(ownerEntity);
		VehicleRegistrationDetailsEntity entity= regRepository.save(vehicleRegData);
		logger.info("vehicleregistration data is successfully saved with: "+entity.getId());
		logger.info("exiting from saveVehicleRegistrationDetailsEntity method");
		return entity;
	}
	
	public VehicleRegistrationDetailsEntity getById(String vehicleRegNum){
		logger.info("entered into getById() method with id as: "+vehicleRegNum);
		VehicleRegistrationDetailsEntity entity= regRepository.findById(vehicleRegNum).get();
		logger.info("vehicleregistration data is successfully retrived : "+entity);
		logger.info("exiting from getById() method");
		return entity;
	}
}
