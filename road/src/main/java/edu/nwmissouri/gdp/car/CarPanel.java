package edu.nwmissouri.gdp.car;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * @author Sahil Nokhwal
 * SID: S525352
 */
public class CarPanel extends JPanel {

	private CarPanel car;
	private static  int INCREMENT;
	private int carInitialXPosition;
	private int carInitialYPosition;
	private static  int carHorizontalPath;
	private static  int carVerticalPath;
	private int carSpeed=120;
	private int sleepValue = 1000/carSpeed; 
	
	private int carWidth;
	private int carHeight;

	public CarPanel() {
		super(null);
		valueSetter();
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

	
	
	public void collide(){
		
	}
	public void move()  {
		
		final JPanel jp = this;
		new Thread(new Runnable() {
			public void run() {

				while (true) {
					try {
						Thread.sleep(sleepValue);
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
						Thread.sleep(sleepValue);
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
	
	
	private void valueSetter(){
		carWidth = 30;
		carHeight = 15;
		
		INCREMENT = 1;
		
		carInitialXPosition = 0;
		carInitialYPosition = 270;
		carHorizontalPath = 900;
		carVerticalPath = 100;

	}
}