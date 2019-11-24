package com.rto.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rto.command.OwnerAddressCommand;
import com.rto.command.VechicleCommand;
import com.rto.service.VehicleService;

@Controller
public class VehicleController {
	@Autowired
	private VehicleService vehicleService;
	
	private static final Logger logger=Logger.getLogger(VehicleController.class);
	
	@RequestMapping(value="/showRegisterVehiclePage")
	public String showRegisterVehiclePage(Model model,@RequestParam(value="vehicleOwnerId") int ownerId,@RequestParam(value="vehicleId",required=false) Integer vehicleId){
		logger.info("entered into showRegisterVehiclePage() handler with '/showRegisterVehiclePage' url");
		VechicleCommand vehicleCmd=null;
		if(null!=vehicleId){
			vehicleCmd=vehicleService.getVehicleById(vehicleId);
		}else{
			vehicleCmd=new VechicleCommand();
		}
		model.addAttribute("vehicle", vehicleCmd);
		model.addAttribute("vehicleOwnerId", ownerId);
		populateVechicleTypesDropdown(model);
		logger.info("exiting from showRegisterVehiclePage() handler");
		return "register-vehicle";
	}

	@RequestMapping(value="/saveVehicle")
	public String saveVehicleDetails(@ModelAttribute VechicleCommand vehicle,@RequestParam("vehicleOwnerId") int ownerId,RedirectAttributes redirectAttributes){
		logger.info("entered into saveVehicleDetails() handler with '/saveVehicle' url");
		logger.info("and with data: "+vehicle);
		logger.info("and with vehicleid: "+ownerId);
		VechicleCommand savedVehicle=vehicleService.saveVehicle(vehicle, ownerId);
		redirectAttributes.addAttribute("vehicleOwnerId", ownerId);
		redirectAttributes.addAttribute("vehicleId", savedVehicle.getVehicleId());
		logger.info("exiting from saveVehicleDetails() hadler");
		return "redirect:/showOwnerAddressPage";
	}
	
	private void populateVechicleTypesDropdown(Model model){
		logger.info("entered into populateVechicleTypesDropdown() method");
		List<String> vechicleTypes=new ArrayList<String>();
		vechicleTypes.add("2-Wheeler");
		vechicleTypes.add("3-Wheeler");
		vechicleTypes.add("4-Wheeler");
		model.addAttribute("vechicleTypes", vechicleTypes);
		logger.info("exiting from populateVechicleTypesDropdown() method");
	}
	
}
