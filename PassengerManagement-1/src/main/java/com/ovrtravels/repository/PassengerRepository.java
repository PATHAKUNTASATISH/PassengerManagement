package com.ovrtravels.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ovrtravels.domain.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Integer> {
	
	public List<Passenger> findByAge(Integer age);
	public List<Passenger> findByMobile(Long mobile);

}
