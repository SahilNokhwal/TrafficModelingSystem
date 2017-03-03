package road;

import Milestone.GenerateCar;
import edu.nwmissouri.gdp.car.Car;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Car.CarPanel;
import Car.DrawCar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

public class SecondScreen {

	private JFrame mainFrame;
	private static int frameButtomPanelWidth;
	private static int frameButtomPanelHeight;
	
	private static Color draggablePanelColor;

	private static Color lineColor;
	private static Color panelRightColor;
	private static Color panelButtomColor;
       public static  JPanel simulationPanel=null;

	

	private void prepareGUI() throws InterruptedException {
		mainFrame = new JFrame("Traffic Modeling System");

		mainFrame.setSize(frameButtomPanelWidth, frameButtomPanelHeight);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		
		JLabel title = new JLabel("Traffic Simulator");
		title.setBounds(300,30,500,50);
		
		
		//All panels on the JFrame
		JPanel buttomPanel = new ButtomPanel().getButtomPanel();
		
		 simulationPanel = new SimulationPanel().getSimulationPanel();
		JPanel draggableComponentPanel = new DraggableComponentPanel().getDraggableComponentPanel();
		JPanel inputPanel = new InputPanel().getInputPanel();
		

		
		
	//Static road code start here
		
		JPanel staticRoundAboutPanel = new StaticRoundAboutPanel().getStaticRoundAboutPanel(); 
		JPanel staticFourWayPanel = new StaticFourWayPanel().getStaticFourWayPanel();
		JPanel StaticFourWaySignalPanel = new StaticFourWaySignalPanel().getStaticFourWaySignalPanel();
		
	// End static code (Will delete)
		
		
		simulationPanel.add(staticFourWayPanel);
		System.out.println("Simualtion panel added");
		simulationPanel.add(StaticFourWaySignalPanel);
		System.out.println("Static two way panel added");
		simulationPanel.add(staticRoundAboutPanel);
		System.out.println("Static roundabout panel added");

		
		
//     	CarPanel car = new CarPanel();
//		
// 		simulationPanel.add(car.getCar("rightwards"));
// 		car.move();
// 		
// 		CarPanel car3 = new CarPanel();
// 		simulationPanel.add(car3.getCar("leftwards"));
// 		car3.moveLeft();
// 		
// 		CarPanel car4 = new CarPanel();
// 		simulationPanel.add(car4.getCar());
// 		car4.moveDown();


    //code to create cars using timer 
    
            ActionListener left = new ActionListener(){
                int count = 0;
            public void actionPerformed(ActionEvent e) {
                if (count < 5){
                count++;    
              
              
                  CarPanel car = new CarPanel();
                  simulationPanel.add(car.getCar("leftwards"));
                    car.moveLeft();
                } 
            }
            };
            
            ActionListener right = new ActionListener(){
                int count = 0;
            public void actionPerformed(ActionEvent e) {
                if (count < 5){
                count++;
                CarPanel car = new CarPanel();
                simulationPanel.add(car.getCar("rightwards"));
                car.move();
                } 
            }
            };
       
            Timer timer = new Timer(2000, right);     
            Timer timer1 = new Timer(2000, left);
            timer.start();
            timer1.start();
//        
//        
//        
//        
//        
//        
//        //code to stop timer
//        long start = System.currentTimeMillis();
//        long end = start + 10*1000; // 10 seconds * 1000 ms/sec
//        //10 sec create 5 cars as timer will take 2 seonds for each car
//        if(System.currentTimeMillis() == end)
//        {
//            timer.stop();
//        }
 		
 		
//        Timer timer;
//
//  int counter = 0;
//
//    ActionListener a = new ActionListener() {
//      public void actionPerformed(ActionEvent e) {
//        //System.out.println("Counter = " + counter);
//
//        if (++counter > 10) {
//          timer.stop();
//          System.exit(0);
//        }
//      }
//    };
//
//    timer = new Timer(300, a);
//    timer.start();
//
//    pack();
//    setVisible(true);
 		
 		
 		
 		
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
