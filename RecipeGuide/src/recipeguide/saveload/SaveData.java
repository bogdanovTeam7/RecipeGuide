package recipeguide.saveload;

import java.util.List;

import recipeguide.entities.Ingredient;
import recipeguide.model.IngredientWithMeasure;
import recipeguide.model.Recipe;

public class SaveData {

	private static SaveData instance;
	private List<Ingredient> ingredients;
	private List<IngredientWithMeasure> ingredientWithMeasures;
	private List<Recipe> recipes;

	private SaveData() {
	}

	public static SaveData getInstance() {
		if (instance == null) {
			instance = new SaveData();
		}
		return instance;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public List<IngredientWithMeasure> getIngredientWithMeasures() {
		return ingredientWithMeasures;
	}

	public void setIngredientWithMeasures(List<IngredientWithMeasure> ingredientWithMeasures) {
		this.ingredientWithMeasures = ingredientWithMeasures;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

}
