package com.psa.Repeat.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.psa.Repeat.Entity.Flight;
import com.psa.Repeat.Repository.FlightRepository;


@Controller
public class FlightController {
	
	
	@Autowired
	FlightRepository flightrepo;
	
	@RequestMapping("/ucanbook")
	public String ucanbook(@RequestParam("from")String from,@RequestParam("to")String to,@RequestParam("departureDate") @DateTimeFormat(pattern="MM-dd-yyyy") Date departureDate,ModelMap modelmap) {
		List<Flight> findFlight = flightrepo.findFlight(from,to,departureDate);
		modelmap.addAttribute("findFlight",findFlight);
		return "displayFlights";
		
	}

}
