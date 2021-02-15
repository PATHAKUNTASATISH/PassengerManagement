package com.ovrtravels.service;

import java.util.List;
import com.ovrtravels.domain.Passenger;
import com.ovrtravels.domain.PassengerDTO;

public interface IPassengerService {
	
	
//public boolean ticketBooking(String firstName,String lastName,Integer age,String email,Integer seatNo,Gender gender,Long mobile,Date dateOfJourney);
public List<Passenger> getPassengersByAge(Integer age);
public List<PassengerDTO> getAllPassengers();
public String bookATicket(Passenger passenger);




}
