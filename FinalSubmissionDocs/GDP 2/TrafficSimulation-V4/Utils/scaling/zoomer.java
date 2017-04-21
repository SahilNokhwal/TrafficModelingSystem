/*
 * 
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package Utils.scaling;

/**
 * 
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class zoomer {
	private Params original_params;
	private Params current_params;
	private Params previous_params;
	private int clientWidth;
	private int clientHeight;
	private boolean initialized = false;
		
	public zoomer() {
		clientWidth = 0;
		clientHeight = 0;
	}

	public zoomer(int clientWidth, int clientHeight) {
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
}