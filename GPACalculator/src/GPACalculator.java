import java.util.ArrayList;

public class GPACalculator {
	private ArrayList<Grade> grades = new ArrayList<Grade>();

	public GPACalculator() {
		this.setGrade(grades);
	}

	public ArrayList<Grade> getGrade() {
		return grades;
	}

	public void setGrade(ArrayList<Grade> grades) {
		this.grades = grades;
	}

	public void addGrade(Grade g) {
		grades.add(g);
	}

	public double calculateGradePointAverage() {
		double aGrade = 0, credits = 0, theseCredits = 0, points = 0, creditsTotal = 0, gpa = 0;
		for (int i = 0; i < grades.size(); i++) {
			Grade grade = grades.get(i);
			aGrade = grade.getGrade();
			credits = grade.getCredits();
			theseCredits = aGrade * credits;
			points += theseCredits;
			if (aGrade != 0)
				creditsTotal += credits;
		}
		gpa = points / creditsTotal;
		return gpa;
	}
}
