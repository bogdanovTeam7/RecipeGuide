package recipeguide.model.entities;

import java.util.Map;

import recipeguide.model.Quantity;
import recipeguide.saveload.SaveData;

public class Ingredient extends AbstractEntity {

	private IngredientType type;

	public Ingredient() {
	}

	public Ingredient(String name, IngredientType type) {
		super.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		super.name = name;
	}

	public IngredientType getType() {
		return type;
	}

	public void setType(IngredientType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ingredient [name=");
		builder.append(name);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public void postEdit(SaveData saveData) {
		for (Ingredient ingredient : saveData.getIngredients()) {
			if (ingredient.equals((Ingredient) saveData.getOldEntity())) {
//				ingredient
			}
		}
	}

	@Override
	public void postDelete(SaveData saveData) {
		// TODO Auto-generated method stub
		super.postDelete(saveData);
	}

}
