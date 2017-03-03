package edu.nwmissouri.gdp.road;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * @author Sahil Nokhwal
 * SID: S525352
 */
public class DraggableComponentPanel extends JPanel {

	private DraggableComponentPanel draggableComponentPanel;
	int frameButtomPanelWidth = 1366;
	int frameButtomPanelHeight = 768;
	private Color panelRightColor = new Color(95, 158, 160);

	public DraggableComponentPanel() {
		super(null);

	}

	public JPanel getDraggableComponentPanel() {
		draggableComponentPanel = new DraggableComponentPanel();

		draggableComponentPanel.setBackground(panelRightColor);
		draggableComponentPanel.setBorder(BorderFactory.createTitledBorder("Road components"));
		draggableComponentPanel.setBounds(1050, 20, 300, 430);

		return draggableComponentPanel;

	}

}
