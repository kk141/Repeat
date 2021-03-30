package com.psa.Repeat.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.psa.Repeat.Entity.Flight;

public interface FlightRepository extends JpaRepository<Flight,Long> {
	
	@Query("from Flight where departureCity=:from and arrivalCity=:to and dateOfDeparture=:departureDate")
	List<Flight> findFlight(@Param("from")String from, @Param("to")String to, @Param("departureDate") Date departureDate);

}
