public class TipModel {
	/*************************
	 * this is the model class. It handles the data and does all the
	 * calculations. It is totally independent of the controller and the view it
	 * is identical to the tip class in the former version
	 */
	// private fields
	private double preTaxAmount;
	private double tipPercent;
	private double taxPercent;

	// constructors
	public TipModel() {
		preTaxAmount = 0;
		tipPercent = 0;
		taxPercent = 0;
	}

	public TipModel(double preTaxAmount, double tipPercent, double taxPercent) {
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