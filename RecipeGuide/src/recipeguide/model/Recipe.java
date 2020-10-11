package recipeguide.model;

import java.time.Duration;
import java.util.List;

import recipeguide.entities.FoodCategory;
import recipeguide.exceptions.ModalException;
import recipeguide.settings.Text;

import java.util.Collections;

public class Recipe extends AbstractDao {

	private List<IngredientInRecipe> ingredients;
	private String description;
	private FoodCategory category;
	private Duration preparingTime;
	private Duration cookingTime;

	private Recipe(Builder builder) {
		this.ingredients = builder.ingredients;
		this.description = builder.description;
		this.category = builder.category;
		this.preparingTime = builder.preparingTime;
		this.cookingTime = builder.cookingTime;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private List<IngredientInRecipe> ingredients = Collections.emptyList();
		private String description = Text.get("NoDescription");
		private FoodCategory category = FoodCategory.OTHER;
		private Duration preparingTime = Duration.ZERO;
		private Duration cookingTime = Duration.ZERO;

		private Builder() {
		}

		public Builder withIngredients(List<IngredientInRecipe> ingredients) throws ModalException {
			if (ingredients.size() < 1) {
				throw new ModalException(ModalException.INGREDIENT_LIST_EMPTY);
			}
			this.ingredients = ingredients;
			return this;
		}

		public Builder withDescription(String description) {
			this.description = description;
			return this;
		}

		public Builder withCategory(FoodCategory category) {
			this.category = category;
			return this;
		}

		public Builder withPreparingTime(Duration preparingTime) {
			this.preparingTime = preparingTime;
			return this;
		}

		public Builder withCookingTime(Duration cookingTime) {
			this.cookingTime = cookingTime;
			return this;
		}

		public Recipe build() {
			return new Recipe(this);
		}
	}

	public List<IngredientInRecipe> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientInRecipe> ingredients) {
		this.ingredients = ingredients;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public FoodCategory getCategory() {
		return category;
	}

	public void setCategory(FoodCategory category) {
		this.category = category;
	}

	public Duration getPreparingTime() {
		return preparingTime;
	}

	public void setPreparingTime(Duration preparingTime) {
		this.preparingTime = preparingTime;
	}

	public Duration getCookingTime() {
		return cookingTime;
	}

	public void setCookingTime(Duration cookingTime) {
		this.cookingTime = cookingTime;
	}

	@Override
	public String toString() {
		StringBuilder builder2 = new StringBuilder();
		builder2.append("Recipe [ingredients=");
		builder2.append(ingredients);
		builder2.append(", description=");
		builder2.append(description);
		builder2.append(", category=");
		builder2.append(category);
		builder2.append(", preparingTime=");
		builder2.append(preparingTime);
		builder2.append(", cookingTime=");
		builder2.append(cookingTime);
		builder2.append("]");
		return builder2.toString();
	}

	@Override
	public void postAdd() {
		// TODO Auto-generated method stub

	}

	@Override
	public void postEdit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void postDelete() {
		// TODO Auto-generated method stub

	}
}
