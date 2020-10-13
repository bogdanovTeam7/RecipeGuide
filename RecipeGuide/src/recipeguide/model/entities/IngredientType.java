package recipeguide.model.entities;

import recipeguide.saveload.SaveData;
import recipeguide.settings.Settings;

public class IngredientType extends AbstractEntity {

	public IngredientType() {
	}

	public IngredientType(String name) {
		super.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		super.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IngredientType [name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public void postEdit(SaveData saveData) {
		for (Ingredient ingredient : saveData.getIngredients()) {
			if (ingredient.getType()
					.equals((IngredientType) saveData.getOldEntity())) {
				ingredient.setType(this);
			}
		}
	}

	@Override
	public void postDelete(SaveData saveData) {
		for (Ingredient ingredient : saveData.getIngredients()) {
			if (ingredient.getType()
					.equals(this)) {
				ingredient.setType(Settings.INGREDIENT_TYPE_DEFAULT);
			}
		}
	}

}
