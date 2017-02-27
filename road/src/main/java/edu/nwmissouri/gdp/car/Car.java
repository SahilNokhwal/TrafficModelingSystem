package edu.nwmissouri.gdp.car;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import edu.nwmissouri.gdp.road.SimulationPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * @author Sahil Nokhwal
 * SID: S525352
 */
public class Car {
        private static final int INCREMENT = 5;
        int carStartingXPosition, carStartingYPosition;
        private static final int carHorizontalPath = 100;
        private static final int carVerticalPath = 800;
        Graphics g;
        
        public Car(int x, int y) {
            this.carStartingXPosition = x;
            this.carStartingYPosition = y;
        }
        public void drawCar(Graphics g) {
        	this.g= g;
            g.setColor(Color.red);
            g.fillRect(carStartingXPosition, carStartingYPosition, 25, 15);
           // g.setColor(Color.BLACK); // body
//            g.fillOval(x + 15, y + 20, 15, 15); // wheel
//            g.fillOval(x + 60, y + 20, 15, 15); // wheel
         //   g.fillRect(x + 15, y - 20, 60, 20); // top
                      

        }

        public void move()  {
        	while(true){
            if (carStartingXPosition == carHorizontalPath) {
                //carStartingXPosition = 0;
            	break;
            } else {
            	carStartingXPosition += INCREMENT;
            	 
//            	try {
//					Thread.sleep(100);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
            }
//            if (y == D_H) {
//                y = 0; 
//            } else {
//                y += INCREMENT;
//            }
        }
     
      }
    }
