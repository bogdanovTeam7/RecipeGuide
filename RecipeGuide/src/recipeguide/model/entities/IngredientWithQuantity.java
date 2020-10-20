package recipeguide.model.entities;

import recipeguide.model.Quantity;

public class IngredientWithQuantity extends AbstractEntity {

	private Ingredient ingredient;
	private Quantity quantity;

	public IngredientWithQuantity() {
	}

	public IngredientWithQuantity(Ingredient ingredient, Quantity quantity) {
		this.ingredient = ingredient;
		this.quantity = quantity;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public Quantity getQuantity() {
		return quantity;
	}

	public void setQuantity(Quantity quantity) {
		this.quantity = quantity;
	}

}
