package recipeguide.saveload;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import recipeguide.exceptions.ModelException;
import recipeguide.model.Filter;
import recipeguide.model.entities.Book;
import recipeguide.model.entities.Entity;
import recipeguide.model.entities.FoodCategory;
import recipeguide.model.entities.Ingredient;
import recipeguide.model.entities.IngredientType;
import recipeguide.model.entities.MeasuryUnit;
import recipeguide.model.entities.Recipe;
import recipeguide.settings.Settings;

public final class SaveData {

	private static SaveData instance;

	private List<Ingredient> ingredients = new ArrayList<>();
	private List<IngredientType> types = new ArrayList<>();
	private List<MeasuryUnit> units = new ArrayList<>();
	private List<Recipe> recipes = new ArrayList<>();
	private List<FoodCategory> categories = new ArrayList<>();

	private Book book = new Book();

	private Filter filter;
	private Entity oldEntity;
	private boolean isSaved;

	private SaveData() {
		filter = new Filter();
		load();
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

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void add(Entity entity) throws ModelException {
		if (isEntityExist(entity)) {
			throw new ModelException(ModelException.ENTITY_EXISTS);
		} else if (entity instanceof Ingredient) {
			ingredients.add((Ingredient) entity);
		} else if (entity instanceof IngredientType) {
			types.add((IngredientType) entity);
		} else if (entity instanceof MeasuryUnit) {
			units.add((MeasuryUnit) entity);
		} else if (entity instanceof Recipe) {
			recipes.add((Recipe) entity);
		} else if (entity instanceof FoodCategory) {
			categories.add((FoodCategory) entity);
		} else if (entity instanceof Book) {
			book = new Book();
			book.setName(((Book) entity).getName());
			book.setAuthor(((Book) entity).getAuthor());
		}
		entity.postAdd();
		sort();
		isSaved = false;
	}

	public void delete(Entity entity) throws ModelException {
		if (filter.isEntityDefault(entity)) {
			throw new ModelException(ModelException.ENTITY_BASIC_INVALID_TO_DELETE);
		} else if (entity instanceof Ingredient) {
			ingredients.remove((Ingredient) entity);
		} else if (entity instanceof IngredientType) {
			types.remove((IngredientType) entity);
		} else if (entity instanceof MeasuryUnit) {
			units.remove((MeasuryUnit) entity);
		} else if (entity instanceof Recipe) {
			recipes.remove((Recipe) entity);
		} else if (entity instanceof FoodCategory) {
			categories.remove((FoodCategory) entity);
		} else if (entity instanceof Book) {
			book = new Book();
		}
		entity.postDelete();
		isSaved = false;
	}

	public void edit(Entity entityOld, Entity entityNew) throws ModelException {
		if (entityOld == null) {
			throw new ModelException(ModelException.ENTITY_TO_EDIT_DONT_CHOOSEN);

		}
		if (!entityOld.equals(entityNew) && isEntityExist(entityNew)) {
			throw new ModelException(ModelException.ENTITY_EXISTS);
		}
		if (entityNew instanceof Ingredient) {
			oldEntity = ingredients.remove(ingredients.indexOf((Ingredient) entityOld));
			ingredients.add((Ingredient) entityNew);
		} else if (entityNew instanceof IngredientType) {
			oldEntity = types.remove(types.indexOf((IngredientType) entityOld));
			types.add((IngredientType) entityNew);
		} else if (entityNew instanceof MeasuryUnit) {
			oldEntity = units.remove(units.indexOf((MeasuryUnit) entityOld));
			units.add((MeasuryUnit) entityNew);
		} else if (entityNew instanceof Recipe) {
			oldEntity = recipes.remove(recipes.indexOf((Recipe) entityOld));
			recipes.add((Recipe) entityNew);
		} else if (entityNew instanceof FoodCategory) {
			oldEntity = categories.remove(categories.indexOf((FoodCategory) entityOld));
			categories.add((FoodCategory) entityNew);
		} else if (entityNew instanceof Book) {
			oldEntity = book;
			book = new Book();
			book.setName(((Book) entityNew).getName());
			book.setAuthor(((Book) entityNew).getAuthor());
		}
		entityNew.postEdit();
		sort();
		isSaved = false;
	}

	private boolean isEntityExist(Entity entity) {
		if (entity instanceof Ingredient) {
			return ingredients.contains((Ingredient) entity);
		}
		if (entity instanceof IngredientType) {
			return types.contains((IngredientType) entity);
		}
		if (entity instanceof MeasuryUnit) {
			return units.contains((MeasuryUnit) entity);
		}
		if (entity instanceof Recipe) {
			return recipes.contains((Recipe) entity);
		}
		if (entity instanceof FoodCategory) {
			return categories.contains((FoodCategory) entity);
		}
		if (entity instanceof Book) {
			return book.equals((Book) entity);
		}
		return false;
	}

	public void clearAll() {
		ingredients.clear();
		categories.clear();
		recipes.clear();
		types.clear();
		units.clear();
		book = new Book();
		oldEntity = null;
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
		builder.append(", book=");
		builder.append(book);
		builder.append(", filter=");
		builder.append(filter);
		builder.append(", oldEntity=");
		builder.append(oldEntity);
		builder.append(", isSaved=");
		builder.append(isSaved);
		builder.append("]");
		return builder.toString();
	}

}
