package recipeguide.tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import recipeguide.model.Filter;
import recipeguide.model.Quantity;
import recipeguide.model.entities.FoodCategory;
import recipeguide.model.entities.Ingredient;
import recipeguide.model.entities.IngredientType;
import recipeguide.model.entities.MeasuryUnit;
import recipeguide.model.entities.Recipe;
import recipeguide.saveload.SaveData;
import recipeguide.settings.Settings;

public class TestDates {
	private SaveData saveData;
	private Filter filter;

	public TestDates(SaveData saveData) {
		this.saveData = saveData;
		filter = saveData.getFilter();
	}

	public void loadDates() {

		List<FoodCategory> categories = createCategories();
		List<MeasuryUnit> units = createUnits();
		List<IngredientType> types = createTypes();
		List<Ingredient> ingredients = createIngredients();
		List<Recipe> recipes = createRecipes();

		saveData.setCategories(categories);
		saveData.setIngredients(ingredients);
		saveData.setUnits(units);
		saveData.setRecipes(recipes);
		saveData.setTypes(types);

	}

	public List<IngredientType> createTypes() {
		List<IngredientType> result = new ArrayList<>();
		result.add(new IngredientType("vegetables"));
		result.add(new IngredientType("meat"));
		result.add(new IngredientType("milk product"));
		result.add(new IngredientType("spice"));
		result.add(new IngredientType("fruit"));
		return result;
	}

	public List<MeasuryUnit> createUnits() {
		List<MeasuryUnit> result = new ArrayList<>(Settings.BASIC_UNITS);
		result.add(new MeasuryUnit("mesure by eye", "approx"));
		return result;
	}

	public List<Ingredient> createIngredients() {
		List<Ingredient> result = new ArrayList<>();
		result.add(new Ingredient("potato", filter.getType("vegetables")));
		result.add(new Ingredient("egg", filter.getType("egg")));
		result.add(new Ingredient("milk", filter.getType("milk product")));
		result.add(new Ingredient("salt", filter.getType("spice")));
		result.add(new Ingredient("sugar", filter.getType("spice")));
		result.add(new Ingredient("apple", filter.getType("fruit")));
		return result;
	}

	public List<FoodCategory> createCategories() {
		List<FoodCategory> result = new ArrayList<>();
		result.add(new FoodCategory("dessert"));
		result.add(new FoodCategory("drink"));
		result.add(new FoodCategory("main dish"));
		return result;
	}

	public List<Recipe> createRecipes() {
		List<Recipe> result = new ArrayList<>();
		Map<Ingredient, Quantity> ingredientsWihQuantity = new HashMap<>();
		ingredientsWihQuantity.put(filter.getIngredient("milk"), new Quantity(filter.getMeasuryUnit("deciliter"), 2));
		ingredientsWihQuantity.put(filter.getIngredient("sugar"), new Quantity(filter.getMeasuryUnit("gram"), 5));
		result.add(Recipe.builder()
				.withCategory(filter.getCategory("drink"))
				.withCookingTime(Duration.ofMinutes(20))
				.withDescription("Very simple")
				.withIngredientsWihQuantity(ingredientsWihQuantity)
				.withName("Candy milk")
				.withPreparingTime(Duration.ofMinutes(5))
				.withRation(1)
				.build());

		ingredientsWihQuantity = new HashMap<>();
		ingredientsWihQuantity.put(filter.getIngredient("egg"), new Quantity(filter.getMeasuryUnit("piece"), 2));
		ingredientsWihQuantity.put(filter.getIngredient("salt"),
				new Quantity(filter.getMeasuryUnit("mesure by eye"), 5));
		result.add(Recipe.builder()
				.withCategory(filter.getCategory("breakfast"))
				.withCookingTime(Duration.ofMinutes(2))
				.withDescription("Just boiled")
				.withIngredientsWihQuantity(ingredientsWihQuantity)
				.withName("boiled eggs")
				.withPreparingTime(Duration.ofMinutes(1))
				.withRation(1)
				.build());

		ingredientsWihQuantity = new HashMap<>();
		ingredientsWihQuantity.put(filter.getIngredient("potato"), new Quantity(filter.getMeasuryUnit("piece"), 2));
		ingredientsWihQuantity.put(filter.getIngredient("salt"),
				new Quantity(filter.getMeasuryUnit("mesure by eye"), 5));
		ingredientsWihQuantity.put(filter.getIngredient("apple"), new Quantity(filter.getMeasuryUnit("gram"), 100));
		ingredientsWihQuantity.put(filter.getIngredient("milk"), new Quantity(filter.getMeasuryUnit("deciliter"), 3));
		ingredientsWihQuantity.put(filter.getIngredient("cocos"), new Quantity(filter.getMeasuryUnit("piece"), 5));
		result.add(Recipe.builder()
				.withCategory(filter.getCategory("main dish"))
				.withCookingTime(Duration.ofMinutes(2))
				.withDescription("Just boiled")
				.withIngredientsWihQuantity(ingredientsWihQuantity)
				.withName("Oh, my god")
				.withPreparingTime(Duration.ofMinutes(1))
				.withRation(1)
				.build());

		return result;
	}
}