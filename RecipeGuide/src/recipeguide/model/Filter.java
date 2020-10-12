package recipeguide.model;

import java.util.ArrayList;
import java.util.List;

import recipeguide.entities.FoodCategory;
import recipeguide.entities.Ingredient;
import recipeguide.entities.IngredientType;
import recipeguide.saveload.SaveData;

public class Filter {

	private SaveData saveData = SaveData.getInstance();

	public List<Recipe> getRecipesByCategory(FoodCategory category) {
		List<Recipe> result = new ArrayList<>();
		for (Recipe recipe : saveData.getRecipes()) {
			if (recipe.getCategory()
					.equals(category)) {
				result.add(recipe);
			}
		}
		return result;
	}

	public List<Recipe> getRecipesByIngredientType(IngredientType type) {
		List<Recipe> result = new ArrayList<>();
		for (Recipe recipe : saveData.getRecipes()) {
			for (IngredientType iType : recipe.getIngredientTypes()) {
				if (iType.equals(type)) {
					result.add(recipe);
				}
			}
		}
		return result;
	}

	public List<Recipe> getRecipesByIngredient(Ingredient ingredient) {
		List<Recipe> result = new ArrayList<>();
		for (Recipe recipe : saveData.getRecipes()) {
			for (Ingredient ing : recipe.getIngredients()) {
				if (ing.equals(ingredient)) {
					result.add(recipe);
				}
			}
		}
		return result;
	}

}
