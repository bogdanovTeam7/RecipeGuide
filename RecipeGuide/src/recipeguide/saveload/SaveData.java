package recipeguide.saveload;

import java.util.List;

import recipeguide.model.entities.FoodCategory;
import recipeguide.model.entities.Ingredient;
import recipeguide.model.entities.IngredientType;
import recipeguide.model.entities.MeasuryUnit;
import recipeguide.model.entities.Recipe;

public class SaveData {

	private static SaveData instance;

	private List<Ingredient> ingredients;
	private List<IngredientType> types;
	private List<MeasuryUnit> units;
	private List<Recipe> recipes;
	private List<FoodCategory> categories;

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

	public List<IngredientType> getTypes() {
		return types;
	}

	public void setTypes(List<IngredientType> types) {
		this.types = types;
	}

	public List<MeasuryUnit> getUnits() {
		return units;
	}

	public void setUnits(List<MeasuryUnit> units) {
		this.units = units;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	public List<FoodCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<FoodCategory> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SaveData [ingredients=");
		builder.append(ingredients);
		builder.append(", types=");
		builder.append(types);
		builder.append(", units=");
		builder.append(units);
		builder.append(", recipes=");
		builder.append(recipes);
		builder.append(", categories=");
		builder.append(categories);
		builder.append("]");
		return builder.toString();
	}

}
