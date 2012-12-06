public class Tip {
	/*********************************
	 * this class handles a simple tip on a meal. It takes in the amount, the
	 * tax percent and the tip percent and has methods that return the amount of
	 * the tip the amount of tax the total amount due Steve Conger 3/7/2012
	 */

	// private fields
	private double preTaxAmount;
	private double tipPercent;
	private double taxPercent;

	// constructors
	public Tip() {
		preTaxAmount = 0;
		tipPercent = 0;
		taxPercent = 0;
	}

	public Tip(double preTaxAmount, double tipPercent, double taxPercent) {
		this.setPreTaxAmount(preTaxAmount);
		this.setTipPercent(tipPercent);
		this.setTaxPercent(taxPercent);
	}

	// assessors/mutators
	public void setPreTaxAmount(double preTaxAmount) {
		this.preTaxAmount = preTaxAmount;
	}

	public double getPreTaxAmount() {
		return preTaxAmount;
	}

	public void setTipPercent(double tipPercent) {
		// make sure the tip is a decimal
		// or zero
		if (tipPercent >= 1)
			tipPercent /= 100;
		this.tipPercent = tipPercent;
	}

	public double getTipPercent() {
		return tipPercent;
	}

	public void setTaxPercent(double taxPercent) {
		if (taxPercent >= 1)
			taxPercent /= 100;
		this.taxPercent = taxPercent;
	}

	public double getTaxPercent() {
		return taxPercent;
	}

	// public methods
	public double CalculateTip() {
		return preTaxAmount * tipPercent;
	}

	public double CalculateTax() {
		return preTaxAmount * taxPercent;
	}

	public double CalculateTotal() {
		return preTaxAmount + (preTaxAmount * tipPercent)
				+ (preTaxAmount * taxPercent);
	}

}