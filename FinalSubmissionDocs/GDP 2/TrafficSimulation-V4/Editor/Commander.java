/*
 * 
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author s525063
 *
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class Commander extends JDialog {

	private Main main;

	private javax.swing.JPanel jContentPane = null;

	private JPanel jPanel = null;
	private JButton cmScaleUp = null;
	private JButton cmScaleDown = null;
	private JPanel jPanel1 = null;
	private JComboBox jCmbLanding = null;
	private JComboBox jCmbIntersection = null;
	private JComboBox jCmbDirection = null;
	private JTextField txtCarCount = null;
	private JTextField txtIntsectionCarCount = null;
	private JButton jButton = null;
	private JButton jButton2 = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JTextField roadName = null;
	private JButton jBtnStart = null;
	private JButton jBtnStop = null;
	private int[] arrGeneratedCars = new int[8];
	private int[][] arrIntersectionCars = new int[6][4];
	private int nGameStatus = -1;

	/**
	 * This is the default constructor
	 */
	public Commander() {
		super();
		initialize();
	}

	public Commander(JFrame parent) {
		super(parent);
		main = (Main) parent;
		initialize();
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setTitle("Commander Window");
		this.setSize(435, 265);
		this.setContentPane(getJContentPane());

		for (int i = 0; i < 8; i++)
			arrGeneratedCars[i] = 25;
		txtCarCount.setText(String.valueOf(arrGeneratedCars[0]));

		for (int i = 0; i < 6; i++)
			for (int j = 0; j < 4; j++)
				arrIntersectionCars[i][j] = 60;

		txtIntsectionCarCount
				.setText(String.valueOf(arrIntersectionCars[0][0]));
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(new java.awt.BorderLayout());
			jContentPane.add(getJPanel(), java.awt.BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.add(getJPanel1(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getCmScaleUp() {
		if (cmScaleUp == null) {
			cmScaleUp = new JButton();
			cmScaleUp.setBounds(340, 20, 99, 22);
			cmScaleUp.setText("Scale Up");
			cmScaleUp.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					main.designPanel.upZoomRoad();
				}
			});
		}
		return cmScaleUp;
	}

	/**
	 * This method initializes jButton1
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getCmScaleDown() {
		if (cmScaleDown == null) {
			cmScaleDown = new JButton();
			cmScaleDown.setBounds(340, 60, 99, 23);
			cmScaleDown.setText("Scale Down");
			cmScaleDown.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					main.designPanel.downZoomRoad();
				}
			});
		}
		return cmScaleDown;
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jLabel1 = new JLabel();
			jLabel2 = new JLabel();
			jPanel1 = new JPanel();
			jCmbLanding = new JComboBox();
			jCmbLanding.addItem("Landing - 1");
			jCmbLanding.addItem("Landing - 2");
			jCmbLanding.addItem("Landing - 3");
			jCmbLanding.addItem("Landing - 4");
			jCmbLanding.addItem("Landing - 5");
			jCmbLanding.addItem("Landing - 6");
			jCmbLanding.addItem("Landing - 7");
			jCmbLanding.addItem("Landing - 8");
			jCmbLanding.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					int idxSelectedItem = jCmbLanding.getSelectedIndex();

					if (idxSelectedItem >= 0 && idxSelectedItem <= 7) {
						setCarCount(arrGeneratedCars[idxSelectedItem]);
					}
				}
			});

			jCmbIntersection = new JComboBox();
			jCmbIntersection.addItem("Intersection - 1");
			jCmbIntersection.addItem("Intersection - 2");
			jCmbIntersection.addItem("Intersection - 3");
			jCmbIntersection.addItem("Intersection - 4");
			jCmbIntersection.addItem("Intersection - 5");
			jCmbIntersection.addItem("Intersection - 6");
			jCmbIntersection
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							txtIntsectionCarCount.setEnabled(true);
							String strCurItem = (String) jCmbDirection
									.getSelectedItem();

							if (jCmbIntersection.getSelectedIndex() == 2
									&& strCurItem.equals("East")) {
								txtIntsectionCarCount.setText("");
								txtIntsectionCarCount.setEnabled(false);
								return;
							}

							if (jCmbIntersection.getSelectedIndex() == 4
									&& strCurItem.equals("South")) {
								txtIntsectionCarCount.setText("");
								txtIntsectionCarCount.setEnabled(false);
								return;
							}

							if (strCurItem.equals("East"))
								setIntersectionCarCount(arrIntersectionCars[jCmbIntersection
										.getSelectedIndex()][0]);
							else if (strCurItem.equals("West"))
								setIntersectionCarCount(arrIntersectionCars[jCmbIntersection
										.getSelectedIndex()][1]);
							else if (strCurItem.equals("North"))
								setIntersectionCarCount(arrIntersectionCars[jCmbIntersection
										.getSelectedIndex()][2]);
							else if (strCurItem.equals("South"))
								setIntersectionCarCount(arrIntersectionCars[jCmbIntersection
										.getSelectedIndex()][3]);
						}
					});

			jCmbDirection = new JComboBox();
			jCmbDirection.addItem("East");
			jCmbDirection.addItem("West");
			jCmbDirection.addItem("North");
			jCmbDirection.addItem("South");
			jCmbDirection
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							txtIntsectionCarCount.setEnabled(true);
							String strCurItem = (String) jCmbDirection
									.getSelectedItem();

							if (jCmbIntersection.getSelectedIndex() == 2
									&& strCurItem.equals("East")) {
								txtIntsectionCarCount.setText("");
								txtIntsectionCarCount.setEnabled(false);
								return;
							}

							if (jCmbIntersection.getSelectedIndex() == 4
									&& strCurItem.equals("South")) {
								txtIntsectionCarCount.setText("");
								txtIntsectionCarCount.setEnabled(false);
								return;
							}

							if (strCurItem.equals("East"))
								setIntersectionCarCount(arrIntersectionCars[jCmbIntersection
										.getSelectedIndex()][0]);
							else if (strCurItem.equals("West"))
								setIntersectionCarCount(arrIntersectionCars[jCmbIntersection
										.getSelectedIndex()][1]);
							else if (strCurItem.equals("North"))
								setIntersectionCarCount(arrIntersectionCars[jCmbIntersection
										.getSelectedIndex()][2]);
							else if (strCurItem.equals("South"))
								setIntersectionCarCount(arrIntersectionCars[jCmbIntersection
										.getSelectedIndex()][3]);
						}
					});

			jPanel1.setLayout(null);
			jPanel1.setBounds(20, 20, 500, 180);

			jCmbLanding.setBounds(0, 35, 149, 23);
			jCmbIntersection.setBounds(0, 100, 149, 23);
			jCmbDirection.setBounds(164, 100, 80, 23);

			jLabel1.setBounds(0, 8, 195, 21);
			jLabel1.setText("Cars Generation For Landings");

			jLabel2.setBounds(0, 75, 195, 21);
			jLabel2.setText("Cars Count For Intersections");

			jPanel1.add(jCmbLanding, null);
			jPanel1.add(getCarCountTextCtrl(), null);
			jPanel1.add(getIntersectionCarCountTextCtrl(), null);
			jPanel1.add(getJButton(), null);
			jPanel1.add(getJButton2(), null);
			jPanel1.add(getJButtonStart(), null);
			jPanel1.add(getJButtonStop(), null);
			jPanel1.add(jLabel1, null);
			jPanel1.add(jCmbIntersection, null);
			jPanel1.add(jCmbDirection, null);
			jPanel1.add(jLabel2, null);
		}
		return jPanel1;
	}

	/**
	 * This method initializes jTextField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getCarCountTextCtrl() {
		if (txtCarCount == null) {
			txtCarCount = new JTextField();
			txtCarCount.setBounds(165, 35, 145, 25);
		}
		return txtCarCount;
	}

	/**
	 * This method initializes jTextField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getIntersectionCarCountTextCtrl() {
		if (txtIntsectionCarCount == null) {
			txtIntsectionCarCount = new JTextField();
			txtIntsectionCarCount.setBounds(255, 100, 53, 25);
		}
		return txtIntsectionCarCount;
	}

	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(325, 35, 55, 24);
			jButton.setText("Set");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (txtCarCount.getText().isEmpty()) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Please input number for car count.");
						return;
					}
					try {
						if (Integer.valueOf(txtCarCount.getText()) < 0) {
							JOptionPane.showMessageDialog(new JFrame(),
									"Value must be whole number");
							return;
						}
						arrGeneratedCars[jCmbLanding.getSelectedIndex()] = Integer
								.valueOf(txtCarCount.getText());
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Please input numeric value.");
						return;
					}

				}
			});
		}
		return jButton;
	}

	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(325, 100, 55, 24);
			jButton2.setText("Set");
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (txtIntsectionCarCount.getText().isEmpty()) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Please input car count for intersection.");
						return;
					}

					if (txtIntsectionCarCount.isEnabled()) {
						try {
							if (Integer.valueOf(txtIntsectionCarCount.getText()) < 0) {
								JOptionPane.showMessageDialog(new JFrame(),
										"Value must be whole number");
								return;
							}
							arrIntersectionCars[jCmbIntersection
									.getSelectedIndex()][jCmbDirection
									.getSelectedIndex()] = Integer
									.valueOf(txtIntsectionCarCount.getText());
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(new JFrame(),
									"Please input numeric value.");
							return;
						}
					}
				}
			});
		}
		return jButton2;
	}

	public void setCarCount(int value) {
		txtCarCount.setText(String.valueOf(value));
	}

	public void setIntersectionCarCount(int value) {
		txtIntsectionCarCount.setText(String.valueOf(value));
	}

	public int getCarCount() {
		return Integer.parseInt(txtCarCount.getText());
	}

	/**
	 * This method initializes jTextField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getRoadName() {
		if (roadName == null) {
			roadName = new JTextField();
			roadName.setBounds(80, 80, 179, 20);
		}
		return roadName;
	}

	/**
	 * This method initializes jButton1
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonStart() {
		if (jBtnStart == null) {
			jBtnStart = new JButton();
			jBtnStart.setBounds(80, 150, 80, 25);
			jBtnStart.setText("Start");
			jBtnStart.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jBtnStop.setEnabled(false);
					txtCarCount.setEnabled(false);
					txtIntsectionCarCount.setEnabled(false);
					jCmbLanding.setEnabled(false);
					jCmbIntersection.setEnabled(false);
					jCmbDirection.setEnabled(false);
					jBtnStart.setEnabled(false);
					jBtnStop.setEnabled(true);
					jButton.setEnabled(false);
					jButton2.setEnabled(false);

					if (nGameStatus == -1) {
						main.swapto(1);
						main.setMaxCarsCountForLanding(arrGeneratedCars);
						main.setMaxCountForIntersection(arrIntersectionCars);
						main.StartSimA();
						main.setVisible(true);
					} else {
						main.StartSim();
					}

					nGameStatus = 1;
				}
			});
		}

		return jBtnStart;
	}

	private JButton getJButtonStop() {
		if (jBtnStop == null) {
			jBtnStop = new JButton();
			jBtnStop.setBounds(215, 150, 80, 25);
			jBtnStop.setText("Stop");
			jBtnStop.setEnabled(false);
			jBtnStop.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jBtnStop.setEnabled(true);
					txtCarCount.setEnabled(true);
					txtIntsectionCarCount.setEnabled(true);
					jCmbLanding.setEnabled(true);
					jCmbIntersection.setEnabled(true);
					jCmbDirection.setEnabled(true);
					jBtnStart.setEnabled(true);
					jButton.setEnabled(true);
					jButton2.setEnabled(true);
					jBtnStop.setEnabled(false);
					main.StopSim();
					nGameStatus = 2;
				}
			});
		}

		return jBtnStop;
	}

	public void setRoadName(String name) {
		roadName.setText(name);
	}
	
}
