package com.rto.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rto.command.OwnerAddressCommand;
import com.rto.command.OwnerCommand;
import com.rto.entity.OwnerAddressEntity;
import com.rto.entity.OwnerEntity;
import com.rto.repository.VehicleOwnerAddressDtlsRepo;
import com.rto.repository.VehicleOwnerDtlsRepo;
import com.rto.service.OwnerAddressService;
import com.rto.service.OwnerService;

@Controller
public class OwnerAddressController {

	@Autowired
	private OwnerAddressService addressService;
	
	private static final Logger logger=Logger.getLogger(OwnerAddressController.class);
	
	@RequestMapping(value="/showOwnerAddressPage")   
	public String showRegisterOwnerAddressPage(Model model,@RequestParam(value="vehicleOwnerId",required=false) int ownerId,@RequestParam("vehicleId") int vehicleId){
		logger.info("entered into showRegisterOwnerAddressPage() handler with '/showOwnerAddressPage' url");
		model.addAttribute("address", new OwnerAddressCommand());
		model.addAttribute("vehicleOwnerId", ownerId);
		model.addAttribute("vehicleId", vehicleId);
		logger.info("exiting from showRegisterOwnerAddressPage() handler");
		return "register-owner-address";
	}
	
	@RequestMapping("/saveOwnerAddress")
	public String saveOwnerAddressDetails(@ModelAttribute OwnerAddressCommand address,@RequestParam("ownerId") int ownerId,RedirectAttributes redirectAttributes){
		logger.info("entered into saveOwnerAddressDetails() handler with '/saveOwnerAddress' url"); 
		logger.info("and with data: "+address);
		logger.info("and with ownerId: "+ownerId);
		OwnerAddressCommand savedAddress=addressService.saveOwnerAddres(address, ownerId);
		redirectAttributes.addAttribute("vehicleOwnerId", ownerId);
		logger.info("exiting from saveOwnerAddressDetails() handler");
		return "redirect:/showVehicleReviewPage";
	}
}
