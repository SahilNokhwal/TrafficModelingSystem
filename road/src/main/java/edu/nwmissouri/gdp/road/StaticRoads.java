package edu.nwmissouri.gdp.road;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * @author Sahil Nokhwal
 * SID: S525352
 */
public class StaticRoads {

	private JFrame mainFrame;
	
	private JPanel panelButtom;
	
	private JPanel draggableFourWayPanel;
	private JPanel draggableTwoWayPanel;
	private JPanel draggableRoundAboutPanel;
	
	
	private static int frameButtomPanelWidth;
	private static int frameButtomPanelHeight;
	
	
	private static Color draggablePanelColor;
	private static Color lineColor; 
	
	
	public StaticRoads() {
		prepareGUI();
	}
	
	
	private void prepareGUI() {
		mainFrame = new JFrame("Traffic Modeling System");
		
		mainFrame.setSize(frameButtomPanelWidth, frameButtomPanelHeight);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panelButtom = new JPanel();
		panelButtom.setLayout(null);
		panelButtom.setBackground(Color.white);

		panelButtom.setBounds(0, 0, frameButtomPanelWidth, frameButtomPanelHeight);
		
		 draggableFourWayPanel = new JPanel(null){
		    protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        g.setColor(lineColor);
		        g.drawLine(125, 0, 125, 250);
		        g.drawLine(0, 125, 250, 125);
		       
		    }};
		    
		 draggableTwoWayPanel = new JPanel(null){
		    protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        g.setColor(lineColor);
		        g.drawLine(0, 125, 250, 125);
		        g.drawLine(125, 0, 125, 250);
		    }};
		 draggableRoundAboutPanel = new JPanel(null){
		    protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        g.setColor(lineColor);
		        g.drawLine(0, 125, 250, 125);
		        g.drawLine(125, 0, 125, 250);
		        g.fillOval(100, 100, 50, 50);  
		    }};
		
		
		draggableFourWayPanel.setBackground(draggablePanelColor);
		draggableTwoWayPanel.setBackground(draggablePanelColor);
		draggableRoundAboutPanel.setBackground(draggablePanelColor);
		
		
		
		draggableFourWayPanel.setBounds(100, 300, 300, 250);
		draggableTwoWayPanel.setBounds(350, 300, 250, 250);
		draggableRoundAboutPanel.setBounds(600, 300, 250, 250);
		
		
		JButton b10 = new JButton("Stop");
		JButton b20 = new JButton("Stop");
		JButton b30 = new JButton("Stop");
		JButton b40 = new JButton("Stop");

		
		b10.setEnabled(false);
		b20.setEnabled(false);
		b30.setEnabled(false);
		b40.setEnabled(false);
		
		b10.setBounds(0, 0, 95, 95);
		b20.setBounds(0, 175,75, 75);
		b30.setBounds(175, 0,75, 75);
		b40.setBounds(175, 175,75, 75);
		
		
		draggableFourWayPanel.add(b10);
		draggableFourWayPanel.add(b20);
		draggableFourWayPanel.add(b30);
		draggableFourWayPanel.add(b40);
		
		
		
		JButton b11 = new JButton("Stop");
		JButton b21 = new JButton("");
		JButton b31 = new JButton("");
		JButton b41 = new JButton("Stop");
		
		b11.setEnabled(false);
		b21.setEnabled(false);
		b31.setEnabled(false);
		b41.setEnabled(false);
		
		
		b11.setBounds(0, 0, 75, 75);
		b21.setBounds(0, 175,75, 75);
		b31.setBounds(175, 0,75, 75);
		b41.setBounds(175, 175,75, 75);
		
		draggableTwoWayPanel.add(b11);
		draggableTwoWayPanel.add(b21);
		draggableTwoWayPanel.add(b31);
		draggableTwoWayPanel.add(b41);
		
		
		
		
		
		JButton b12 = new JButton("");
		JButton b22 = new JButton("");
		JButton b32 = new JButton("");
		JButton b42 = new JButton("");
		JButton b52 = new JButton("");
		
		b12.setEnabled(false);
		b22.setEnabled(false);
		b32.setEnabled(false);
		b42.setEnabled(false);
		
		
		b12.setBounds(0, 0, 75, 75);
		b22.setBounds(0, 175,75, 75);
		b32.setBounds(175, 0,75, 75);
		b42.setBounds(175, 175,75, 75);
		
		
	
		draggableRoundAboutPanel.add(b12);
		draggableRoundAboutPanel.add(b22);
		draggableRoundAboutPanel.add(b32);
		draggableRoundAboutPanel.add(b42);
		draggableRoundAboutPanel.add(b52);
	
		
		
		
		panelButtom.add(draggableFourWayPanel);
		panelButtom.add(draggableTwoWayPanel);
		panelButtom.add(draggableRoundAboutPanel);
		
		
		mainFrame.add(panelButtom);

		mainFrame.setVisible(true);

		
	}
	
	private static void sizeCalculator(){
		frameButtomPanelWidth = 1300;
		frameButtomPanelHeight = 1300;
		draggablePanelColor = new Color(220,220,220);
		lineColor = new Color(204,204,0);
	}
	
	
	
	
	public static void main(String[] args) {
		sizeCalculator();
		StaticRoads secondScreen = new StaticRoads();

	}

}
