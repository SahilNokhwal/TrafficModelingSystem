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

//Draggable Round about class
public class DraggableRoundAboutPanel extends JPanel implements DragGestureListener, DragSourceListener {

	private DraggableRoundAboutPanel draggableRoundAboutPanel;
	private static Color pathColor = Color.black;
	int draggablePanelWidth = 130;
	int draggablePanelHeight = 130;
	Color draggablePanelColor = new Color(220, 220, 220);

	DragSource dragSource;

	public DraggableRoundAboutPanel(String text) {
		super(null);
		// setText(text);

		dragSource = new DragSource();

		dragSource.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY_OR_MOVE, this);

	}

	public DraggableRoundAboutPanel() {
		// TODO Auto-generated constructor stub
	}

	public void dragGestureRecognized(DragGestureEvent evt) {

		Transferable transferable = new StringSelection(null);// getText());

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

	// Returns a JPanel as draggable road component
	public JPanel getDraggableRoundAboutPanel() {

		draggableRoundAboutPanel = new DraggableRoundAboutPanel() {

			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(pathColor);
				g.drawLine(0, 125, 250, 125);
				g.drawLine(125, 0, 125, 250);
				g.fillOval(100, 100, 50, 50);
			}
		};

		draggableRoundAboutPanel.setBackground(draggablePanelColor);
		draggableRoundAboutPanel.setBounds(10, 155, draggablePanelWidth, draggablePanelHeight);

		JButton b12 = new JButton("");
		JButton b22 = new JButton("");
		JButton b32 = new JButton("");
		JButton b42 = new JButton("");
		JButton b52 = new JButton("");

		b12.setBounds(0, 0, 40, 40);
		b22.setBounds(0, 90, 40, 40);
		b32.setBounds(90, 0, 40, 40);
		b42.setBounds(90, 90, 40, 40);
		b52.setBounds(60, 60, 15, 15);

		b12.setEnabled(false);
		b22.setEnabled(false);
		b32.setEnabled(false);
		b42.setEnabled(false);

		draggableRoundAboutPanel.add(b12);
		draggableRoundAboutPanel.add(b22);
		draggableRoundAboutPanel.add(b32);
		draggableRoundAboutPanel.add(b42);
		draggableRoundAboutPanel.add(b52);

		return draggableRoundAboutPanel;

	}
}
