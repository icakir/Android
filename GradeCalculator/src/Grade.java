
public class Grade {
	private int txtCredit;
	private double txtGrade;
	
	public Grade(){
		txtCredit = 0;
		txtGrade = 0;
	}
	
	public Grade(int txtCredit, double txtGrade){
		this.setTxtCredit(txtCredit);
		this.setTxtGrade(txtGrade);
	}
		
	public void setTxtCredit(int txtCredit){
		this.txtCredit = txtCredit;
	}
	
	public int getTxtCredit(){
		return txtCredit;
	}
	
	public void setTxtGrade(double txtGrade){
		this.txtGrade = txtGrade;
	}
	
	public double getTxtGrade(){
		return txtGrade;
	}
	
}
