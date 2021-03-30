package com.psa.Repeat.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.psa.Repeat.Entity.Flight;
import com.psa.Repeat.Entity.Passenger;
import com.psa.Repeat.Entity.Reservation;
import com.psa.Repeat.Repository.FlightRepository;
import com.psa.Repeat.Repository.PassengerRepository;
import com.psa.Repeat.Repository.ReservationRepository;
import com.psa.Repeat.util.Email;
import com.psa.Repeat.util.Pdf;

@Controller
public class ReservationController {
	private static String folderPath="C:\\Users\\wi10\\Documents\\workspace-spring-tool-suite-4-4.8.0.RELEASE\\Repeat\\target\\tickets";
	
	@Autowired
	ReservationRepository reservationrepo;
	
	@Autowired
	PassengerRepository passengerrepo;
	
	@Autowired
	FlightRepository flightrepo;
	
	@Autowired
	ReservationRepository reservationRepo;
	
	@Autowired
	Email emailsender;
	
	@Autowired
	Pdf pdfgenerater;
	
	@RequestMapping("showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId")Long flightId,ModelMap modelmap) {
		Optional<Flight> findById = flightrepo.findById(flightId);
		Flight flight = findById.get();
		modelmap.addAttribute("flight",flight);
		return "confirm";
	}
	@RequestMapping("findit")
	public String findit(@RequestParam("firstName")String firstName,@RequestParam("lastName")String lastName,@RequestParam("middleName")String middleName,@RequestParam("email")String email,@RequestParam("phone")String phone,@RequestParam("flightId")Long flightId, ModelMap modelmap) {
		Passenger passenger=new Passenger();
		passenger.setFirstName(firstName);
		passenger.setLastName(lastName);
		passenger.setMiddleName(middleName);
		passenger.setEmail(email);
		passenger.setPhone(phone);
		passengerrepo.save(passenger);
		
		Optional<Flight> findById = flightrepo.findById(flightId);
		Flight flight = findById.get();
		
		
		Reservation reservation=new Reservation();
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		reservation.setPassenger(passenger);
		reservation.setFlight(flight);
		
		reservationRepo.save(reservation);
		
		modelmap.addAttribute("firstName", firstName);
		modelmap.addAttribute("lastName", lastName);
		modelmap.addAttribute("middleName", middleName);
		modelmap.addAttribute("email", email);
		modelmap.addAttribute("phone", phone);
		modelmap.addAttribute("operatingAirlines", flight.getOperatingAirlines());
		modelmap.addAttribute("departureCity", flight.getDepartureCity());
		modelmap.addAttribute("arrivalCity", flight.getArrivalCity());
		modelmap.addAttribute("estimatedDepartureTime", flight.getEstimatedDepartureTime());
		

		String estimatedDepartureTime = flight.getEstimatedDepartureTime().toString();
		pdfgenerater.citiesReport(folderPath+"ticket"+passenger.getId()+".pdf",passenger.getFirstName(),passenger.getEmail(),passenger.getPhone(),flight.getOperatingAirlines(),estimatedDepartureTime,flight.getDepartureCity(),flight.getArrivalCity());
		emailsender.sendMessageWithAttachment(passenger.getEmail(), "Ticket Details", "Please download the ticket",  folderPath);
		
		return "final";
	}

}
