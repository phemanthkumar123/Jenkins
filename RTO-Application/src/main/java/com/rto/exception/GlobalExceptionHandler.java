package com.rto.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NullPointerException.class)
	public String handleNullPointerException(NullPointerException npe,Model model){
		model.addAttribute("errorMsg","Something went wrong please try again or report to admin team from global handler");
		model.addAttribute("exceptionType", "NPE");
		model.addAttribute("exceptionCause", npe.getCause());
		model.addAttribute("exceptopnDescription", npe.getMessage());
		return "generic-error";
	}
	
	@ExceptionHandler(CustomGenericException.class)
	public String handleAllExceptions(CustomGenericException cge,Model model){
		model.addAttribute("errorMsg","Something went wrong please try again or report to admin team");
		model.addAttribute("exceptionType", "CGE");
		model.addAttribute("exceptionCause", cge.getCause());
		model.addAttribute("exceptopnDescription", cge.getMessage());
		return "generic-error";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleAllExceptions(Exception ex,Model model){
		model.addAttribute("errorMsg","Something went wrong please try again or report to admin team");
		model.addAttribute("exceptionType", "Exception");
		model.addAttribute("exceptionCause", ex.getCause());
		model.addAttribute("exceptopnDescription", ex.getMessage());
		return "generic-error";
	}

}
