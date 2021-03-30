package com.psa.Repeat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psa.Repeat.Entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
