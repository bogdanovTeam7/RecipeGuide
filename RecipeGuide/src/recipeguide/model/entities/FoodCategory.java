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
	public void postEdit(SaveData saveData) {
		for (Recipe recipe : saveData.getFilter()
				.getRecipesByCategory((FoodCategory) saveData.getOldEntity())) {
			recipe.setCategory(this);
			recipe.setDescription(Text.get("foodCategoryPostEdit") + "\n" + recipe.getDescription());
		}
	}

	@Override
	public void postDelete(SaveData saveData) {
		for (Recipe recipe : saveData.getFilter()
				.getRecipesByCategory(this)) {
			recipe.setCategory(Settings.FOOD_CATEGORY_DEFAULT);
		}
	}

}
