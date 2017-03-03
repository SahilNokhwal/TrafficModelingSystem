package com.system.simulation.car;

import java.util.Comparator;
import java.util.Date;

public class Car implements Comparator<Car>{
	
	 private String carName;
	 private int carRank;
	 private Date arrivalTime;
	 private int carSpeed;
	 private Date departureTime;
	 private String bound;
	 
	 public Car()
	 {
		 
	 }
	 
	public Car(String carName, int carSpeed, String bound) {
		super();
		this.carName = carName;
		this.carSpeed = carSpeed;
		this.bound = bound;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public int getCarRank() {
		return carRank;
	}

	public void setCarRank(int carRank) {
		this.carRank = carRank;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getCarSpeed() {
		return carSpeed;
	}

	public void setCarSpeed(int carSpeed) {
		this.carSpeed = carSpeed;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public String getBound() {
		return bound;
	}

	public void setBound(String bound) {
		this.bound = bound;
	}

	@Override
	public int compare(Car car1, Car car2) {           
		
		return Long.compare(car1.getArrivalTime().getTime(), car2.getArrivalTime().getTime());
	}
	
	
	 
	 

}
