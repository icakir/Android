import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionListener;

public class JFrameView extends JFrame {

	/**
	 * this method creates the JFrame and adds the Panel the panel is actually
	 * the main part of the view I have combined the two into one class to make
	 * it simpler, so we just have one view class the view is unaware of the
	 * model or the controller, although it knows its listener methods must be
	 * sent in from somewhere else
	 */
	private JPanel panel;

	JPanel buttonPanel;
	JLabel lblAmount;
	JRadioButton tenPercent;
	JLabel choosePercent;
	JRadioButton fifteenPercent;
	JRadioButton twentyPercent;
	JRadioButton rbother;
	JTextField txtOther;
	JLabel lbltax;
	JLabel lblTip;
	JLabel lblTaxPercent;
	JLabel lblTaxAmt;
	JLabel lblTotal;
	JTextField txtAmount;
	JTextField txtTaxPercent;
	JTextField txtTipAmount;
	JTextField txtTaxAmount;
	JTextField txtTotal;
	JLabel lblOther;

	JButton calculate;
	JButton exit;

	double tipPercent;
	double amount;
	double taxPercent;

	private static final long serialVersionUID = 1L;

	// constructor
	public JFrameView() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// call the method that builds the panel
		buildPanel();

	}

	public void buildPanel() {

		// instantiate all the objects
		// and set their properties
		panel = new JPanel();
		panel.setLayout(new GridLayout(10, 2, 5, 5));

		lblAmount = new JLabel("Enter pre-tax amount:");

		txtAmount = new JTextField(10);

		tenPercent = new JRadioButton("Ten Percent");

		fifteenPercent = new JRadioButton("Fifteen Percent");
		fifteenPercent.setSelected(true);

		twentyPercent = new JRadioButton("twenty Percent");

		rbother = new JRadioButton("Other");

		// add radiobuttons to a button group
		ButtonGroup group = new ButtonGroup();
		group.add(tenPercent);
		group.add(fifteenPercent);
		group.add(twentyPercent);
		group.add(rbother);

		lblOther = new JLabel("Enter Other Percent");

		txtOther = new JTextField(10);

		lblTaxPercent = new JLabel("Enter tax Percent:");

		txtTaxPercent = new JTextField(10);

		lblTip = new JLabel("Tip Amount:");

		txtTipAmount = new JTextField(10);
		txtTipAmount.setEditable(false);

		lblTaxAmt = new JLabel("Tax Amount:");

		txtTaxAmount = new JTextField(10);
		txtTaxAmount.setEditable(false);

		lblTotal = new JLabel("Total:");

		txtTotal = new JTextField(10);
		txtTotal.setEditable(false);
		// add all the components
		// except the buttons to the panel

		panel.add(lblAmount);
		panel.add(txtAmount);

		panel.add(tenPercent);
		panel.add(fifteenPercent);
		panel.add(twentyPercent);
		panel.add(rbother);
		panel.add(lblOther);
		panel.add(txtOther);
		panel.add(lblTaxPercent);
		panel.add(txtTaxPercent);
		panel.add(lblTip);
		panel.add(txtTipAmount);
		panel.add(lblTaxAmt);
		panel.add(txtTaxAmount);
		panel.add(lblTotal);
		panel.add(txtTotal);

		// add a second panel
		// this one uses flow layout
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		// instantiate the buttons and add
		// them to the panel
		// also add a listener
		calculate = new JButton("Calculate");
		// calculate.addActionListener(this);
		buttonPanel.add(calculate);

		exit = new JButton("Exit");
		// exit.addActionListener(this);
		buttonPanel.add(exit);

		// this, in this case the window
		// we add the two panels to a border
		// layout the main one is in the center
		// the button panel is below (SOUTH)
		this.setLayout(new BorderLayout());
		this.add(panel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);

	}

	public double GetAmount() {
		// get the strings from the text boxes
		double amount = 0;
		try {
			String strAmount = txtAmount.getText();
			amount = Double.parseDouble(strAmount);

		} catch (Exception e) {
			txtTotal.setText(e.getMessage());
		}
		return amount;
	}

	public double getTipPercent() {
		tipPercent = 0;

		// check which radio button is selected
		if (tenPercent.isSelected())
			tipPercent = .1;
		else if (fifteenPercent.isSelected())
			tipPercent = .15;
		else if (twentyPercent.isSelected())
			tipPercent = .2;
		else if (rbother.isSelected()) {
			String percent = txtOther.getText();
			// there is a chance the parse can fail
			try {
				tipPercent = Double.parseDouble(percent);
			} catch (Exception e) {
				txtTotal.setText(e.getMessage());
			}
		} else
			tipPercent = 0;
		return tipPercent;
	}

	public double getTaxPercent() {
		String taxPerc = txtTaxPercent.getText();
		try {
			taxPercent = Double.parseDouble(taxPerc);
		} catch (Exception e) {
			txtTotal.setText(e.getMessage());
		}
		return taxPercent;
	}

	public void setTotal(String total) {
		txtTotal.setText(total);
	}

	public void setTip(String tip) {
		txtTipAmount.setText(tip);
	}

	public void setTax(String tax) {
		txtTaxAmount.setText(tax);
	}

	// these are different rather than implement
	// the listeners here the controller will return the
	// listener to the view
	public void addCalculateListener(ActionListener cal) {
		calculate.addActionListener(cal);
	}

	public void addExitListener(ActionListener el) {
		exit.addActionListener(el);
	}
}