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
public class DraggableSignalPanel extends JPanel implements DragGestureListener, DragSourceListener {

	private DraggableSignalPanel draggableSignalPanel;
	private static Color pathColor=  Color.black;
	int draggablePanelWidth = 130;
	int draggablePanelHeight = 130;
	Color draggablePanelColor = new Color(220, 220, 220);
	
		DragSource dragSource;

		public DraggableSignalPanel(String text) {
			super(null);
			//setText(text);

			dragSource = new DragSource();

			dragSource.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY_OR_MOVE, this);

		}

		public DraggableSignalPanel() {
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

		
		
		
		
		public JPanel getDraggableSignalPanel() {
		
		draggableSignalPanel = new DraggableSignalPanel() {
			
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.setColor(pathColor);
					g.drawLine(0, 125, 250, 125);
					g.drawLine(125, 0, 125, 250);
					g.fillOval(100, 100, 50, 50);
				}
			};


		draggableSignalPanel.setBackground(draggablePanelColor);
		draggableSignalPanel.setBounds(10, 295, draggablePanelWidth, draggablePanelHeight);
		
		JButton b10 = new JButton("o");
		JButton b20 = new JButton("");
		JButton b30 = new JButton("");
		JButton b40 = new JButton("o");

		b10.setBounds(0, 0, 40, 40);
		b20.setBounds(0, 90, 40, 40);
		b30.setBounds(90, 0, 40, 40);
		b40.setBounds(90, 90, 40, 40);
		
		b10.setEnabled(false);
		b20.setEnabled(false);
		b30.setEnabled(false);
		b40.setEnabled(false);
		
		draggableSignalPanel.add(b10);
		draggableSignalPanel.add(b20);
		draggableSignalPanel.add(b30);
		draggableSignalPanel.add(b40);
		
		
		return draggableSignalPanel;
		
	}
}

