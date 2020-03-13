package com.ovrtravels.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ovrtravels.domain.Passenger;
@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Integer> {

}
