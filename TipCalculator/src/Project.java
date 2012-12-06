public class Project {

	/**
	 * this class is the starting point of the project it calls the main frame.
	 * sets the title and sets the size and makes it visible
	 */
	public static void main(String[] args) 
	{
		MainJFrame m = new MainJFrame();
		m.setTitle("Tip Calculator");
		m.setBounds(200, 200, 350, 350);

		m.setVisible(true);
	}

}