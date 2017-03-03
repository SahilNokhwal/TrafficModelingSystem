package edu.nwmissouri.gdp.road;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/*
 * @author Sahil Nokhwal
 * SID: S525352
 */
public class InputPanel extends JPanel{

	private InputPanel inputPanel ;
	private Color inputPanelColor = new Color( 95, 158, 160);
	
	
	public InputPanel() {
		super(null);

	}
	
	
	
	public JPanel getInputPanel() {
		
		inputPanel = new InputPanel();
		
		inputPanel.setBackground(inputPanelColor);
		inputPanel.setBorder(BorderFactory.createTitledBorder("Input area"));
		inputPanel.setBounds(1050, 480, 300, 200);

	
	return inputPanel;
	
}
}