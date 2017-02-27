package edu.nwmissouri.gdp.road;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import edu.nwmissouri.gdp.car.CarPanel;
import edu.nwmissouri.gdp.car.DrawCar;

/*
 * @author Sahil Nokhwal
 * SID: S525352
 */
public class SecondScreen {

	private JFrame mainFrame;
	private static int frameButtomPanelWidth;
	private static int frameButtomPanelHeight;
	
	private static Color draggablePanelColor;

	private static Color lineColor;
	private static Color panelRightColor;
	private static Color panelButtomColor;

	

	private void prepareGUI() throws InterruptedException {
		mainFrame = new JFrame("Traffic Modeling System");

		mainFrame.setSize(frameButtomPanelWidth, frameButtomPanelHeight);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		
		JLabel title = new JLabel("Traffic Simulator");
		title.setBounds(300,30,500,50);
		
		
		//All panels on the JFrame
		JPanel buttomPanel = new ButtomPanel().getButtomPanel();
		
		JPanel simulationPanel = new SimulationPanel().getSimulationPanel();
		JPanel draggableComponentPanel = new DraggableComponentPanel().getDraggableComponentPanel();
		JPanel inputPanel = new InputPanel().getInputPanel();
		

		
		
	//Static road code start here
		
		JPanel staticRoundAboutPanel = new StaticRoundAboutPanel().getStaticRoundAboutPanel(); 
		JPanel staticFourWayPanel = new StaticFourWayPanel().getStaticFourWayPanel();
		JPanel staticTwoWayPanel = new StaticTwoWayPanel().getStaticTwoWayPanel();
		
	// End static code (Will delete)
		
		
		simulationPanel.add(staticFourWayPanel);
		System.out.println("Simualtion panel added");
		simulationPanel.add(staticTwoWayPanel);
		System.out.println("Static two way panel added");
		simulationPanel.add(staticRoundAboutPanel);
		System.out.println("Static roundabout panel added");

		
		
//		 SwingUtilities.invokeLater(new Runnable() {
//	            public void run() {
//
//	            }
//	        });
		
     	CarPanel car = new CarPanel();
		
 		simulationPanel.add(car.getCar());
 		car.move();
 		
 		CarPanel car1 = new CarPanel();
 		simulationPanel.add(car1.getCar());
 		car1.move();
		
 		
 		CarPanel car2 = new CarPanel();
 		simulationPanel.add(car2.getCar());
 		car2.move();
 		
 		CarPanel car3 = new CarPanel();
 		simulationPanel.add(car3.getCar());
 		car3.moveLeft();
 		
 		CarPanel car4 = new CarPanel();
 		simulationPanel.add(car4.getCar());
 		car4.moveLeft();
 		
 		
 		
 		
 		
 		
		//Car generation
		System.out.println("----Loaded all static roads components-----");
		
		
		
		//Draggable road components code
		JPanel draggableFourWayPanel = new DraggableFourWayPanel().getDraggableFourWayPanel();
		JPanel draggableTwoWayPanel = new DraggableTwoWayPanel().getDraggableTwoWayPanel();
		JPanel draggableRoundAboutPanel = new DraggableRoundAboutPanel().getDraggableRoundAboutPanel();
		JPanel draggableSignalPanel = new DraggableSignalPanel().getDraggableSignalPanel();
		JPanel draggableTJunctionPanel = new DraggableTJunctionPanel().getDraggableTJunctionPanel();
		
		
		System.out.println("----Loaded all draggable roads components-----");

		draggableComponentPanel.add(draggableFourWayPanel);
		draggableComponentPanel.add(draggableTwoWayPanel);
		draggableComponentPanel.add(draggableRoundAboutPanel);
		draggableComponentPanel.add(draggableTJunctionPanel);
		draggableComponentPanel.add(draggableSignalPanel);

		
		
		//Run button
		
		JButton runButton = new JButton("Run");
		runButton.setBounds(500, 600, 100, 30);

		buttomPanel.add(draggableComponentPanel);
		buttomPanel.add(simulationPanel);
		buttomPanel.add(runButton);
		buttomPanel.add(inputPanel);
		buttomPanel.add(title);
		
		mainFrame.add(buttomPanel);

		mainFrame.setVisible(true);

	}

	private static void valuesSetter() {
		frameButtomPanelWidth = 1366;
		frameButtomPanelHeight = 768;

		draggablePanelColor = new Color(220, 220, 220);

		lineColor = new Color(204, 204, 0);
		panelRightColor = new Color( 95, 158, 160);
		panelButtomColor = new Color(240,248,255);
	}

	public static void main(String[] args) throws InterruptedException {
		
		SecondScreen secondScreen = new SecondScreen();
		
		valuesSetter();
		secondScreen.prepareGUI();
		
	}

}
