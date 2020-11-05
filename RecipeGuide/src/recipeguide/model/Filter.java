package recipeguide.model;

import java.util.ArrayList;
import java.util.List;

import recipeguide.model.entities.Entity;
import recipeguide.model.entities.FoodCategory;
import recipeguide.model.entities.Ingredient;
import recipeguide.model.entities.IngredientType;
import recipeguide.model.entities.MeasuryUnit;
import recipeguide.model.entities.Recipe;
import recipeguide.saveload.SaveData;
import recipeguide.settings.Settings;

public class Filter {

	public Filter() {
	}

	public IngredientType getType(String name) {
		for (IngredientType type : SaveData.getInstance()
				.getTypes()) {
			if (type.getName()
					.equals(name)) {
				return type;
			}
		}
		return Settings.INGREDIENT_TYPE_DEFAULT;
	}

	public FoodCategory getCategory(String name) {
		for (FoodCategory category : SaveData.getInstance()
				.getCategories()) {
			if (category.getName()
					.equals(name)) {
				return category;
			}
		}
		return Settings.FOOD_CATEGORY_DEFAULT;
	}

	public List<Recipe> getRecipesByCategory(FoodCategory category) {
		List<Recipe> result = new ArrayList<>();
		for (Recipe recipe : SaveData.getInstance()
				.getRecipes()) {
			if (recipe.getCategory()
					.equals(category)) {
				result.add(recipe);
			}
		}
		return result;
	}

	public List<Recipe> getRecipesByIngredientType(IngredientType type) {
		List<Recipe> result = new ArrayList<>();
		for (Recipe recipe : SaveData.getInstance()
				.getRecipes()) {
			for (IngredientType iType : recipe.getIngredientTypes()) {
				if (iType.equals(type)) {
					result.add(recipe);
				}
			}
		}
		return result;
	}

	public List<Ingredient> getIngredientsByIngredientType(IngredientType type) {
		List<Ingredient> result = new ArrayList<>();
		for (Ingredient ingredient : SaveData.getInstance()
				.getIngredients()) {
			if (ingredient.getType()
					.equals(type)) {
				result.add(ingredient);
			}
		}
		return result;
	}

	public List<Recipe> getRecipesByIngredient(Ingredient ingredient) {
		List<Recipe> result = new ArrayList<>();
		for (Recipe recipe : SaveData.getInstance()
				.getRecipes()) {
			for (Ingredient ing : recipe.getIngredients()) {
				if (ing.equals(ingredient)) {
					result.add(recipe);
				}
			}
		}
		return result;
	}

	public Ingredient getIngredient(String name) {
		for (Ingredient ingredient : SaveData.getInstance()
				.getIngredients()) {
			if (ingredient.getName()
					.equals(name)) {
				return ingredient;
			}
		}
		return Settings.INGREDIENT_DEFAULT;
	}

	public MeasuryUnit getMeasuryUnit(String name) {
		for (MeasuryUnit unit : SaveData.getInstance()
				.getUnits()) {
			if (unit.getName()
					.equals(name)) {
				return unit;
			}
		}
		return Settings.MEASURY_UNIT_DEFAULT;
	}

	public List<Entity> getDefaultEnteties() {
		List<Entity> result = new ArrayList<>();
		result.add(Settings.FOOD_CATEGORY_DEFAULT);
		result.add(Settings.INGREDIENT_DEFAULT);
		result.add(Settings.INGREDIENT_TYPE_DEFAULT);
		result.add(Settings.MEASURY_UNIT_DEFAULT);
		result.addAll(Settings.BASIC_UNITS);
		return result;
	}

	public boolean isEntityDefault(Entity entity) {
		return getDefaultEnteties().contains(entity);
	}

	public List<Recipe> getRecipesByMesuryUnit(MeasuryUnit measuryUnit) {
		List<Recipe> result = new ArrayList<>();
		for (Recipe recipe : SaveData.getInstance()
				.getRecipes()) {
			for (Quantity quantity : recipe.getIngredientsWihQuantity()
					.values()) {
				if (quantity.getUnit()
						.equals(measuryUnit)) {
					result.add(recipe);
				}
			}
		}
		return result;
	}

}
