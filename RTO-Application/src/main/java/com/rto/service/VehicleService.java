package com.rto.service;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rto.command.VechicleCommand;
import com.rto.entity.OwnerEntity;
import com.rto.entity.VehicleEntity;
import com.rto.repository.VehicleDtlsRepo;
import com.rto.repository.VehicleOwnerDtlsRepo;

@Service
public class VehicleService {

	@Autowired
	private VehicleDtlsRepo vehicleRepo;
	@Autowired
	private VehicleOwnerDtlsRepo ownerRepo;
	
	private static final Logger logger=Logger.getLogger(VehicleService.class);
	
	public VechicleCommand saveVehicle(VechicleCommand command,int vehicleOwnerId){
		logger.info("entered into saveVehicle() method with data as bellow:");
		logger.info("vehicle data is : "+command);
		logger.info("and with vehicleid as:"+vehicleOwnerId);
		VehicleEntity entity=convertFrom(command);
		OwnerEntity owner=ownerRepo.findById(vehicleOwnerId).get(); //getting owner
		owner.getVehiclesList().add(entity); //getting vehiclelist of owner and adding vehicle
		entity.setOwnerEntityOfVehicle(owner); //again setting owner to vehicle
		VehicleEntity savedEntity=vehicleRepo.save(entity); //atlast saving vehicle along with owner
		VechicleCommand savedCommand=convertFrom(savedEntity);
		logger.info("vehicle data is successfully saved with: "+savedCommand.getVehicleId());
		logger.info("exiting from saveVehicle() method");
		return savedCommand;
	}
	
	public VechicleCommand getVehicleById(int vehicleId){
		logger.info("entered into getVehicleById() method with id as: "+vehicleId);
		Optional<VehicleEntity> vehicleEntityOptinal=vehicleRepo.findById(vehicleId);
		VehicleEntity vehicleEntity=vehicleEntityOptinal.get();
		logger.info("vehicle data is successfully retrived : "+vehicleEntity);
		logger.info("exiting from getVehicleById() method");
		return convertFrom(vehicleEntity);
	}
	
	private VehicleEntity convertFrom(VechicleCommand cmd){
		logger.info("entered into convertFrom(VechicleCommand) method");
		VehicleEntity entity=new VehicleEntity();
		entity.setVehicleDetailsId(cmd.getVehicleId());
		entity.setVehicleType(cmd.getVehicleType());
		entity.setMfgYear(cmd.getMfgYear());
		entity.setVehicleBrand(cmd.getVehicleBrand());
		entity.setCreatedDate(cmd.getCreatedDate());
		entity.setUpdatedDate(cmd.getUpdatedDate());
		logger.info("exiting from convertFrom(VechicleCommand) method");
		return entity;
	}
	
	private VechicleCommand convertFrom(VehicleEntity entity){
		logger.info("entered into convertFrom(VehicleEntity) method");
		VechicleCommand cmd=new VechicleCommand();
		cmd.setVehicleId(entity.getVehicleDetailsId());
		cmd.setVehicleType(entity.getVehicleType());
		cmd.setMfgYear(entity.getMfgYear());
		cmd.setVehicleBrand(entity.getVehicleBrand());
		cmd.setCreatedDate(entity.getCreatedDate());
		cmd.setUpdatedDate(entity.getUpdatedDate());
		logger.info("exiting from convertFrom(VehicleEntity) method");
		return cmd;
	}
}
