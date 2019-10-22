package com.nationwide.flightlog.controllers;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import com.nationwide.flightlog.data.Flight;
import com.nationwide.flightlog.repos.FlightRepo;
import com.nationwide.flightlog.services.FlightService;


@RestController
public class FlightController {
	
	@Autowired
	private FlightService service;
	
	@GetMapping("/showAllFlight")
	public ArrayList<Flight> showall() {
		return service.showall();
	}
	
	@GetMapping("/filterFlightId/{R}")
	public Flight showId(@PathVariable int R) {
		return service.showId(R);
	}
	
	@GetMapping("/filterTime/{R}")
	public ArrayList<Flight> showFlighttime(@PathVariable int R) {
		return service.showFlighttime(R);
	}
	
	@GetMapping("/filterDate/{R}")
	public ArrayList<Flight> showFlightdate(@PathVariable Date R) {
		return service.showFlightdate(R);
	}
	
	@GetMapping("/filterPassengers/{R}")
	public ArrayList<Flight>showPassengers(@PathVariable int R) {
		return service.showPassengers(R);
	}
	
	@GetMapping("/filterAirfield/{R}")
	public ArrayList<Flight> showAirfield(@PathVariable String R) {
		return service.showAirfield(R);
	}
		
	@PostMapping("saveFlight/{Pic}/{Des}/{Time}/{Dt}/{Pass}/{Air}")
	public String saveWithoutID(
			@PathVariable String Pic, 
			@PathVariable String Des, 
			@PathVariable int Time,
			@PathVariable Date Dt,
			@PathVariable int Pass,
			@PathVariable String Air) {
		return service.saveWithoutID(Pic, Des, Time, Dt, Pass, Air);
	}
	
	@DeleteMapping("/deleteFlight/{ID}")
	public String deleteFlight(@PathVariable int ID) {
		return service.deleteFlight(ID);
	}
	

	@GetMapping("sumAllFlighttime")
	public String sumAllFlighttime() {
		return service.sumAllFlighttime();
	}
	
	@GetMapping("sumFlighttimeBetween/{D1}/{D2}")
	public String sumFlighttimeBetween(@PathVariable Date D1, @PathVariable Date D2) {
		return service.sumFlighttimeDates(D1, D2);
	}
	
	@PostMapping("changeFlight/{Id}/{Pic}/{Des}/{Time}/{Dt}/{Pass}/{Air}")
	public String changeFlight(@PathVariable int Id,
			@PathVariable String Pic, 
			@PathVariable String Des, 
			@PathVariable int Time,
			@PathVariable Date Dt,
			@PathVariable int Pass,
			@PathVariable String Air) {
		return service.changeFlight(Id, Pic, Des, Time, Dt, Pass, Air);
	}
}
