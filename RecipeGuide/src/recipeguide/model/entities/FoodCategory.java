package recipeguide.model.entities;

import recipeguide.saveload.SaveData;
import recipeguide.settings.Settings;
import recipeguide.settings.Text;

public class FoodCategory extends AbstractEntity {

	public FoodCategory() {
	}

	public FoodCategory(String name) {
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
		builder.append("FoodCategory [name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof FoodCategory) {
			return name.equals(((FoodCategory) obj).getName());
		}
		return false;
	}

	@Override
	public void postEdit() {
		for (Recipe recipe : SaveData.getInstance()
				.getFilter()
				.getRecipesByCategory((FoodCategory) SaveData.getInstance()
						.getOldEntity())) {
			recipe.setCategory(this);
			recipe.setDescription(Text.get("foodCategoryPostEdit") + "\n" + recipe.getDescription());
		}
	}

	@Override
	public void postDelete() {
		for (Recipe recipe : SaveData.getInstance()
				.getFilter()
				.getRecipesByCategory(this)) {
			recipe.setCategory(Settings.FOOD_CATEGORY_DEFAULT);
		}
	}

}
