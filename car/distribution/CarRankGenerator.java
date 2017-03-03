package com.system.simulation.car.distribution;

import java.util.ArrayList;
import java.util.HashMap;

import com.system.simulation.car.Car;

public class CarRankGenerator {

	HashMap<String, Car> carMap = new HashMap<String, Car>();

	public HashMap<String, Car> assignRank(ArrayList<Car> carList) {

		int rank = 1;

		for (Car car : carList) {

			car.setCarRank(rank);
			rank++;
			carMap.put(car.getCarName(), car);
		}    
                

		return carMap;

	}
}
