package edu.nwmissouri.gdp.road;

public class App {

	
	//main method as starting point of the application
	public static void main(String[] args) {
		SecondScreen secondScreen = new SecondScreen();

		SecondScreen.valuesSetter();
		try {
			secondScreen.prepareGUI();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
