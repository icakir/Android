import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainJFrame extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	public MainJFrame()
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new GradePanel();
		this.add(panel);
	}
}