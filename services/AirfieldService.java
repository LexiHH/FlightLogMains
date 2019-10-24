package com.nationwide.flightlog.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nationwide.flightlog.data.Airfield;
import com.nationwide.flightlog.repos.AirfieldRepo;

@Component
public class AirfieldService {
	
	@Autowired
	private AirfieldRepo repo;
	
	public ArrayList<Airfield> showAll() {
		return repo.findAll();
	}
	
	public Airfield showId(int R) {
		return repo.findByIdnumber(R);
	}
	
	public ArrayList<Airfield> findLessThan(Float X) {
		return repo.findByLandingfeeLessThan(X);
	}
	
	public ArrayList<Airfield> findMoreThan(Float X) {
		return repo.findByLandingfeeGreaterThan(X);
	}
	
	public ArrayList<Airfield> findBetween(Float X, Float Y) {
		return repo.findByLandingfeeBetween(X, Y);
	}
	
	public String saveWithoutID(String Pic, String Des, String Tip,String Pro,String Con,float Fee) {
		int ID = repo.findMaxIdnumber() + 1;
		Airfield A1 = new Airfield(ID, Pic, Des, Tip, Pro, Con, Fee);
		repo.save(A1);
		return "New Airfield Saved";
	}

	public String deleteAirfield(int ID) {
		Airfield A = repo.findByIdnumber(ID);
		repo.delete(A);
		return "Airfield Deleted";
	}
}
