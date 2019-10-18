package com.nationwide.flightlog.controllers;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nationwide.flightlog.data.Airfield;
import com.nationwide.flightlog.data.Flight;
import com.nationwide.flightlog.repos.AirfieldRepo;
import com.nationwide.flightlog.repos.FlightRepo;


@RestController
public class AirfieldController {
	
	@Autowired
	private AirfieldRepo repo;
	
	@GetMapping("/showallAirfield")
	public ArrayList<Airfield> showall() {
		return repo.findAll();
	}
	
	@GetMapping("/filterAirfieldId/{R}")
	public Airfield showId(@PathVariable int R) {
		return repo.findByIdnumber(R);
	}
	
	@GetMapping("/LandingFeeLessThan/{X}")
	public ArrayList<Airfield> findLessThan(Float X) {
		return repo.findLessThan(X);
	}
	
	@GetMapping("/LandingFeeMoreThan/{X}")
	public ArrayList<Airfield> findMoreThan(Float X) {
		return repo.findGreaterThan(X);
	}
	
	@GetMapping("/LandingFeeBetween/{X}/{Y}")
	public ArrayList<Airfield> findBetween(Float X, Float Y) {
		return repo.findBetween(X, Y);
	}
	
	@PostMapping("saveAirfield/{Pic}/{Des}/{Tip}/{Pro}/{Con}/{Fee}")
	public String saveWithoutID(
			@PathVariable String Pic, 
			@PathVariable String Des, 
			@PathVariable String Tip,
			@PathVariable String Pro,
			@PathVariable String Con,
			@PathVariable float Fee) {
		int ID = (int)repo.count() + 1;
		Airfield A1 = new Airfield(ID, Pic, Des, Tip, Pro, Con, Fee);
		repo.save(A1);
		return "New Airfield Saved";
	}
	
	@DeleteMapping("/deleteAirfield/{ID}")
	public String deleteAirfield(@PathVariable int ID) {
		Airfield A = repo.findByIdnumber(ID);
		repo.delete(A);
		return "Airfield Deleted";
	}

}
