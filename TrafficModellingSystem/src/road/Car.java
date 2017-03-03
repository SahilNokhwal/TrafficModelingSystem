/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lights;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author S525746
 */
public class Car {
     private static final int INCREMENT = 5;
        int x, y;
        private static final int D_W = 400;
    private static final int D_H = 400;
    private double maxVelocity;
    private double brakeDistance;
    private double stopDistance;
    private CarDirectionInterface currentRoad;
	private double frontPosition;
	private boolean NSDirectionCar;
    
        public Car(int x, int y, double maxVelocity,double brakeDistance, double stopDistance ) throws IllegalException {
            
            if (maxVelocity <= 0.0 || brakeDistance <= 0.0
				|| stopDistance <= 0.0){
                throw new IllegalException();
            }
            else{
            this.x = x;
            this.y = y;
            this.maxVelocity = maxVelocity;
	    this.brakeDistance = brakeDistance;
	    this.stopDistance = stopDistance;
        }
        }
        public void drawCar(Graphics g) {
            g.setColor(Color.white);
            g.fillRect(x, y, 25, 15);
           // g.setColor(Color.BLACK); // body
//            g.fillOval(x + 15, y + 20, 15, 15); // wheel
//            g.fillOval(x + 60, y + 20, 15, 15); // wheel
         //   g.fillRect(x + 15, y - 20, 60, 20); // top
                      

        }
        public boolean getNSCar() {
		return NSDirectionCar;
	}
        public void setCurrentRoad(CarDirectionInterface newCurrentRoad) {
		currentRoad = newCurrentRoad;
	}
        public CarDirectionInterface getCurrentRoad(){
            return currentRoad;
        }
        
        public double getRoadClosed(){
            return stopDistance;
        }
        
	public void setNSCar(boolean NSDirection) {
		NSDirectionCar = NSDirection;
	}
        public void move() {
            if (x == D_W) {
                x = 0;
            } else {
                x += INCREMENT;
            }
//            if (y == D_H) {
//                y = 0; 
//            } else {
//                y += INCREMENT;
//            }
        }
        public double calculateVelocity(double distanceToObsticle) {
		double carVelocity;
		carVelocity = (maxVelocity / (brakeDistance - stopDistance))
				* (distanceToObsticle - stopDistance);
		carVelocity = Math.max(0.0, carVelocity);
		carVelocity = Math.min(maxVelocity, carVelocity);
		while (carVelocity > distanceToObsticle)
			carVelocity = carVelocity / 2; // carVelocity = 0;
		return carVelocity;
	}

   
	public double getMaxVelocity() {
		return maxVelocity;
	}
        
    
}
