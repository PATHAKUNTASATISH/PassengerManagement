package com.ovrtravels.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ovrtravels.domain.Gender;
import com.ovrtravels.service.impl.PassengerServiceImpl;

@Controller
public class PassengerController {
	@Autowired
	PassengerServiceImpl impl;
	
	@InitBinder
	public  void  initBinder(WebDataBinder  webDataBinder)
	{
		SimpleDateFormat  sdf=new SimpleDateFormat("yyyy.MM.dd");
		CustomDateEditor dateEditor=new CustomDateEditor(sdf, true);
		webDataBinder.registerCustomEditor(Date.class, dateEditor);
	}
	
	
	
	@GetMapping("/bookTicket")
	public String ticketBooking() {
		
		return "bookingPage";
		
	}
	@PostMapping("/process")
public String processing(@RequestParam Integer ticketNo,@RequestParam String firstName,@RequestParam String lastName,@RequestParam Integer age,@RequestParam String email,@RequestParam Integer seatNo,@RequestParam Gender gender,@RequestParam Long mobile,@RequestParam Date dateOfJourney,
		@RequestParam String source, @RequestParam String destination) {
	boolean flag = impl.ticketBooking(ticketNo, firstName, lastName, age, email, seatNo, gender, mobile, dateOfJourney, source, destination);
	if(flag==true) {
		return "success";
	}
	else {
		return "failure";
	}
	
	}
	
	
	
}
	
	
	

