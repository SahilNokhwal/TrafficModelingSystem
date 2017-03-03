package edu.nwmissouri.gdp.road;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * @author Sahil Nokhwal
 * SID: S525352
 */
public class ButtomPanel extends JPanel{

	private ButtomPanel buttomPanel ;
	int frameButtomPanelWidth = 1366;
	int frameButtomPanelHeight = 768;
	Color panelButtomColor = new Color(240,248,255);
	
	public ButtomPanel() {
		super(null);

	}
	
	
	
	public JPanel getButtomPanel() {

		buttomPanel = new ButtomPanel();
			
			
			
		
		buttomPanel.setLayout(null);
		buttomPanel.setBackground(panelButtomColor);

		
		buttomPanel.setBounds(0, 0, frameButtomPanelWidth, frameButtomPanelHeight);
		
		
		
		return buttomPanel;

	}
	
}
