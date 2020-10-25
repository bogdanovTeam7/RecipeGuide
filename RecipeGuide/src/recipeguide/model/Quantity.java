package recipeguide.model;

import recipeguide.model.entities.MeasuryUnit;

public class Quantity {
	private MeasuryUnit unit;
	private double amount;

	public Quantity() {
	}

	public Quantity(MeasuryUnit unit, double amount) {
		this.unit = unit;
		this.amount = amount;
	}

	public MeasuryUnit getUnit() {
		return unit;
	}

	public void setUnit(MeasuryUnit unit) {
		this.unit = unit;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(amount);
		builder.append(" ");
		builder.append(unit.getAbbreviation());
		return builder.toString();
	}

}
