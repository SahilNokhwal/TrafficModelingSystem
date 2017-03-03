/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Car;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import road.SimulationPanel;

/**
 *
 * @author s525747
 */
//code for car properties
public class Car {
        private static final int INCREMENT = 5;
        int carXPosition,carYPosition;
        private static final int carHorizontalPath = 100;
        private static final int carVerticalPath = 800;
        private int speed;
        private double acceleration;
        private double brakeDistance;
       
        AccelerationChanges acr;
        DecelerationChanges dcr;

    public static int getINCREMENT() {
        return INCREMENT;
    }
        
        Graphics g;
        
        public int getSpeed(){
            return speed;
        }
        public double getAcceleration(){
            return acceleration;
        }
        public Car(int speed){
            this.speed = speed;
        }

    public int getCarXPosition() {
        return carXPosition;
    }

    public void setCarPosition(int carXPosition, int carYPosition) {
        this.carXPosition = carXPosition;
        this.carYPosition = carYPosition;
     
        
    }

    public int getCarYPosition() {
        return carYPosition;
    }


        public void accelerate(){
            this.speed +=5;
        }
        

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public int increaseSpeed(){
        return acr.accelerate(getSpeed());
    }
    
    public int decreaseSpeed(){
        return dcr.decelerate(getSpeed());
    }
}
