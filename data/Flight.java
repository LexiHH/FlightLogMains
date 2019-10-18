package com.nationwide.flightlog.data;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Flight")
public class Flight {
	@Id
	private int idnumber;
	private String picture;
	private String description;
	private int flighttime;
	private Date flightdate;
	private int passengers;
	private String airfield;
	
	public Flight() {
	}

	public Flight(int idnumber, String picture, String description, int flighttime, Date flightdate, int passengers,
			String airfield) {
		super();
		this.idnumber = idnumber;
		this.picture = picture;
		this.description = description;
		this.flighttime = flighttime;
		this.flightdate = flightdate;
		this.passengers = passengers;
		this.airfield = airfield;
	}

	public int getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(int idnumber) {
		this.idnumber = idnumber;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getFlighttime() {
		return flighttime;
	}

	public void setFlighttime(int flighttime) {
		this.flighttime = flighttime;
	}

	public Date getFlightdate() {
		return flightdate;
	}

	public void setFlightdate(Date flightdate) {
		this.flightdate = flightdate;
	}

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	public String getAirfield() {
		return airfield;
	}

	public void setAirfield(String airfield) {
		this.airfield = airfield;
	}
}