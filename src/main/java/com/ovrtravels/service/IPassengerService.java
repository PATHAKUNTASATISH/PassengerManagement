package com.ovrtravels.service;

import java.util.Date;

import com.ovrtravels.domain.Gender;

public interface IPassengerService {
	
	
	public boolean ticketBooking(String firstName,String lastName,Integer age,String email,Integer seatNo,Gender gender,Long mobile,Date dateOfJourney, String source, String destination);

}
