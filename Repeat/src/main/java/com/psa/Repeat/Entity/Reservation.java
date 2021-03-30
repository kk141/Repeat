package com.psa.Repeat.Entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Reservation extends Abstractclass {
	private boolean checkedIn;
	private int NumberOfBags;
	
	@OneToOne
	private Passenger passenger;
	

	@OneToOne
	private Flight flight;


	public boolean isCheckedIn() {
		return checkedIn;
	}


	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}


	public int getNumberOfBags() {
		return NumberOfBags;
	}


	public void setNumberOfBags(int numberOfBags) {
		NumberOfBags = numberOfBags;
	}


	public Passenger getPassenger() {
		return passenger;
	}


	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}


	public Flight getFlight() {
		return flight;
	}


	public void setFlight(Flight flight) {
		this.flight = flight;
	}

}
