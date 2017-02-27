package edu.nwmissouri.gdp.road;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
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
public class DraggableTwoWayPanel extends JPanel implements DragGestureListener, DragSourceListener {

	private DraggableTwoWayPanel draggableTwoWayPanel;
	private static Color pathColor;
	int draggablePanelWidth;
	int draggablePanelHeight;
	Color draggablePanelColor;
	
	DragSource dragSource;

		public DraggableTwoWayPanel(String text) {
			super(null);
			//setText(text);

			dragSource = new DragSource();

			dragSource.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY_OR_MOVE, this);

		}

		public DraggableTwoWayPanel() {
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

		
		
		
		
		public JPanel getDraggableTwoWayPanel() {
		draggableTwoWayPanel = new DraggableTwoWayPanel() {
			
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.setColor(pathColor);
					g.drawLine(0, 125, 250, 125);
					g.drawLine(125, 0, 125, 250);
				}
			};

		draggableTwoWayPanel.setBackground(draggablePanelColor);
		draggableTwoWayPanel.setBounds(150, 15, draggablePanelWidth, draggablePanelHeight);
		
		JButton b11 = new JButton("o");
		JButton b21 = new JButton("");
		JButton b31 = new JButton("");
		JButton b41 = new JButton("o");

		b11.setBounds(0, 0, 40, 40);
		b21.setBounds(0, 90, 40, 40);
		b31.setBounds(90, 0, 40, 40);
		b41.setBounds(90, 90, 40, 40);
		
		b11.setEnabled(false);
		b21.setEnabled(false);
		b31.setEnabled(false);
		b41.setEnabled(false);

		draggableTwoWayPanel.add(b11);
		draggableTwoWayPanel.add(b21);
		draggableTwoWayPanel.add(b31);
		draggableTwoWayPanel.add(b41);
		
		return draggableTwoWayPanel;
		
	}
		
		
		private void valueSetter(){
			pathColor =  Color.black;
			draggablePanelWidth = 130;
			draggablePanelHeight = 130;
			draggablePanelColor = new Color(220, 220, 220);
		}
}

