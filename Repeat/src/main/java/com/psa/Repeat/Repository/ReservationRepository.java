package com.psa.Repeat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psa.Repeat.Entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
