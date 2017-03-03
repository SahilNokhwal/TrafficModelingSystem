/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lights;

/**
 *
 * @author S525746
 */
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public class Lights {

private LightStateControlInterface lightState;
	private List<Car> cars = new ArrayList<Car>();
	private CarDirectionInterface nextNSRoad;
	private CarDirectionInterface nextEWRoad;
	private CarDirectionInterface nextRoad;
	private double roadEnd;
	double greenLightTime;
	double yellowLightTime;

	Lights(double roadEnd) {
		if (Math.random() <= 0.5) {
			lightState = new LightTurnsGreen();
		} else {
			lightState = (LightStateControlInterface) new LightTurnsRed();
		}

		if (roadEnd < 0.0) {
			throw new IllegalArgumentException("Road can not be <= 0");
		} else {
			this.roadEnd = roadEnd;
		}

		
	}

	public String getState() {
		return "";
	}

	public void run(Car d) {
            
           d.move();
		}

	public void acceptCar(Car d, double frontPosition) {
		if (d == null) {
			throw new IllegalArgumentException("Null Car");
		}
		cars.remove(d);
		if (frontPosition > getRoadClosed()) {
			getNextRoad(d).acceptCar(d, frontPosition - getRoadClosed());
		} else {
			
		}
	}

	public void removeCar(Car d) {
		if (d == null) {
			throw new IllegalArgumentException("Null Car");
		}
		cars.remove(d);
	}

	public List<Car> getCars() {
		return cars;
	}

	public CarDirectionInterface getNextRoad(Car c) {
		if (c.getNSCar())
			return getNextNorthSouthRoad();
		else
			return getNextEastWestRoad();
	}

	public void setNextRoad(CarDirectionInterface r) {
		nextRoad = r;
	}

	public void setNextNorthSouthRoad(CarDirectionInterface road) {
		// TODO Auto-generated method stub
		nextNSRoad = road;
	}

	public void setNextEastWestRoad(CarDirectionInterface road) {
		// TODO Auto-generated method stub
		nextEWRoad = road;
	}

	public CarDirectionInterface getNextNorthSouthRoad() {
		// TODO Auto-generated method stub
		return nextNSRoad;
	}

	public CarDirectionInterface getNextEastWestRoad() {
		// TODO Auto-generated method stub
		return nextEWRoad;
	}

	public double getRoadClosed() {
		// TODO Auto-generated method stub
		return roadEnd;
	}
}
