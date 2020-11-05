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
	public void postEdit() {
		for (Ingredient ingredient : SaveData.getInstance()
				.getIngredients()) {
			if (ingredient.getType()
					.equals((IngredientType) SaveData.getInstance()
							.getOldEntity())) {
				ingredient.setType(this);
			}
		}
	}

	@Override
	public void postDelete() {
		for (Ingredient ingredient : SaveData.getInstance()
				.getIngredients()) {
			if (ingredient.getType()
					.equals(this)) {
				ingredient.setType(Settings.INGREDIENT_TYPE_DEFAULT);
			}
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof IngredientType)) {
			return false;
		}
		return name.equals(((IngredientType) obj).getName());
	}

}
