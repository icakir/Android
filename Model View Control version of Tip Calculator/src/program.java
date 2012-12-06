
public class program {

	/*******************************
	 * this class has the main method. It instantiates the view, the model and
	 * the controller. It passes the view and the model to the controller
	 */
	public static void main(String[] args) {
		TipModel model = new TipModel();
		JFrameView view = new JFrameView();

		TipController controller = new TipController(view, model);
		view.setBounds(100, 100, 500, 300);
		view.setTitle("Tip Calculator MVC");
		view.setVisible(true);

	}

}