package com.rto.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rto.command.OwnerCommand;
import com.rto.entity.OwnerEntity;
import com.rto.repository.VehicleOwnerDtlsRepo;
import com.rto.util.DateConverter;

@Service
public class OwnerService {

	@Autowired
	private VehicleOwnerDtlsRepo ownerRepository;
	
	private static final Logger logger=Logger.getLogger(OwnerService.class);
	
	public OwnerCommand saveOwner(OwnerCommand ownerCmd){
		logger.info("entered into saveOwner() method with data as bellow:");
		logger.info("owner data is: "+ownerCmd);
		OwnerEntity ownerEntity=convertFrom(ownerCmd);
		OwnerEntity ownerEntitySaved= ownerRepository.save(ownerEntity);
		OwnerCommand ownerCommandSaved=convertFrom(ownerEntitySaved);
		logger.info("owner data is successfully saved with: "+ownerCommandSaved.getId());
		logger.info("exiting from saveOwner() method");
		return ownerCommandSaved;
	}
	
	public OwnerCommand getOwnerById(int vehicleOwnerId){
		logger.info("entered into getOwnerById() method with id as: "+vehicleOwnerId);
		OwnerCommand ownerCommand= convertFrom(ownerRepository.findById(vehicleOwnerId).get());
		logger.info("owner data is successfully retrived : "+ownerCommand);
		logger.info("exiting from getOwnerById() method");
		return ownerCommand;
	}
	
	public static OwnerEntity convertFrom(OwnerCommand cmd){
		logger.info("entered into convertFrom(OwnerCommand) method");
		OwnerEntity ownerEntity=new OwnerEntity();
		ownerEntity.setVehicleOwnerId(cmd.getId());
		ownerEntity.setFirstName(cmd.getFirstName());
		ownerEntity.setLastName(cmd.getLastName());
		ownerEntity.setGender(cmd.getGender());
		ownerEntity.setEmail(cmd.getEmail());
		java.sql.Date dob=DateConverter.convertUtilToSql(cmd.getDob());
		ownerEntity.setDob(dob);
		ownerEntity.setSsn(cmd.getSsn());
		ownerEntity.setPhoneNumber(cmd.getPhoneNumber());
		ownerEntity.setCreatedDate(cmd.getCreatedDate());
		ownerEntity.setUpdatedDate(cmd.getUpdatedDate());
		logger.info("exiting from convertFrom(OwnerCommand) method");
		return ownerEntity;
	}
	
	public static OwnerCommand convertFrom(OwnerEntity entity){
		logger.info("entered into convertFrom(OwnerEntity) method");
		OwnerCommand cmd=new OwnerCommand();
		cmd.setId(entity.getVehicleOwnerId());
		cmd.setFirstName(entity.getFirstName());
		cmd.setLastName(entity.getLastName());
		cmd.setGender(entity.getGender());
		cmd.setEmail(entity.getEmail());
		cmd.setPhoneNumber(entity.getPhoneNumber());
		cmd.setDob(entity.getDob());
		String ssn=entity.getSsn();
		String[] ssns=ssn.split(" ");
		cmd.setSsn_1(Integer.parseInt(ssns[0]));
		cmd.setSsn_2(Integer.parseInt(ssns[1]));
		cmd.setSsn_3(Integer.parseInt(ssns[2]));
		cmd.setCreatedDate(entity.getCreatedDate());
		cmd.setUpdatedDate(cmd.getUpdatedDate());
		logger.info("exiting from convertFrom(OwnerEntity) method");
		return cmd;
	}
}
