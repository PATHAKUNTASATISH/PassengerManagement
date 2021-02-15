package com.ovrtravels.controller;


import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ovrtravels.domain.Passenger;
import com.ovrtravels.domain.PassengerDTO;
import com.ovrtravels.service.IPassengerService;
import com.ovrtravels.service.impl.PassengerServiceImpl;
import com.sun.istack.NotNull;

@RestController
@Validated
public class PassengerController {
	@Autowired
	IPassengerService service;
	
	/*	 * @InitBinder public void initBinder(WebDataBinder webDataBinder) {
	 * SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd"); CustomDateEditor
	 * dateEditor=new CustomDateEditor(sdf, true);
	 * webDataBinder.registerCustomEditor(Date.class, dateEditor); }
	 */
	/*
	 * @GetMapping("/bookTicket") public String ticketBooking() {
	 * 	 * return "bookingPage";
	 * 	 * }
	 * 	 * @PostMapping("/process") public String processing(@RequestParam String
	 * firstName,@RequestParam String lastName,@RequestParam Integer
	 * age,@RequestParam String email,@RequestParam Integer seatNo,@RequestParam
	 * Gender gender,@RequestParam Long mobile,@RequestParam Date dateOfJourney) {
	 * boolean flag = impl.ticketBooking(firstName, lastName, age, email, seatNo,
	 * gender, mobile, dateOfJourney); if(flag==true) { return "success"; } else {
	 * return "failure"; }
	 * 
	 * }
	 */	
	
	  @PostMapping("/bookATicket") 
	  public ResponseEntity<String> bookATicket(@RequestBody @Valid Passenger passenger){
		  return new ResponseEntity<String>(service.bookATicket(passenger),HttpStatus.OK);
	  }
	  
	  @GetMapping("/passengersByAge")
	  public ResponseEntity<List<Passenger>> findByAge(@RequestParam @NotNull Integer age,Model model){
	  return new ResponseEntity<List<Passenger>>(service.getPassengersByAge(age),HttpStatus.OK);
	  }
	  
	  @GetMapping("/getAllPassengers")
		public ResponseEntity<List<PassengerDTO>> getAllPassengers(){
			return new ResponseEntity<List<PassengerDTO>>(service.getAllPassengers(),HttpStatus.OK);
		}
	 
	/*
	 * @GetMapping("/getAllPassengers") public ModelAndView getAllPassengers(){
	 * ModelMap model=new ModelMap();
	 * model.addAttribute("pList",impl.getAllPassengers()); ModelAndView
	 * modelAndView=new ModelAndView("getAllPassengers", model); return
	 * modelAndView; }
	 */
	
	
	
	
}
