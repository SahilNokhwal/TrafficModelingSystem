package edu.nwmissouri.gdp.road;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;
/*
 * @author Sahil Nokhwal
 * SID: S525352
 */
public class StaticRoundAboutPanel extends JPanel{

	public static Color lineColor = Color.yellow; 
	private StaticRoundAboutPanel staticRoundAboutPanel ;

	public StaticRoundAboutPanel() {
		super(null);

	}
	
	public JPanel getStaticRoundAboutPanel() {

		staticRoundAboutPanel = new StaticRoundAboutPanel() {
			
			
			
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(lineColor);
				g.drawLine(150, 0, 150, 480);
				g.drawLine(155, 0, 155, 480);
				
				g.drawLine(0, 235, 310, 235);
				g.drawLine(0, 240, 310, 240);
				
				g.fillOval(125, 210, 50, 50);
			}
		};
		
		staticRoundAboutPanel.setBackground(Color.black);//draggablePanelColor);
		
		staticRoundAboutPanel.setBounds(625, 15, 310, 480);
		
		
		
		JButton bs12 = new JButton("");
		JButton bs22 = new JButton("");
		JButton bs32 = new JButton("");
		JButton bs42 = new JButton("");
		JButton bs52 = new JButton("");

		bs12.setEnabled(false);
		bs22.setEnabled(false);
		bs32.setEnabled(false);
		bs42.setEnabled(false);

		bs12.setBounds(0, 0, 105, 190);
		bs22.setBounds(0, 290, 105, 190);
		bs32.setBounds(205, 0, 105, 190);
		bs42.setBounds(205, 290, 105, 190);
		

		staticRoundAboutPanel.add(bs12);
		staticRoundAboutPanel.add(bs22);
		staticRoundAboutPanel.add(bs32);
		staticRoundAboutPanel.add(bs42);
		staticRoundAboutPanel.add(bs52);

		staticRoundAboutPanel.setOpaque(false);
		
		return staticRoundAboutPanel;

	}
	
}
