import javax.swing.JDialog;
import javax.swing.JFrame;


/**
 * @author s525063
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class alertBox extends JDialog {

	private javax.swing.JPanel jContentPane = null;
	private String caption, text;

	/**
	 * This is the default constructor
	 */
	public alertBox(JFrame parent,String caption, String text) {
		super(parent,true);
		this.caption = caption;
		this.text = text;
		initialize();
	}
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(343, 216);
		this.setContentPane(getJContentPane());
	}
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJContentPane() {
		if(jContentPane == null) {
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(new java.awt.BorderLayout());
		}
		return jContentPane;
	}
	
	public static void showMessage(JFrame parent, String caption, String text)
	{
		alertBox tmp = new alertBox(parent,caption,text);
		tmp.setVisible(true);
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
