/*
 * 
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
/**
 * 
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class PopMenuHandle implements ActionListener {
  private JPopupMenu popup;
  private JMenuItem popupItem1;
  private JMenuItem popupItem2;
  private JMenuItem popupItem3;
  
  private RoadDesigner parent;
 
  public PopMenuHandle(RoadDesigner parent, int x, int y) {
  	this.parent = parent;
 
    popup = new JPopupMenu();
      popupItem1 = new JMenuItem("Set as input cars");
      popupItem2 = new JMenuItem("PopupItem 2");
      popupItem3 = new JMenuItem("PopupItem 3");
      popupItem1.addActionListener(this);
      popupItem2.addActionListener(this);
      popupItem3.addActionListener(this);
      popup.add(popupItem1);
      popup.add(popupItem2);
      popup.add(popupItem3);
 
    // Aggiunge un MouseListener al componente che deve mostrare il menu
    MouseListener popupListener = new PopupListener();
    popup.show(parent,x, y);
   }
   class PopupListener extends MouseAdapter {
     public void mousePressed(MouseEvent e) {
       if (e.isPopupTrigger()) {
          popup.show(e.getComponent(),e.getX(), e.getY());
       }
     }
     public void mouseReleased(MouseEvent e) {
       if (e.isPopupTrigger()) {
         popup.show(e.getComponent(),e.getX(), e.getY());
       }
     }
    } 
	public void actionPerformed( ActionEvent event )
	{
		// Add action handling code here
		if (event.getSource() == popupItem1) 
		{
			parent.currentRoadAsStart();
		}
	}
}