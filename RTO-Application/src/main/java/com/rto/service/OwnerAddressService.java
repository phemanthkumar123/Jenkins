package com.rto.service;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rto.command.OwnerAddressCommand;
import com.rto.command.OwnerCommand;
import com.rto.command.VechicleCommand;
import com.rto.entity.OwnerAddressEntity;
import com.rto.entity.OwnerEntity;
import com.rto.entity.VehicleEntity;
import com.rto.repository.VehicleOwnerAddressDtlsRepo;
import com.rto.repository.VehicleOwnerDtlsRepo;


@Service
public class OwnerAddressService {

	@Autowired
	private VehicleOwnerAddressDtlsRepo addressRepo;
	@Autowired
	private VehicleOwnerDtlsRepo ownerRepo;
	
	private static final Logger logger=Logger.getLogger(OwnerAddressService.class);
	
	public OwnerAddressCommand saveOwnerAddres(OwnerAddressCommand command,int vehicleOwnerId){
		logger.info("entered into saveOwnerAddres() method with data as bellow:");
		logger.info("owner data is: "+command);
		logger.info("and with vehicleid as:"+vehicleOwnerId);
		OwnerAddressEntity addressEntity=converfrom(command);
		OwnerEntity owner=ownerRepo.findById(vehicleOwnerId).get();
		owner.setOwnerAddress(addressEntity);
		addressEntity.setOwnerEntityOfAddress(owner);
		OwnerAddressEntity savedaddress=addressRepo.save(addressEntity);
		OwnerAddressCommand savedAddressCmd=convertFrom(savedaddress);
		logger.info("owneraddress data is successfully saved with: "+savedAddressCmd.getOwnerAdderssId());
		logger.info("exiting from saveOwnerAddress() method");
		return savedAddressCmd;
	}
	
	public OwnerAddressCommand getAddressById(int ownerAddressId){
		logger.info("entered into getAddressById() method with id as: "+ownerAddressId);
		Optional<OwnerAddressEntity> addressEntityOptinal=addressRepo.findById(ownerAddressId);
		OwnerAddressEntity addressEntity=addressEntityOptinal.get();
		logger.info("owneraddress data is successfully retrived : "+addressEntity);
		logger.info("exiting from getAddressById() method");
		return convertFrom(addressEntity);
	}
	
	private OwnerAddressEntity converfrom(OwnerAddressCommand cmd){
		logger.info("entered into convertFrom(OwnerAddressCommand) method");
		OwnerAddressEntity entity=new OwnerAddressEntity();
		entity.setHomeNumber(cmd.getHomeNo());
		entity.setStreetName(cmd.getStreet());
		entity.setCity(cmd.getCity());
		entity.setZipCode(cmd.getZipCode());
		logger.info("exiting from convertFrom(OwnerAddressCommand) method");
		return entity;
	}
	
	private OwnerAddressCommand convertFrom(OwnerAddressEntity addressEntity){
		logger.info("entered into convertFrom(OwnerAddressEntity) method");
		OwnerAddressCommand cmd=new OwnerAddressCommand();
		cmd.setOwnerAdderssId(addressEntity.getVehicleOwnerAddressId());
		cmd.setHomeNo(addressEntity.getHomeNumber());
		cmd.setStreet(addressEntity.getStreetName());
		cmd.setCity(addressEntity.getCity());
		cmd.setZipCode(addressEntity.getZipCode());
		logger.info("exiting from convertFrom(OwnerAddressEntity) method");
		return cmd;
	}
}
