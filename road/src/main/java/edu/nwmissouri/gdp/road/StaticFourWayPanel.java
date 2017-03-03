package edu.nwmissouri.gdp.road;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * @author Sahil Nokhwal
 * SID: S525352
 */

//Static Four way road component
public class StaticFourWayPanel extends JPanel{

	public static Color lineColor = Color.yellow; 
	private StaticFourWayPanel staticFourWayPanel;

	
	
	//Pass null to the JPanel constructor  
	public StaticFourWayPanel() {
		super(null);

	}
	
	
	
	// Returns a JPanel as static road component
	public JPanel getStaticFourWayPanel() {
		
	
	staticFourWayPanel	= new StaticFourWayPanel() {
		
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(lineColor);
			g.drawLine(150, 0, 150, 480);
			g.drawLine(155, 0, 155, 480);
			g.drawLine(0, 235, 310, 235);
			g.drawLine(0, 240, 310, 240);
			
		}
	};
	
	staticFourWayPanel.setBackground(Color.black);//draggablePanelColor);
	
	

	staticFourWayPanel.setBounds(5, 15, 310, 480);
	
	

	JButton bs10 = new JButton("Stop");
	JButton bs20 = new JButton("Stop");
	JButton bs30 = new JButton("Stop");
	JButton bs40 = new JButton("Stop");

	bs10.setEnabled(false);
	bs20.setEnabled(false);
	bs30.setEnabled(false);
	bs40.setEnabled(false);

	bs10.setBounds(0, 0, 105, 190);
	bs20.setBounds(0, 290, 105, 190);
	bs30.setBounds(205, 0, 105, 190);
	bs40.setBounds(205, 290, 105, 190);

	staticFourWayPanel.add(bs10);
	staticFourWayPanel.add(bs20);
	staticFourWayPanel.add(bs30);
	staticFourWayPanel.add(bs40);
	
	staticFourWayPanel.setOpaque(false);
	
	return staticFourWayPanel;
	}
}
