package recipeguide.saveload;

import java.util.List;

import recipeguide.entities.Ingredient;
import recipeguide.model.IngredientInRecipe;
import recipeguide.model.Recipe;

public class SaveData {

	private static SaveData instance;
	private List<Ingredient> ingredients;
	private List<IngredientInRecipe> ingredientInRecipes;
	private List<Recipe> recipes;

	private SaveData() {
	}

	public SaveData getInstance() {
		if (instance == null) {
			instance = new SaveData();
		}
		return instance;
	}

}
