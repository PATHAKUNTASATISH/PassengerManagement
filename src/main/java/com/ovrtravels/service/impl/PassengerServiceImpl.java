package com.ovrtravels.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ovrtravels.domain.Gender;
import com.ovrtravels.domain.Passenger;
import com.ovrtravels.repository.PassengerRepository;
import com.ovrtravels.service.IPassengerService;
@Service
public class PassengerServiceImpl implements IPassengerService {
@Autowired
PassengerRepository repo;
	@Override
	public boolean ticketBooking(String firstName,String lastName,Integer age,String email,Integer seatNo,Gender gender,Long mobile,Date dateOfJourney, String source, String destination) {
    Passenger p=new Passenger();
    p.setAge(age);
    p.setEmail(email);
    p.setFirstName(firstName);
    p.setLastName(lastName);
    p.setGender(gender.name());
    p.setMobile(mobile);
                              Integer ticketNo=9492;
    p.setTicketId(ticketNo);
    p.setJourneyDate(dateOfJourney);
    p.setSeatNo(seatNo);
    p.setSource(source);
    p.setDestination(destination);
    
    
    boolean flag= repo.existsById(seatNo);
    
    if(flag==true) {
    	return false;
    }
    else {
    	repo.saveAndFlush(p);
    	return true;
    }
		
	}

}
