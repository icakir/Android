import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainJFrame extends JFrame {

	/**
	 * this method creates the JFrame and adds the Panel
	 */
	private static final long serialVersionUID = 1L;

	public MainJFrame() 
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new MealTipPanel();
		this.add(panel);
	}
}