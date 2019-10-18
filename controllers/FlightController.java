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


@RestController
public class FlightController {
	
	@Autowired
	private FlightRepo repo;
	
	@GetMapping("/showAllFlight")
	public ArrayList<Flight> showall() {
		return repo.findAll();
	}
	
	@GetMapping("/filterFlightId/{R}")
	public Flight showId(@PathVariable int R) {
		return repo.findByIdnumber(R);
	}
	
	@GetMapping("/filterTime/{R}")
	public ArrayList<Flight> showFlighttime(@PathVariable int R) {
		return repo.findByFlighttime(R);
	}
	
	@GetMapping("/filterDate/{R}")
	public ArrayList<Flight> showFlightdate(@PathVariable Date R) {
		return repo.findByFlightdate(R);
	}
	
	@GetMapping("/filterPassengers/{R}")
	public ArrayList<Flight>showPassengers(@PathVariable int R) {
		return repo.findByPassengers(R);
	}
	
	@GetMapping("/filterAirfield/{R}")
	public ArrayList<Flight> showAirfield(@PathVariable String R) {
		return repo.findByAirfield(R);
	}
		
	@PostMapping("saveFlight/{Pic}/{Des}/{Time}/{Dt}/{Pass}/{Air}")
	public String saveWithoutID(
			@PathVariable String Pic, 
			@PathVariable String Des, 
			@PathVariable int Time,
			@PathVariable Date Dt,
			@PathVariable int Pass,
			@PathVariable String Air) {
		int ID = (int) (repo.count() + 1);
		Flight F1 = new Flight(ID, Pic, Des, Time, Dt, Pass, Air);
		repo.save(F1);
		return "New Flight Saved";
	}
	
	@DeleteMapping("/deleteFlight/{ID}")
	public String deleteFlight(@PathVariable int ID) {
		Flight F = repo.findByIdnumber(ID);
		repo.delete(F);
		return "Flight Deleted";
	}
	


}
