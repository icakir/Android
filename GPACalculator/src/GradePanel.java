import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;

//like MealTipPanel.java
public class GradePanel extends JPanel implements ActionListener, ItemListener {
	private static final long serialVersionUID = 1L;

	JPanel panel, buttonPanel;
	JLabel lblCourseNumber, lblCredit, lblGrade;
	JTextField txtCourseNumber, txtCredit, txtGrade;
	JTextArea statusField;
	JRadioButton rbW, rbI, rbNC, rbA;
	JCheckBox cbNonnumeric;

	JButton btnSubmit, btnGPA, btnClear;

	private Grade g;
	private int credit = 0;
	private double grade = 0;
	private String courseNumber = "";
	private String nonnumeric = "";
	private ButtonGroup group = new ButtonGroup();
	private GPACalculator gCalc = new GPACalculator();
	private boolean showButtons = false;

	public GradePanel() {
		CreatePanel();
	}

	private void CreatePanel() {
		// 10 rows
		// 2 columns
		// 5 pixel spacing
		panel = new JPanel();
		panel.setLayout(new GridLayout(10, 2, 5, 5));

		// rButtonPanel = new JPanel();
		// rButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		// add(rButtonPanel);

		lblCourseNumber = new JLabel("Course Number: ");
		txtCourseNumber = new JTextField(4);

		lblCredit = new JLabel("Credits : ");
		txtCredit = new JTextField(1);

		lblGrade = new JLabel("Grade");
		txtGrade = new JTextField(4);

		cbNonnumeric = new JCheckBox("NonNumeric");
		cbNonnumeric.addItemListener(this);

		rbW = new JRadioButton("W");
		rbI = new JRadioButton("I");
		rbNC = new JRadioButton("NC");
		rbA = new JRadioButton("A");

		// from left, from top, width, height
		statusField = new JTextArea(10, 50);
		statusField.setEditable(false);

		group.add(rbW);
		group.add(rbI);
		group.add(rbNC);
		group.add(rbA);
		rbW.setVisible(false);
		rbI.setVisible(false);
		rbNC.setVisible(false);
		rbA.setVisible(false);

		// add top panel
		panel.add(lblCourseNumber);
		panel.add(txtCourseNumber);
		panel.add(lblCredit);
		panel.add(txtCredit);
		panel.add(lblGrade);
		panel.add(txtGrade);

		panel.add(rbW);
		panel.add(rbI);
		panel.add(rbNC);
		panel.add(rbA);

		panel.add(cbNonnumeric);

		// add radio button panel
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		// add display and button panel
		// add listener

		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(this);
		buttonPanel.add(btnSubmit);

		btnGPA = new JButton("GPA");
		btnGPA.addActionListener(this);
		buttonPanel.add(btnGPA);

		btnClear = new JButton("Clear");
		btnClear.addActionListener(this);
		buttonPanel.add(btnClear);

		this.setLayout(new BorderLayout());
		this.add(panel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == btnSubmit)
			submitInfo();
		else if (source == btnGPA) {
			calculateGPA();
			displayGPA();
		} else if (source == btnClear) {
			clearFields();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent evt) {
		Object source = evt.getSource();
		if (source == cbNonnumeric) {
			togglePanels();
		}
	}

	private void togglePanels() {
		if (showButtons) {
			showButtons = false;
			rbW.setVisible(false);
			rbI.setVisible(false);
			rbNC.setVisible(false);
			rbA.setVisible(false);
		} else {
			showButtons = true;
			rbW.setVisible(true);
			rbI.setVisible(true);
			rbNC.setVisible(true);
			rbA.setVisible(true);
		}
	}

	private void submitInfo() {
//		gradeArray.add(Double.parseDouble(txtGrade.getText()));
//		cHoursArray.add(Integer.parseInt(txtCredit.getText()));

		statusField.append(txtCourseNumber.getText() + "\t\t\t"
				+ txtGrade.getText() + "\t" + txtCredit.getText() + "\n");
		txtGrade.setText("");
		txtCourseNumber.setText("");
		txtCredit.setText("");
	}

	private void calculateGPA() {
		if (getCourseNumber()) {
			getCredit();
			getGrade();
		}
	}

	private boolean getCourseNumber() {
		if (!(txtCourseNumber.getText()).isEmpty()
				&& (txtCourseNumber.getText() != "Enter Course Number")) {
			courseNumber = txtCourseNumber.getText();
			return true;
		} else
			txtCourseNumber.setText("Enter Course Number");
		return false;
	}

	private void getCredit() {
		String strCredit = txtCredit.getText();
		if (!strCredit.isEmpty() && isNumeric(strCredit))
			credit = Integer.parseInt(txtCredit.getText());
		else
			txtCredit.setText("Enter Credits");
	}

	private void getGrade() {
		grade = 0;
		String strGrade = txtGrade.getText();
		if (strGrade.isEmpty() && (cbNonnumeric.isSelected())) {
			if (rbW.isSelected())
				nonnumeric = "W";
			else if (rbI.isSelected())
				nonnumeric = "I";
			else if (rbNC.isSelected())
				nonnumeric = "NC";
			else if (rbA.isSelected())
				nonnumeric = "A";
			else
				nonnumeric = "Enter Grade";

			txtCurrentGrade.setText(nonnumeric);
		} else if (strGrade.isEmpty() && !cbNonnumeric.isSelected()) {
			if (!group.isSelected(null)) {
				txtCurrentGrade.setText("Enter number or choose check box");
			} else
				txtGrade.setText("EnterGrade");
		} else if (!isNumeric(strGrade)) {
			grade = Double.parseDouble(strGrade);
			txtCurrentGrade.setText(Double.toString(grade));
		} else {
			txtGrade.setText("Enter number grade");
		}
	}

	public static boolean isNumeric(String str) {
		NumberFormat formatter = NumberFormat.getInstance();
		ParsePosition pos = new ParsePosition(0);
		formatter.parse(str, pos);
		return str.length() == pos.getIndex();
	}

	private void displayGPA() {
		g = new Grade(courseNumber, credit, grade, nonnumeric);
		gCalc.addGrade(g);
		double d = gCalc.calculateGradePointAverage();
		DecimalFormat df = new DecimalFormat("#.##");
		String gpa = df.format(d);
		statusField.setText(gpa);

		statusField.setText("Total Credit Points : " + tWeight + "\n"
				+ "Total Credit Credits : " + txtCredit + "\n\n"
				+ "Grade Point Average (GPA) : " + tGPA + "\n");
	}

	private void clearFields() {
		txtCourseNumber.setText("");
		statusField.setText("");
		txtCredit.setText("");
		txtGrade.setText("");
	}


}
