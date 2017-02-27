package edu.nwmissouri.gdp.car;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import edu.nwmissouri.gdp.road.SimulationPanel;
/*
 * @author Sahil Nokhwal
 * SID: S525352
 */
public class DrawCar extends JPanel{
    private static final int D_W = 225;
    private static final int D_H = 315;
    
    
    int carStartingXPosition = 0;
    int carStartingYPosition = 122;
    
   private List<Car> cars;
    

	public DrawCar() {
		super(null);
		
        cars = new ArrayList<Car>();
        cars.add(new Car(0, 0));
     //   cars.add(new Car(252, 310));
        
        Timer timer = new Timer(50, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	System.out.println("Car moving code");
                for (Car car : cars) {
                	System.out.println("Inside for loop");
                    car.move();//
                    repaint();
                }
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car car : cars) {
        	
            car.drawCar(g);
        }
    }

//    @Override
//    public Dimension getPreferredSize() {
//        return new Dimension(D_W, D_H);
//    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new DrawCar());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                /* frame.pack();
                frame.setLocationRelativeTo(null);*/
                frame.setVisible(true);
            }
        });
        System.out.println("-------Car generation completed----");
    }
    
    public List<Car> getCars() {
    	return cars;
    }
}
