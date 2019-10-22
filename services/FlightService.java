package com.nationwide.flightlog.services;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.nationwide.flightlog.data.Flight;
import com.nationwide.flightlog.repos.FlightRepo;

@Component
public class FlightService {
	
	@Autowired
	private FlightRepo repo;
	
	public ArrayList<Flight> showall() {
		return repo.findAll();
	}
	
	public Flight showId(int R) {
		return repo.findByIdnumber(R);
	}
	
	public ArrayList<Flight> showFlighttime(int R) {
		return repo.findByFlighttime(R);
	}
	
	public ArrayList<Flight> showFlightdate(Date R) {
		return repo.findByFlightdate(R);
	}

	public ArrayList<Flight>showPassengers(int R) {
		return repo.findByPassengers(R);
	}
	
	public ArrayList<Flight> showAirfield(String R) {
		return repo.findByAirfield(R);
	}
	
	public String saveWithoutID(String Pic, String Des, int Time, Date Dt, int Pass, String Air) {
		int ID = (int) (repo.count() + 1);
		Flight F1 = new Flight(ID, Pic, Des, Time, Dt, Pass, Air);
		repo.save(F1);
		return "New Flight Saved";
	}
	
	public String deleteFlight(int ID) {
		Flight F = repo.findByIdnumber(ID);
		repo.delete(F);
		return "Flight Deleted";
	}
	
	public String sumAllFlighttime() {
		int all = repo.sumAllFlighttime();
		int hours = all/60;
		int mins = all%60;
		return (hours + " hours and " + mins + " mins");
	}
	
	public String sumFlighttimeDates(Date D1, Date D2) {
		try {
		int all = repo.sumFlighttimeDates(D1, D2);
		if(all > 0) {
			int hours = all/60;
			int mins = all%60;
			return (hours + " hours and " + mins + " mins");
		}
		else return "Flight Time is 0 - check dates";
		}
		catch(Exception e) {
		return "Flight Time is 0 - check dates";
		}
	}
	
	public String changeFlight(int Id, String Pic, String Des, int Time, Date Dt, int Pass, String Air) {
		Flight F1 = repo.findByIdnumber(Id);
		F1.setPicture(Pic);
		F1.setDescription(Des);
		F1.setFlighttime(Time);
		F1.setFlightdate(Dt);
		F1.setAirfield(Air);
		return "Flight Changed";
		
	}

}
