package edu.nwmissouri.gdp.road;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * @author Sahil Nokhwal
 * SID: S525352
 */
public class FourWayTest {

	private static JFrame mainFrame;
	private int frameWidth = 1300;
	private int frameHeight = 1300;
	
	
	static FourWayTest fourWay;
	
	 
     

	public static void main(String[] args) {

		fourWay =  new FourWayTest();

		mainFrame = new JFrame("Traffic Modeling System");

		
		mainFrame.setSize(fourWay.frameWidth, fourWay.frameHeight);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		JPanel panelRight = new JPanel(new GridLayout(3,2));
		panelRight.setBackground(Color.white);
		panelRight.setBorder(BorderFactory.createTitledBorder("Road components"));
		JPanel panelLeft = new JPanel(new GridLayout(1,3));
		panelLeft.setBackground(Color.white);
		
		
		
		JPanel panelFourWay = new JPanel();
		panelFourWay.setLayout(null);
		JPanel panelTwoWay = new JPanel();
		JPanel panelRoundAbout = new JPanel();
		JPanel panelTjunction = new JPanel();
		
		
		panelFourWay.setBackground(Color.cyan);
		panelTwoWay.setBackground(Color.green);
		panelRoundAbout.setBackground(Color.magenta);
		panelTjunction.setBackground(Color.ORANGE);
		

		JButton b1 = new JButton("");
		JButton b2 = new JButton("");
		JButton b3 = new JButton("");
		JButton b4 = new JButton("");
		
		panelFourWay.add(b1);
		panelFourWay.add(b2);
		panelFourWay.add(b3);
		panelFourWay.add(b4);
		
		
		Insets insets = panelFourWay.getInsets();
        Dimension size = b1.getPreferredSize();
        
        b1.setBounds(insets.left, insets.top, 30, 80);
       
        
        
        size = b2.getPreferredSize();
        b2.setBounds(insets.left, 161,
                     30, 80);
        
        size = b3.getPreferredSize();
        b3.setBounds(92, insets.top,
                     20, 80);
        
        size = b4.getPreferredSize();
        b4.setBounds(92, 161,
                     20, 80);
		
		
		panelTwoWay.add(new JLabel("Panel Two  Way"));
		panelRoundAbout.add(new JLabel("Panel Roundabout"));
		panelTjunction.add(new JLabel("Panel T junction"));
		
		
		panelRight.add(panelFourWay);
		panelRight.add(panelTwoWay);
		panelRight.add(panelRoundAbout);
		panelRight.add(panelTjunction);
		
		
		panelLeft.add(new JLabel("Panel Drag and Drop"));
		
        //fourWay.mainFrame.add(buttonPanel);
		mainFrame.add(panelLeft, BorderLayout.WEST);
		mainFrame.add(panelRight, BorderLayout.EAST);
		
		
		//mainFrame.pack();
		fourWay.mainFrame.setVisible(true);
	}

	
	
	
}

