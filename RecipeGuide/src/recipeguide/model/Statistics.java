package recipeguide.model;

import java.util.HashMap;
import java.util.Map;

import recipeguide.entities.FoodCategory;
import recipeguide.saveload.SaveData;

public class Statistics {

	public static int getNumberOfRecipe() {
		return SaveData.getInstance()
				.getRecipes()
				.size();
	}

	public static Map<String, Integer> getDataOnRecipeByCategories(FoodCategory category) {
		Map<String, Integer> result = new HashMap<>();
		SaveData saveData = SaveData.getInstance();
		for (Recipe recipe : saveData.getRecipes()) {
			if (recipe.getCategory()
					.equals(category)) {
				String key = category.toString();
				Integer value = result.containsKey(key) ? result.get(key) + 1 : 1;
				result.put(key, value);
			}
		}
		return result;
	}
}
