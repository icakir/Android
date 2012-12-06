import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TipController {

	/******************************
	 * So this is the controller. It gets both the model and the view from the
	 * program class which contains the main() method It implements two internal
	 * classes as listeners
	 */
	private JFrameView m_view;
	private TipModel m_model;

	public TipController(JFrameView view, TipModel model) {
		m_view = view;
		m_model = model;

		// here it returns the listeners to the view
		view.addCalculateListener(new CalculateListener());
		view.addExitListener(new ExitListener());
	}

	class CalculateListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// get the user's input values from the view's form
			double amt = m_view.GetAmount();
			double tPercent = m_view.getTipPercent();
			double taxPerc = m_view.getTaxPercent();

			// set the values in the model
			m_model.setPreTaxAmount(amt);
			m_model.setTipPercent(tPercent);
			m_model.setTaxPercent(taxPerc);

			// do the calculations and pass them back to the view
			// I did both in single statements
			m_view.setTip(Double.toString(m_model.CalculateTip()));
			m_view.setTax(Double.toString(m_model.CalculateTax()));
			m_view.setTotal(Double.toString(m_model.CalculateTotal()));

		}
	}

	class ExitListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}