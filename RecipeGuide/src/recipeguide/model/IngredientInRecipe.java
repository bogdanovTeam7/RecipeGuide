package recipeguide.model;

import recipeguide.entities.Ingredient;
import recipeguide.entities.MeasuryUnit;
import recipeguide.exceptions.ModalException;

public class IngredientInRecipe extends AbstractDao {
	private Ingredient ingredient;
	private MeasuryUnit unit;
	private double amount;

	private IngredientInRecipe(Builder builder) {
		this.ingredient = builder.ingredient;
		this.unit = builder.unit;
		this.amount = builder.amount;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Ingredient ingredient;
		private MeasuryUnit unit;
		private double amount;

		private Builder() {
		}

		public Builder withIngredient(Ingredient ingredient) throws ModalException {
			if (ingredient == null) {
				throw new ModalException(ModalException.INGREDIENT_EMPTY);
			}
			this.ingredient = ingredient;
			return this;
		}

		public Builder withUnit(MeasuryUnit unit) throws ModalException {
			if (unit == null) {
				throw new ModalException(ModalException.MESURY_EMPTY);
			}
			this.unit = unit;
			return this;
		}

		public Builder withAmount(double amount) throws ModalException {
			if (amount <= 0) {
				throw new ModalException(ModalException.NUMBER_FORMAT);
			}
			this.amount = amount;
			return this;
		}

		public IngredientInRecipe build() {
			return new IngredientInRecipe(this);
		}
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
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
		StringBuilder builder2 = new StringBuilder();
		builder2.append("IngredientInRecipe [ingredient=");
		builder2.append(ingredient);
		builder2.append(", unit=");
		builder2.append(unit);
		builder2.append(", amount=");
		builder2.append(amount);
		builder2.append("]");
		return builder2.toString();
	}

	@Override
	public void postAdd() {
		// TODO Auto-generated method stub

	}

	@Override
	public void postEdit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void postDelete() {
		// TODO Auto-generated method stub

	}

}
