/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lights;

import java.awt.Color;

/**
 *
 * @author S525746
 */
public class LightTurnsGreen implements LightStateControlInterface {
	public String getState() {
		return "GREEN";
	}

	public Color getColor() {
		return Color.GREEN;
	}

	public LightStateControlInterface next() {
		return (LightStateControlInterface) new LightTurnsYellow();
	}

	public double distanceToObstacle(Car car, double frontPosition, Lights light) {
		// TODO Auto-generated method stub
		double distance = Double.POSITIVE_INFINITY;
		if (car.getNSCar() && car.getCurrentRoad() != light) {
			distance = car.getCurrentRoad().getRoadClosed() - frontPosition;
		}
		return distance;
	}

	public double myTime(double greenLight, double yellowLight) {
		// TODO Auto-generated method stub
		return greenLight;
	}
      

	
}
