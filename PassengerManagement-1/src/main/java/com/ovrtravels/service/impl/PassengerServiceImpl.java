package com.ovrtravels.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.ovrtravels.domain.Gender;
import com.ovrtravels.domain.Passenger;
import com.ovrtravels.domain.PassengerDTO;
import com.ovrtravels.repository.PassengerRepository;
import com.ovrtravels.service.IPassengerService;
@Service
public class PassengerServiceImpl implements IPassengerService {
@Autowired
PassengerRepository repo;
@Autowired
RestTemplate restTemplate;

	/*
	 * @Override public boolean ticketBooking(String firstName,String
	 * lastName,Integer age,String email,Integer seatNo,Gender gender,Long
	 * mobile,Date dateOfJourney) { Passenger p=new Passenger(); p.setAge(age);
	 * p.setEmail(email); p.setFirstName(firstName); p.setLastName(lastName);
	 * p.setGender(gender.name()); p.setMobile(mobile);
	 * p.setJourneyDate(dateOfJourney); p.setSeatNo(seatNo); Integer ticketNo=2020;
	 * p.setTicketId(ticketNo);
	 * 
	 * boolean flag= repo.existsById(seatNo);
	 * 
	 * if(flag==true) { return false; } else { repo.saveAndFlush(p);
	 * 
	 * return true; }
	 * 
	 * } public List<Passenger> findByAge(Integer age){ return repo.findByAge(age);
	 * }
	 */
	@Override
	public String bookATicket(Passenger passenger) {
		if(repo.existsById(passenger.getSeatNo())==false) {
		repo.save(passenger);
		return "your ticket is confirmed";
		}
		return "sorry your ticket is not confirmed";
		
	}
	
	  @Override 
	  public List<Passenger> getPassengersByAge(Integer age) {
      List<Passenger> passengersByAge=repo.findByAge(age);
	  passengersByAge.forEach(p2->{
		  System.out.println(p2.getAge());
		  System.out.println(p2.getEmail());
		  System.out.println(p2.getFirstName());
		  System.out.println(p2.getGender());
		  System.out.println(p2.getJourneyDate());
		  System.out.println(p2.getMobile());
		  System.out.println(p2.getSeatNo());
		  System.out.println(p2.getLastName());
		  System.out.println("===============");
	  });
	  return passengersByAge;
	  }
	 
	 
	  @Override
	  public List<PassengerDTO> getAllPassengers() { 
	List<Passenger> passengers=repo.findAll();
	List<PassengerDTO> listDto=new ArrayList<>();
	  passengers.forEach(passenger->{ PassengerDTO list2=new PassengerDTO();
	  BeanUtils.copyProperties(passenger, list2); 
	  listDto.add(list2); });
		/*
		 * listDto.forEach(a->{ System.out.println("Test--->"+a.getEmail());
		 * 
		 * })
		 */;	  
	  return listDto; }
	 
}
