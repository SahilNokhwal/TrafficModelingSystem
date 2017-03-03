package com.system.simulation.test;

import com.system.simulation.car.resource.CarSpeeding;

import junit.framework.TestCase;

public class CarSpeedingTest extends TestCase {
	
	public void testMaxSpeed()
	{
		CarSpeeding carSpeeding = new CarSpeeding();
		int maxSpeed = carSpeeding.maximumSpeed(70);
		assertEquals(60, maxSpeed);
		
	}
	
	public void testMinSpeed()
	{
		CarSpeeding carSpeeding = new CarSpeeding();
		int minSpeed = carSpeeding.minumSpeed(30);
		assertEquals(30, minSpeed);
		
	}

}