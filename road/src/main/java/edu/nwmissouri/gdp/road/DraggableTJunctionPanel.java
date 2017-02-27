package edu.nwmissouri.gdp.road;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * @author Sahil Nokhwal
 * SID: S525352
 */
public class DraggableTJunctionPanel extends JPanel implements DragGestureListener, DragSourceListener {

	private DraggableTJunctionPanel draggableTJunctionPanel;
	private static Color pathColor=  Color.black;
	int draggablePanelWidth = 130;
	int draggablePanelHeight = 130;
	Color draggablePanelColor = new Color(220, 220, 220);
	
		DragSource dragSource;

		public DraggableTJunctionPanel(String text) {
			super(null);
			//setText(text);

			dragSource = new DragSource();

			dragSource.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY_OR_MOVE, this);

		}

		public DraggableTJunctionPanel() {
			// TODO Auto-generated constructor stub
		}

		public void dragGestureRecognized(DragGestureEvent evt) {

			Transferable transferable = new StringSelection(null);//getText());

			dragSource.startDrag(evt, DragSource.DefaultCopyDrop, transferable, this);

		}

		public void dragEnter(DragSourceDragEvent evt) {

			// Called when the user is dragging this drag source and enters the
			// drop target

			System.out.println("Drag enter");

		}

		public void dragOver(DragSourceDragEvent evt) {

			// Called when the user is dragging this drag source and moves over
			// the drop target

			System.out.println("Drag over");

		}

		public void dragExit(DragSourceEvent evt) {

			// Called when the user is dragging this drag source and leaves the
			// drop target

			System.out.println("Drag exit");

		}

		public void dropActionChanged(DragSourceDragEvent evt) {

			// Called when the user changes the drag action between copy or move

			System.out.println("Drag action changed");

		}

		public void dragDropEnd(DragSourceDropEvent evt) {

			// Called when the user finishes or cancels the drag operation

			System.out.println("Drag action End");

		}

		
		
		
		
		public JPanel getDraggableTJunctionPanel() {
		
		draggableTJunctionPanel = new DraggableTJunctionPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(pathColor);
//				g.drawLine(0, Math.toIntExact((Math.round(39.58*draggablePanelWidth/100))), Math.toIntExact((Math.round(33.87*draggablePanelHeight/100))), Math.toIntExact((Math.round(39.58*draggablePanelWidth/100))));
//				g.drawLine(0, Math.toIntExact((Math.round(60.41*draggablePanelWidth/100))), Math.toIntExact((Math.round(33.87*draggablePanelHeight/100))), Math.toIntExact((Math.round(60.41*draggablePanelWidth/100))));
//				g.drawLine(Math.toIntExact((Math.round(66.12*draggablePanelWidth/100))), Math.toIntExact((Math.round(60.41*draggablePanelWidth/100))), Math.toIntExact((Math.round(33.87*draggablePanelHeight/100))), Math.toIntExact((Math.round(60.41*draggablePanelWidth/100))));
//				g.drawLine(0, Math.toIntExact((Math.round(39.58*draggablePanelWidth/100))), Math.toIntExact((Math.round(33.87*draggablePanelHeight/100))), Math.toIntExact((Math.round(39.58*draggablePanelWidth/100))));
//				
				
				
		//		g.drawLine(0, 125, 250, 125);

			}
		};

		draggableTJunctionPanel.setBackground(draggablePanelColor);
		draggableTJunctionPanel.setBounds(150, 155, draggablePanelWidth, draggablePanelHeight);
		

		JButton b13 = new JButton("");
		JButton b23 = new JButton("");

		b13.setBounds(0, 0, 30, 90);
		b23.setBounds(100, 0, 30, 90);
		
		b13.setEnabled(false);
		b23.setEnabled(false);
		

		draggableTJunctionPanel.add(b13);
		draggableTJunctionPanel.add(b23);

		
		return draggableTJunctionPanel;
		
	}
}

