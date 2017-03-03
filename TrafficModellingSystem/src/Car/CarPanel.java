/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Car;

import edu.nwmissouri.gdp.road.StaticFourWayPanel;
import edu.nwmissouri.gdp.road.StaticFourWaySignalPanel;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author s525747
 */
public class CarPanel {
        private CarPanel carProperties;
    private Car car;
    private static final int INCREMENT = 1;
    private int carInitialXPosition = 0;
    private int carInitialYPosition = 270;
    private int carPresentXPosition;
    private int carPresentYPosition;
    private static final int carHorizontalPath = 900;
    private static final int carVerticalPath = 100;
    StaticFourWayPanel fourWay = new StaticFourWayPanel();
    StaticFourWaySignalPanel fourWaySignal = new StaticFourWaySignalPanel();

    public int getCarInitialXPosition() {
        return carInitialXPosition;
    }

    public int getCarInitialYPosition() {
        return carInitialYPosition;
    }

    public int getCarHeight() {
        return carHeight;
    }

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(CarPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static enum carCordinates {

    }

    public void setStopCount(int stopCount) {
        this.stopCount = stopCount;
    }

    public static int getINCREMENT() {
        return INCREMENT;
    }

    public int getStopCount() {
        return stopCount;
    }

    public int getXposition() {
        return carPresentXPosition;
    }

    public int gatYposition() {
        return carPresentYPosition;
    }

    public void setCarPresentXPosition(int carPresentXPosition) {
        this.carPresentXPosition = carPresentXPosition;
    }

    public void setCarPresentYPosition(int carPresentYPosition) {
        this.carPresentYPosition = carPresentYPosition;
    }

    public int getCarPresentXPosition() {
        return carPresentXPosition;
    }

    public int getCarPresentYPosition() {
        return carPresentYPosition;
    }

    private int carWidth = 30;
    private int carHeight = 15;

    public CarPanel() {
        super(null);
    }

    public JPanel getCar(String direction) {
        carProperties = new CarPanel();
      
        JLabel label; 
        if (direction == "rightwards") {
            car = new Car(40);
            label = new JLabel(car.getSpeed() + "\u2192");  //21B4

        } else {
            car = new Car(40);
            label = new JLabel(car.getSpeed() + "\u2190");
        }
        label.setBounds(0, 0, carWidth, carHeight);
        //System.out.println("Inside getCar");
        carProperties.setBackground(Color.white);
        carProperties.setBounds(carInitialXPosition, carInitialYPosition, carWidth, carHeight);
        carProperties.add(label);
        return carProperties;
    }

    public void move() {

        final JPanel jp = this;
        new Thread(new Runnable() {
            public void run() {
                xPosition = new Xposition(carPresentXPosition + 50);
                yPosition = new Yposition(carPresentYPosition + 50);


                while (true) {
//                    //System.out.println(xPosition.isXoccupied());
//                    //System.out.println(xPosition.xPosition);
//                    car.setCarPosition(carPresentXPosition, carPresentYPosition);
//                    //System.out.println(carPresentXPosition);
//                    xPosition = new Xposition(carPresentXPosition + 50);
//                    yPosition = new Yposition(carPresentYPosition + 50);
                    try {
                        Thread.sleep(10);
                        //System.out.println("Car is moving");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (carPresentXPosition >= carHorizontalPath) {
                        //break;
                        carPresentXPosition = 0;
                    } else if (fourWay.getEastStopXPosition() == carPresentXPosition + 25 || fourWaySignal.getWestStopXPosition() == carPresentXPosition+15) {
                        stopCondition(); 
                        carPresentXPosition += carInitialXPosition + INCREMENT;//*0.1*car.getSpeed();
                        carProperties.setBounds(carPresentXPosition, carInitialYPosition, carWidth, carHeight);
                        jp.validate();
                        jp.repaint();
                    } else {
                        carPresentXPosition += carInitialXPosition + INCREMENT;//*0.1*car.getSpeed();
                        //System.out.println(carPresentXPosition+"Front");
                        carProperties.setBounds(carPresentXPosition, carInitialYPosition, carWidth, carHeight);
                        jp.validate();
                        jp.repaint();
                    }
                }
            }
        }).start();

    }

    public int getCarWidth() {
        return carWidth;
    }

    public int getBuffer() {
        return buffer;
    }

    private int buffer;
    private int stopCount = 0;

    public void moveLeft() {

        final JPanel jp = this;
        new Thread(new Runnable() {
            public void run() {

                int x = 950;

                while (true) {
                    try {
                        Thread.sleep(10);
                        //System.out.println("Car is moving");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (carPresentXPosition <= 0) {
                        //break;
                        carPresentXPosition = 950;
                    } else if (fourWaySignal.getEastStopXPosition() == carPresentXPosition -10 || fourWay.getWestStopXPosition() == carPresentXPosition -15) {
                        stopCount++;
                        System.out.println(stopCount + "Stop count");
                        stopCondition();
                        carPresentXPosition -= INCREMENT;//*car.getSpeed()*0.1;
                        carProperties.setBounds(carPresentXPosition, 215, 25, 15);
                        jp.validate();
                        jp.repaint();
                        stopCount -= 1;
                    } else {
                        carPresentXPosition -= INCREMENT;//*car.getSpeed()*0.1;
                        //System.out.println(carPresentXPosition+"reverse");
                        carProperties.setBounds(carPresentXPosition, 215, 25, 15);
                        jp.validate();
                        jp.repaint();
                    }
                }
            }
        }).start();

    }

    public void moveDown() throws InterruptedException {

        final JPanel jp = this;
        new Thread(new Runnable() {
            public void run() {

                int y = 10;
                while (true) {
                    try {
                        Thread.sleep(50);
                        //System.out.println("Car is moving");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (carPresentYPosition == 0) {
                        //break;
                        carPresentYPosition = 950;
                    } else {
                        carPresentYPosition += y - 1;
                        carProperties.setBounds(100, carPresentYPosition, 25, 15);
                        jp.validate();
                        jp.repaint();
                    }
                }
            }
        }).start();

    }

    public void stopCondition() {
        run();
        car.accelerate();
    }

    public void threshouldChecking() {
        car.accelerate();
    }
}
