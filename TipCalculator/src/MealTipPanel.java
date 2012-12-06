import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

public class MealTipPanel extends JPanel implements ActionListener {

	/**
	 * This class sets up the content of the Frame it contains two panels on
	 * sets up the form itself and uses the grid layout the other uses the
	 * flowLayout and sets up the buttons the class extends JPanel and
	 * implements the action listener which handles the button events
	 */
	private static final long serialVersionUID = 1L;

	// private fields, Swing components
	JPanel panel;
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

	// class level variables
	Tip t;
	double tipPercent;
	double amount;
	double taxPercent;

	// constructor which calls create panel
	public MealTipPanel() {
		CreatePanel();
	}

	private void CreatePanel() {

		// make the components new
		// and set properties
		// this first panel uses a grid layout
		// it has 10 rows, 2 columns and a spacing
		// of 5 pixels between cells
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
		calculate.addActionListener(this);
		buttonPanel.add(calculate);

		exit = new JButton("Exit");
		exit.addActionListener(this);
		buttonPanel.add(exit);

		// this, in this case the window
		// we add the two panels to a border
		// layout the main one is in the center
		// the button panel is below (SOUTH)
		this.setLayout(new BorderLayout());
		this.add(panel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);

	}

	// this is the listener
	@Override
	public void actionPerformed(ActionEvent e) {
		// check which object was clicked
		Object source = e.getSource();
		if (source == exit)
			System.exit(0); // exit
		else if (source == calculate) {
			getTipInfo(); // call the method
			// to process the tips
			// call display results
			displayResults();
		}
	}

	private void getTipInfo() {

		// get the strings from the text boxes
		String strAmount = txtAmount.getText();
		String taxPerc = txtTaxPercent.getText();
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
			tipPercent = Double.parseDouble(percent);
		} else
			tipPercent = 0;

		// convert the string values to double
		amount = Double.parseDouble(strAmount);
		taxPercent = Double.parseDouble(taxPerc);
	}

	private void displayResults() {
		// Instantiate the tip and access methods
		// display the results
		t = new Tip(amount, tipPercent, taxPercent);
		txtTipAmount.setText(Double.toString(t.CalculateTip()));
		txtTaxAmount.setText(Double.toString(t.CalculateTax()));
		txtTotal.setText(Double.toString(t.CalculateTotal()));

	}
}
