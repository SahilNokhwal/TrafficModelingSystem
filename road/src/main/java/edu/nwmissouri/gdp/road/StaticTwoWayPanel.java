package edu.nwmissouri.gdp.road;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

public class StaticTwoWayPanel extends JPanel{

	public static Color lineColor = Color.yellow; 
	private StaticTwoWayPanel staticTwoWayPanel;

	
	public StaticTwoWayPanel() {
		super(null);

	}
	
	
	public JPanel getStaticTwoWayPanel() {
		
	
	staticTwoWayPanel	= new StaticTwoWayPanel() {
		
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(lineColor);
				g.drawLine(150, 0, 150, 480);
				g.drawLine(155, 0, 155, 480);
				
				g.drawLine(0, 235, 310, 235);
				g.drawLine(0, 240, 310, 240);
			}
		};
		
		

		staticTwoWayPanel.setBackground(Color.black);//draggablePanelColor);
		staticTwoWayPanel.setBounds(315, 15, 310, 480);
		
		JButton bs11 = new JButton("Stop");
		JButton bs21 = new JButton("");
		JButton bs31 = new JButton("");
		JButton bs41 = new JButton("Stop");

		bs11.setEnabled(false);
		bs21.setEnabled(false);
		bs31.setEnabled(false);
		bs41.setEnabled(false);

		bs11.setBounds(0, 0, 105, 190);
		bs21.setBounds(0, 290, 105, 190);
		bs31.setBounds(205, 0, 105, 190);
		bs41.setBounds(205, 290, 105, 190);
		
		staticTwoWayPanel.add(bs11);
		staticTwoWayPanel.add(bs21);
		staticTwoWayPanel.add(bs31);
		staticTwoWayPanel.add(bs41);

	
		staticTwoWayPanel.setOpaque(false);
		
	return staticTwoWayPanel;
}
}