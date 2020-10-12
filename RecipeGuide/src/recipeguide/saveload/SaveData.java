package recipeguide.saveload;

import java.util.Comparator;
import java.util.List;

import recipeguide.exceptions.ModalException;
import recipeguide.model.Entity;
import recipeguide.model.Filter;
import recipeguide.model.entities.FoodCategory;
import recipeguide.model.entities.Ingredient;
import recipeguide.model.entities.IngredientType;
import recipeguide.model.entities.MeasuryUnit;
import recipeguide.model.entities.Recipe;
import recipeguide.settings.Settings;

public final class SaveData {

	private static SaveData instance;

	private List<Ingredient> ingredients;
	private List<IngredientType> types;
	private List<MeasuryUnit> units;
	private List<Recipe> recipes;
	private List<FoodCategory> categories;

	private final Filter filter;
	private Entity oldEntity;
	private boolean isSaved;

	private SaveData() {
		load();
		filter = new Filter();
	}

	public static SaveData getInstance() {
		if (instance == null) {
			instance = new SaveData();
		}
		return instance;
	}

	public void load() {
		SaveLoad.load(this);
		sort();
	}

	private void sort() {
		ingredients.sort((i1, i2) -> i1.getName()
				.compareToIgnoreCase(i2.getName()));
		types.sort((t1, t2) -> t1.getName()
				.compareToIgnoreCase(t2.getName()));
		units.sort(new Comparator<MeasuryUnit>() {

			@Override
			public int compare(MeasuryUnit u1, MeasuryUnit u2) {
				if (Settings.BASIC_UNITS.contains(u1) && Settings.BASIC_UNITS.contains(u2)) {
					return Integer.valueOf((Settings.BASIC_UNITS.indexOf(u1)))
							.compareTo(Integer.valueOf(Settings.BASIC_UNITS.indexOf(u2)));
				}
				if (Settings.BASIC_UNITS.contains(u1)) {
					return -1;
				}
				if (Settings.BASIC_UNITS.contains(u2)) {
					return -1;
				}
				return u1.getName()
						.compareToIgnoreCase(u2.getName());
			}

		});

		recipes.sort((r1, r2) -> r1.getName()
				.compareToIgnoreCase(r2.getName()));
		categories.sort((c1, c2) -> c1.getName()
				.compareToIgnoreCase(c2.getName()));
	}

	public void save() {
		SaveLoad.save(this);
		isSaved = true;
	}

	public Entity getOldEntity() {
		return oldEntity;
	}

	public void setOldEntity(Entity oldEntity) {
		this.oldEntity = oldEntity;
	}

	public boolean isSaved() {
		return isSaved;
	}

	public void setSaved(boolean isSaved) {
		this.isSaved = isSaved;
	}

	public Filter getFilter() {
		return filter;
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

	public void add(Entity entity, List<Entity> entities) throws ModalException {
		if (entities.contains(entity)) {
			throw new ModalException(ModalException.IS_EXIST);
		} else {
			entities.add(entity);
		}
		entity.postAdd();
		sort();
		isSaved = false;
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
