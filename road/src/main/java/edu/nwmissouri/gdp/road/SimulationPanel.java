package edu.nwmissouri.gdp.road;

import java.awt.Color;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import edu.nwmissouri.gdp.car.Car;

public class SimulationPanel extends JPanel{

	private List<Car> cars;
	private SimulationPanel simulationPanel ;
	private Color simulationPanelColor = Color.black;//new Color(95, 158, 160);
	static Car car;
	

	public SimulationPanel() {
		super(null);
		
		
	}
	public SimulationPanel(Object obj) {
		super(null);

	}
	
	
	public JPanel getSimulationPanel() {
		
		simulationPanel = new SimulationPanel();
		simulationPanel.setBackground(simulationPanelColor);
		simulationPanel.setBorder(BorderFactory.createTitledBorder("Simulation area"));
		simulationPanel.setBounds(50, 80, 950, 500);

		
	return simulationPanel;
	
}
	
	
//	public void car(){
//		 car = new Car(0, 270);
//		Timer timer = new Timer(50, new ActionListener(){
//            public void actionPerformed(ActionEvent e) {
//            	System.out.println("Car moving code");
//              //  for (Car car : cars) {
//                	System.out.println("Inside for loop");
//                    car.move();//
//                    repaint();
//               // }
//            }
//        });
//        timer.start();
//	}
	
	
	
	//Add cars on the simulation panel
//	@Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        System.out.println("Hello");
//        
//       
//        car.drawCar(g);
//        
////        for (Car car : cars) {
////        	
////            car.drawCar(g);
////        }
//    }
//	
//	
//	
//	
//	
	
	
	
	
	
}