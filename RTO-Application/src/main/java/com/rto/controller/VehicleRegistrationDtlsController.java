package com.rto.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rto.entity.OwnerEntity;
import com.rto.entity.VehicleRegistrationDetailsEntity;
import com.rto.repository.VehicleOwnerDtlsRepo;
import com.rto.service.OwnerService;
import com.rto.service.VehicleRegistrationDtlsService;
import com.rto.service.VehicleService;

@Controller
public class VehicleRegistrationDtlsController {

	@Autowired
	private VehicleRegistrationDtlsService service;
	@Autowired
	private VehicleOwnerDtlsRepo ownerRepo; //doubt??
	
	private static final Logger logger=Logger.getLogger(VehicleRegistrationDtlsController.class);
	
	@RequestMapping(value="/showVehicleReviewPage")
	public String showVehicleDeatilsReviewPage(Model model,@RequestParam("vehicleOwnerId") int ownerId){
		logger.info("entered into showVehicleDeatilsReviewPage() handler with '/showVehicleReviewPage' url");
		logger.info("and  ownerId is: "+ownerId);
		OwnerEntity ownerEntity=ownerRepo.findById(ownerId).get();
		model.addAttribute("owner",ownerEntity);
		logger.info("exiting from showVehicleDeatilsReviewPage() handler");
		return "vehicle-details-review";
	}
	
	@RequestMapping(value="/confirmRegistration/{vehicleOwnerId}")
	public String doVehicleRegistration(Model model,@PathVariable("vehicleOwnerId")int ownerId){
		logger.info("entered into doVehicleRegistration() handler with '/confirmRegistration' url");
		logger.info("and  ownerId is: "+ownerId);
		VehicleRegistrationDetailsEntity registeredVehicleData=service.saveVehicleRegistrationDetailsEntity(ownerId);
		model.addAttribute("registeredVehicle", registeredVehicleData);
		logger.info("exiting from doVehicleRegistration() handler");
		return "vehicle-success";
	} 
}
