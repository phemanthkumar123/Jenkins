package com.rto.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rto.command.OwnerCommand;
import com.rto.service.OwnerService;

@Controller
public class OwnerController {

	@Autowired
	private OwnerService ownerService;
	
	private static final Logger logger=Logger.getLogger(OwnerController.class);
	
	@RequestMapping("/home")
	public String showHomePage(){
		logger.info("entered into showHomePage() handler with '/home' url");
		String homeView= "home";
		logger.info("exiting from showHomePage() handler");
		return homeView;
	}
	
	@RequestMapping("/showRegisterOwnerPage")
	public String showRegisterOwnerPage(Model model,@RequestParam(value="vehicleOwnerId",required=false) Integer vehicleOwnerId){
		logger.info("entered into showRegisterOwnerPage() handler with '/showRegisterOwnerPage' url");
		OwnerCommand ownerCmnd=null;
		if(null!=vehicleOwnerId){
			ownerCmnd=ownerService.getOwnerById(vehicleOwnerId);
		}else{
			ownerCmnd=new OwnerCommand();
		}
		model.addAttribute("owner",ownerCmnd);
		logger.info("existing from showRegisterOwnerPage() handler");
		return "register-owner";
	}
	
	@RequestMapping(value="/saveOwner",method=RequestMethod.POST)
	public String saveVehicleOwnerDetails(@ModelAttribute("owner")OwnerCommand owner, RedirectAttributes redirectAttributes){
		logger.info("entered into saveVehicleOwnerDetails() handler with '/saveOwner' url");
		logger.info("and with data: "+owner);
		owner.setSsn(null);
		OwnerCommand ownerSaved=ownerService.saveOwner(owner);
		redirectAttributes.addAttribute("vehicleOwnerId", ownerSaved.getId());
		logger.info("exiting from saveVehicleOwnerDetails() handler");
		return "redirect:/showRegisterVehiclePage";
	}
}
