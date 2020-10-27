
package recipeguide.saveload;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import recipeguide.model.entities.Book;
import recipeguide.model.entities.FoodCategory;
import recipeguide.model.entities.Ingredient;
import recipeguide.model.entities.IngredientType;
import recipeguide.model.entities.MeasuryUnit;
import recipeguide.model.entities.Recipe;

@XmlRootElement(name = "data")
public class Wrapper {

	private List<Ingredient> ingredients = new ArrayList<>();
	private List<IngredientType> types = new ArrayList<>();
	private List<MeasuryUnit> units = new ArrayList<>();
	private List<Recipe> recipes = new ArrayList<>();
	private List<FoodCategory> categories = new ArrayList<>();
	private Book book = new Book();

	public Wrapper() {
	}

	@XmlElement(name = "ingredients")
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@XmlElement(name = "types")
	public List<IngredientType> getTypes() {
		return types;
	}

	public void setTypes(List<IngredientType> types) {
		this.types = types;
	}

	@XmlElement(name = "units")
	public List<MeasuryUnit> getUnits() {
		return units;
	}

	public void setUnits(List<MeasuryUnit> units) {
		this.units = units;
	}

	@XmlElement(name = "recipes")
	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	@XmlElement(name = "categories")
	public List<FoodCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<FoodCategory> categories) {
		this.categories = categories;
	}

	@XmlElement(name = "book")
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
