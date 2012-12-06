import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

//like MealTipPanel.java
public class GradePanel extends JPanel implements ActionListener 
{
	private static final long serialVersionUID = 1L;

	JPanel panel, rButtonPanel, displayPanel, buttonPanel;
	JLabel lblCourseNumber, lblCredit,  lblGrade;
	JTextField txtCourseNumber, txtCredit, txtGrade;
	JTextArea statusField;
	JRadioButton rbW, rbI, rbNC, rbA;
	JCheckBox cbNonnumeric;
	
	JButton btnSubmit, btnGPA, btnClear;

	List<Double> gradeArray = new ArrayList<Double>();
	List<Integer> cHoursArray = new ArrayList<Integer>();
	List<Double> grades = new ArrayList<Double>();
	
	Grade g;
	
	double tGrade;
	double tWeight;
	double tCredit;
	double tGPA;
	
	
	public GradePanel(){
		CreatePanel();
	}
	
	private void CreatePanel()
	{
		// 7 rows
		// 2 columns
		// 5 pixel spacing
		panel = new JPanel();
		panel.setLayout(new GridLayout(7,2,5,5));
		
		lblCourseNumber = new JLabel("Course Number: ");
		txtCourseNumber = new JTextField(4);
//		txtCourseNumber.addActionListener(new TempListener());
		
		lblCredit = new JLabel("Credits : ");
		txtCredit = new JTextField(1);
//		txtCredit.addActionListener(new TempListener());
		
		lblGrade = new JLabel("Grade");
		txtGrade = new JTextField(4);
//		txtGrade.addActionListener(new TempListener());	
		
		cbNonnumeric = new JCheckBox("NonNumeric");
		
		rbW = new JRadioButton("W");
		rbI = new JRadioButton("I");
		rbNC = new JRadioButton("NC");
		rbA = new JRadioButton("A");
		
		//from left, from top, width, height
		statusField = new JTextArea(100,200);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rbW);
		group.add(rbI);
		group.add(rbNC);
		group.add(rbA);
		
		// add top panel
		panel.add(lblCourseNumber);
		panel.add(txtCourseNumber);
		panel.add(lblCredit);
		panel.add(txtCredit);
		panel.add(lblGrade);
		panel.add(txtGrade);
		panel.add(cbNonnumeric);
		
		// add radio button panel
		rButtonPanel = new JPanel();
		rButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		// add display and button panel
		// add listener
		statusField.setEditable(false);
		displayPanel.add(statusField);
		
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
		this.add(panel, BorderLayout.NORTH);
		this.add(displayPanel, BorderLayout.WEST);
		this.add(buttonPanel, BorderLayout.EAST);		
	}
	
	public void actionPerformed(ActionEvent e){
		Object source = e.getSource();
		if(source == btnSubmit)
			submitInfo();
		else if(source == btnGPA){
			calculateGPA();
		}else if(source == btnClear) {
			txtCourseNumber.setText("");
			statusField.setText("");
			txtCredit.setText("");
			txtGrade.setText("");
			tCredit = 0.00;
			tWeight = 0.00;
		}
		
	}
	
	private void submitInfo(){
		gradeArray.add(Double.parseDouble(txtGrade.getText()));
		cHoursArray.add(Integer.parseInt(txtCredit.getText()));
		
		statusField.append(txtCourseNumber.getText() + "\t\t\t" + txtGrade.getText() + "\t" + txtCredit.getText() + "\n");
		txtGrade.setText("");
		txtCourseNumber.setText("");
		txtCredit.setText("");
	}
	
	private void calculateGPA(){
		double tGrade = 0.00, tWeight = 0.00, tCredit = 0.00, tGPA = 0.00;
		for(Double grade : gradeArray){
			tGrade = tGrade + grade;
		}
		for(Integer hour : cHoursArray){
			tCredit += hour;
		}
		tWeight = (tGrade * tCredit) / gradeArray.size();
		
		tGPA = tWeight/tCredit;

		
		statusField.setText("Total Credit Points : " + tWeight + "\n" + 
						"Total Credit Credits : " + txtCredit + "\n\n" + 
						"Grade Point Average (GPA) : " + tGPA + "\n");
	}
	
//	private class TempListener implements ActionListener {
//		double tGrade = 0.00, tWeight = 0.00, tCredit = 0.00, tGPA = 0.00;
//		String status;
//
//		public void actionPerformed(ActionEvent event) {
//			if (event.getSource() == btnSubmit) {
//				gradeArray.add(Double.parseDouble(txtGrade.getText()));
//				cHoursArray.add(Integer.parseInt(txtCredit.getText()));
//				
//				statusField.append(txtCourseNumber.getText() + "\t\t\t" + txtGrade.getText() + "\t" + txtCredit.getText() + "\n");
//				txtGrade.setText("");
//				txtCourseNumber.setText("");
//				txtCredit.setText("");
//			}
//
//			if (event.getSource() == btnGPA) {
//				for(Double grade : gradeArray){
//					tGrade = tGrade + grade;
//				}
//				for(Integer hour : cHoursArray){
//					tCredit += hour;
//				}
//				tWeight = (tGrade * tCredit) / gradeArray.size();
//				
//				tGPA = tWeight/tCredit;
//				
//				if(tGPA >= 2){
//					status = ("Pass");
//				}else{
//					status = ("Fail");
//				}
//				
//				statusField.setText("Total Credit Points : " + tWeight + "\n" + 
//								"Total Credit Credits : " + txtCredit + "\n\n" + 
//								"Grade Point Average (GPA) : " + tGPA + "\n" +
//								"Status : " + status);
//			}
//
//			if (event.getSource() == btnClear) {
//				txtCourseNumber.setText("");
//				statusField.setText("");
//				txtCredit.setText("");
//				txtGrade.setText("");
//				tCredit = 0.00;
//				tWeight = 0.00;
//			}
//
//		}
//	}
}
