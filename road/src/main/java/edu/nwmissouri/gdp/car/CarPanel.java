package edu.nwmissouri.gdp.car;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CarPanel extends JPanel {

	private CarPanel car;
	private static final int INCREMENT = 1;
	private int carInitialXPosition = 0;
	private int carInitialYPosition = 270;
	private static final int carHorizontalPath = 900;
	private static final int carVerticalPath = 100;
	private static enum carCordinates{
		
	}
	
	
	
	
	private int carWidth = 30;
	private int carHeight = 15;

	public CarPanel() {
		super(null);
	}

	public JPanel getCar() {
		car = new CarPanel();

		JLabel label = new JLabel("50" + "\u2192");  //21B4
		label.setBounds(0, 0, carWidth, carHeight);
		System.out.println("Inside getCar");
		car.setBackground(Color.white);
		car.setBounds(carInitialXPosition, carInitialYPosition, carWidth, carHeight);
		car.add(label);
		return car;
	}

	public void move()  {
		
		final JPanel jp = this;
		new Thread(new Runnable() {
			public void run() {

				while (true) {
					try {
						Thread.sleep(5);
						System.out.println("Car is moving");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					if(carInitialXPosition==carHorizontalPath){
						//break;
						carInitialXPosition=0;
					}
					else{
					car.setBounds(carInitialXPosition += INCREMENT, carInitialYPosition, carWidth, carHeight);
					jp.validate();
					jp.repaint();
					}
				}
			}
		}).start();

	}
	
	
	
	
	public void moveLeft() throws InterruptedException {
		
		
		final JPanel jp = this;
		new Thread(new Runnable() {
			public void run() {
				
				int x = 950;
				while (true) {
					try {
						Thread.sleep(50);
						System.out.println("Car is moving");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					if(x==0){
						//break;
						x=950;
					}
					else{
					car.setBounds(x -= 1, 215, 25, 15);
					jp.validate();
					jp.repaint();
					}
				}
			}
		}).start();

	}
}