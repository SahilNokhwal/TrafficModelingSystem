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
public interface LightStateControlInterface {
    
    	String getState();

	Color getColor();

	LightStateControlInterface next();

	double myTime(double greenLight, double yellowLight);

	double distanceToObstacle(Car car, double frontPosition, Lights light);
}
