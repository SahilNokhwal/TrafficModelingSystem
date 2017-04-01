/*
 * 
 *
 * TODO To change the template for this generated file go to Window -
 * Preferences - Java - Code Generation - Code and Comments
 */
package Utils.scale;

/**
 * 
 *
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Generation - Code and Comments
 */

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;

import javax.swing.JScrollBar;

public class sc {

  private class params {
    double xscale,yscale;
    double xmin,xmax;
    double ymin,ymax;
    double xmid,ymid;
    params()
	{
    	xscale = yscale = 0;
    	xmin = xmax = 0;
    	ymin = ymax = 0;
    	xmid = ymid = 0;
	}
}
  	static final int MAX_SCROLL = 1000;
	static final int SCROLL_OVERLAPPING = 12;
	private params original_params;
	private params current_params;
	private params previous_params;
	private int clientWidth;
	private int clientHeight;
	private boolean initialized = false;

	public sc() {
		clientWidth = 0;
		clientHeight = 0;
		original_params = new params();
		current_params = new params();
		previous_params = new params();
	}

	public sc(int clientWidth, int clientHeight) {
		this.clientWidth = clientWidth;
		this.clientHeight = clientHeight;
	}

	public void set_parameters(double xmn, double xmx, double ymn, double ymx,
			int xm, int ym) {
		int tempx, tempy;
		tempx = clientWidth - 2 * xm;
		tempy = clientHeight - 2 * ym;
		if (tempx < tempy) {
			if (xmx - xmn != 0)
				original_params.xscale = tempx / (xmx - xmn);
			else
				original_params.xscale = 1;
			if (ymx - ymn != 0)
				original_params.yscale = tempx / (ymx - ymn);
			else
				original_params.yscale = 1;
		} else {
			if (xmx - xmn != 0)
				original_params.xscale = tempy / (xmx - xmn);
			else
				original_params.xscale = 1;
			if (ymx - ymn != 0)
				original_params.yscale = tempy / (ymx - ymn);
			else
				original_params.yscale = 1;
		}
		if (original_params.xscale < original_params.yscale)
			original_params.yscale = original_params.xscale;
		else
			original_params.xscale = original_params.yscale;
		original_params.xmid = (xmx + xmn) / 2;
		original_params.ymid = (ymx + ymn) / 2;
		original_params.xmin = original_params.xmid - (clientWidth / 2)
				/ original_params.xscale;
		original_params.xmax = original_params.xmid + (clientWidth / 2)
				/ original_params.xscale;
		original_params.ymin = original_params.ymid - (clientHeight / 2)
				/ original_params.yscale;
		original_params.ymax = original_params.ymid + (clientHeight / 2)
				/ original_params.yscale;
		current_params = original_params;
		initialized = true;
	}

  public void zoom(double factor) {
    double xmid,ymid,xt,yt;
    //if not initialized then exit;
    previous_params = current_params;
    current_params.xmid   = (current_params.xmin+current_params.xmax) / 2;
    current_params.ymid   = (current_params.ymin+current_params.ymax) / 2;
    xt     = (current_params.xmax-current_params.xmin)*current_params.xscale;
    yt     = (current_params.ymax-current_params.ymin)*current_params.yscale;
    current_params.xscale = current_params.xscale / factor;
    current_params.yscale = current_params.yscale / factor;
    current_params.xmax   = current_params.xmid + (xt/current_params.xscale)/2;
    current_params.xmin   = current_params.xmid - (xt/current_params.xscale)/2;
    current_params.ymax   = current_params.ymid + (yt/current_params.yscale)/2;
    current_params.ymin   = current_params.ymid - (yt/current_params.yscale)/2;
    //Reset_ScrollParams;
    //ClientArea.Refresh;
  }

	public Point2D real_to_screen(double x, double y) {
		double xt, yt;
		xt = (x - current_params.xmin) * current_params.xscale;
		yt = (y - current_params.ymin) * current_params.yscale;
		return new Point2D.Double(xt, yt);
	}
	
	public Point2D real_to_screen(Point2D p) {
		return real_to_screen(p.getX(),p.getY());
	}
	
