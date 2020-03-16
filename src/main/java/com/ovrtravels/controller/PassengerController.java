package com.ovrtravels.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ovrtravels.domain.Gender;
import com.ovrtravels.service.IPassengerServiceMail;
import com.ovrtravels.service.impl.PassengerServiceImpl;

@Controller
public class PassengerController {
	@Autowired
	private PassengerServiceImpl impl;

	@Autowired
	private IPassengerServiceMail mail;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		CustomDateEditor dateEditor = new CustomDateEditor(sdf, true);
		webDataBinder.registerCustomEditor(Date.class, dateEditor);
	}

	@GetMapping("/bookTicket")
	public String ticketBooking() {

		return "bookingPage";

	}

	boolean flag;
	String passengerName;
	String toAddress;
	String subject = "From Spring Application ...";

	@PostMapping("/process")
	public String processing( @RequestParam String firstName,
			@RequestParam String lastName, @RequestParam Integer age, @RequestParam String email,
			@RequestParam Integer seatNo, @RequestParam Gender gender, @RequestParam Long mobile,
			@RequestParam Date dateOfJourney, @RequestParam String source, @RequestParam String destination) {
		boolean flag = impl.ticketBooking(firstName, lastName, age, email, seatNo, gender, mobile,
				dateOfJourney, source, destination);
		if (flag == true) {
			passengerName = firstName + " " + lastName;
			toAddress = email;
			this.flag = flag;

			if (flag == true) {
				String message = passengerName + "...,\nTicket Booking is Successful...";

				mail.sendEmail(email, subject, message);
				System.out.println("Message sent to mail...");
			} else {
				System.out.println("Message not sent to mail...");

			}
			return "success";
		} else {
			return "failure";
		}

	}

}
