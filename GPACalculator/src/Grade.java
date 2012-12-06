public class Grade {
	private String courseNumber, nonnumeric;
	private int credits;
	private double grade;

	public Grade() {
		this.setCourseNumber("");
		this.setNonNumeric("");
		this.setCredits(0);
		this.setGrade(0);
	}

	public Grade(String courseNumber, int credits, double grade,
			String nonnumeric) {
		this.setCourseNumber(courseNumber);
		this.setCredits(credits);
		this.setGrade(grade);
		this.setNonNumeric(nonnumeric);
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public String getNonNumeric() {
		return nonnumeric;
	}

	public void setNonNumeric(String nonnumeric) {
		this.nonnumeric = nonnumeric;
	}
}