	private GeneralPath real_to_screen_iterator(PathIterator iterator) {
		  GeneralPath newPath = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
			double seg[] = new double[6];
			for (PathIterator i = iterator; !i.isDone(); i.next()) {
	  			int segType = i.currentSegment(seg);
	  			Point2D newPoint = real_to_screen(seg[0],seg[1]);
	  			switch (segType) {
	  			case PathIterator.SEG_MOVETO: {
	  				newPath.moveTo((int) newPoint.getX(), (int) newPoint.getY());
	  			}
	  				break;
	  			case PathIterator.SEG_LINETO: {
	  				newPath.lineTo((int) newPoint.getX(), (int) newPoint.getY());
	  			}
	  				break;
	  			}
	  }
	    return newPath;
	}
	
	public GeneralPath real_to_screen(GeneralPath path) {
		return real_to_screen_iterator(path.getPathIterator(null));
	}

	public GeneralPath real_to_screen(Shape path) {
		return real_to_screen_iterator(path.getPathIterator(null));
	}

	public Point2D screen_to_real(double x, double y) {
		double xt, yt;
		if (current_params.xscale == 0 || current_params.yscale == 0)
			return null;
		xt = x / current_params.xscale + current_params.xmin;
		yt = current_params.ymax + y / current_params.xscale;
		return new Point2D.Double(xt, yt);
	}

	public Point2D screen_to_real(Point2D p) {
		return screen_to_real(p.getX(),p.getY());
	}

	public void reset_ScrollParams(JScrollBar lr,JScrollBar ud) {
    long tmp;
    //val_lr = Math.round(Max_Scroll*(current_params.xmax-current_params.xmin)/(original_params.xmax-original_params.xmin));
    tmp = Math.round((current_params.xmid-original_params.xmin)/(original_params.xmax-original_params.xmin)*MAX_SCROLL);
    lr.setValue((int)tmp);
    tmp = Math.round((current_params.ymid-original_params.ymin)/(original_params.ymax-original_params.ymin)*MAX_SCROLL);
    ud.setValue((int)tmp);
	}

	public void scrollBars_Scroll(JScrollBar sender,int oldValue, int scrollValue,boolean isHorz) {
		double cx,moved;

		if (scrollValue == oldValue) return;
		moved = scrollValue - oldValue;
		if(isHorz)
		{
			cx = current_params.xmid;
			if (Math.abs(moved)==sender.getBlockIncrement()) {
				moved = (moved*(original_params.xmax - original_params.xmin))/ MAX_SCROLL;
				current_params.xmid += Math.round((moved - (moved/SCROLL_OVERLAPPING)));
			}
			else current_params.xmid += moved;
			current_params.xmin -= (cx-current_params.xmid);
			current_params.xmax -= (cx-current_params.xmid);
		}
		else
		{
			cx = current_params.ymid;
			if (Math.abs(moved)==sender.getBlockIncrement()) {
				moved = -(moved*(original_params.ymax - original_params.ymin))/ MAX_SCROLL;
				current_params.ymid += Math.round((moved - (moved/SCROLL_OVERLAPPING)));
			}
			else current_params.ymid += moved;
			current_params.ymin -= (cx-current_params.ymid);
			current_params.ymax -= (cx-current_params.ymid);
		}
	}
	
	public void newDraw(Shape path,Graphics2D g2d) {
	    GeneralPath newPath = real_to_screen(path);
	    g2d.draw(newPath);
		}

	public void fill(GeneralPath path,Graphics2D g2d) {
    GeneralPath newPath = real_to_screen(path);
    g2d.fill(newPath);
	}

	public void fill(Shape path,Graphics2D g2d) {
	    GeneralPath newPath = real_to_screen(path);
	    g2d.fill(newPath);
	}
	
	public void drawCircle(Shape path,Graphics2D g2d) {
		GeneralPath newPath = real_to_screen(path);
	    Rectangle rtCircle = newPath.getBounds();
	    g2d.drawOval( 	rtCircle.x + 15, rtCircle.y + 15,
	    				rtCircle.width - 30, rtCircle.height - 30 );
	}
	
	public void draw(Shape s,Graphics2D g2d) {
	    GeneralPath newPath = real_to_screen(s);
		g2d.draw(newPath);
	}
	
	public void drawLine(int x1,int y1,int x2,int y2,Graphics2D g2d) {
	    Point2D p1 = real_to_screen(x1,y1);
	    Point2D p2 = real_to_screen(x2,y2);
		g2d.drawLine((int)p1.getX(),(int)p1.getY(),(int)p2.getX(),(int)p2.getY());
	}

	public void drawString(String string,double x,double y,Graphics2D g2d) {
		Point2D p = real_to_screen(x,y);
		g2d.drawString(string,(int)p.getX(),(int)p.getY());
	}
}
