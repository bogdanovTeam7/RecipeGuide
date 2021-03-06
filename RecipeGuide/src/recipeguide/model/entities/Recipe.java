package recipeguide.model.entities;

import java.time.Duration;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import recipeguide.model.Quantity;
import recipeguide.settings.Text;

import java.util.Collections;

public class Recipe extends AbstractEntity {

	private FoodCategory category;
	private Map<Ingredient, Quantity> ingredientsWihQuantity;
	private int ration;
	private String description;
	private long preparingTimeInSeconds;
	private long cookingTimeInSeconds;

	public Recipe() {
	}

	private Recipe(Builder builder) {
		super.name = builder.name;
		this.category = builder.category;
		this.ingredientsWihQuantity = builder.ingredientsWihQuantity;
		this.ration = builder.ration;
		this.description = builder.description;
		if (builder.preparingTime != null) {
			this.preparingTimeInSeconds = builder.preparingTime.toSeconds();
		}
		if (builder.cookingTime != null) {
			this.cookingTimeInSeconds = builder.cookingTime.toSeconds();
		}
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String name;
		private FoodCategory category;
		private Map<Ingredient, Quantity> ingredientsWihQuantity = Collections.emptyMap();
		private int ration;
		private String description;
		private Duration preparingTime;
		private Duration cookingTime;

		private Builder() {
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withCategory(FoodCategory category) {
			this.category = category;
			return this;
		}

		public Builder withIngredientsWihQuantity(Map<Ingredient, Quantity> ingredientsWihQuantity) {
			this.ingredientsWihQuantity = ingredientsWihQuantity;
			return this;
		}

		public Builder withRation(int ration) {
			this.ration = ration;
			return this;
		}

		public Builder withDescription(String description) {
			this.description = description;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FoodCategory getCategory() {
		return category;
	}

	public void setCategory(FoodCategory category) {
		this.category = category;
	}

	public Map<Ingredient, Quantity> getIngredientsWihQuantity() {
		return ingredientsWihQuantity;
	}

	public void setIngredientsWihQuantity(Map<Ingredient, Quantity> ingredientsWihQuantity) {
		this.ingredientsWihQuantity = ingredientsWihQuantity;
	}

	public int getRation() {
		return ration;
	}

	public void setRation(int ration) {
		this.ration = ration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getPreparingTimeInSeconds() {
		return preparingTimeInSeconds;
	}

	public void setPreparingTimeInSeconds(long preparingTimeInSeconds) {
		this.preparingTimeInSeconds = preparingTimeInSeconds;
	}

	public long getCookingTimeInSeconds() {
		return cookingTimeInSeconds;
	}

	public void setCookingTimeInSeconds(long cookingTimeInSeconds) {
		this.cookingTimeInSeconds = cookingTimeInSeconds;
	}

	public Set<IngredientType> getIngredientTypes() {
		Set<IngredientType> types = ingredientsWihQuantity.entrySet()
				.stream()
				.map(e -> e.getKey()
						.getType())
				.collect(Collectors.toSet());
		return types;
	}

	public Set<Ingredient> getIngredients() {
		Set<Ingredient> ingredients = ingredientsWihQuantity.entrySet()
				.stream()
				.map(e -> e.getKey())
				.collect(Collectors.toSet());
		return ingredients;
	}

	public void changeMeasuryUnits(MeasuryUnit unitOld, MeasuryUnit unitNew) {
		for (Map.Entry<Ingredient, Quantity> entry : ingredientsWihQuantity.entrySet()) {
			if (entry.getValue()
					.getUnit()
					.equals(unitOld)) {
				Ingredient key = entry.getKey();
				Quantity newValue = new Quantity(unitNew, 0);
				ingredientsWihQuantity.put(key, newValue);
			}
		}
	}

	public void changeIngredient(Ingredient ingredientOld, Ingredient ingredientNew) {
		for (Map.Entry<Ingredient, Quantity> entry : ingredientsWihQuantity.entrySet()) {
			if (entry.getKey()
					.equals(ingredientOld)) {
				Ingredient newKey = ingredientNew;
				Quantity value = ingredientsWihQuantity.remove(entry.getKey());
				ingredientsWihQuantity.put(newKey, value);
			}
		}
	}

	public String printIngredientsWithQuantity() {
		if (ingredientsWihQuantity.isEmpty()) {
			return "";
		}
		StringBuilder result = new StringBuilder();
		for (Map.Entry<Ingredient, Quantity> entry : ingredientsWihQuantity.entrySet()) {
			result.append(", ")
					.append(entry.getKey()
							.getName())
					.append(" ")
					.append(entry.getValue())
					.append("\n");
		}
		return result.substring(2)
				.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Recipe)) {
			return false;
		}
		Recipe other = (Recipe) obj;
		return Objects.equals(name, other.getName());
	}

	@Override
	public String toString() {
		StringBuilder text = new StringBuilder();
		text.append(name);
		text.append("\n\n");
		text.append(Text.get("category"));
		text.append(": ");
		text.append(category.getName());
		text.append("\n");
		text.append(Text.get("ration"));
		text.append(": ");
		text.append(ration);
		text.append("\n");
		text.append(Text.get("preparingTime"));
		text.append(": ");
		text.append(preparingTimeInSeconds);
		text.append("\n");
		text.append(Text.get("cookingTime"));
		text.append(": ");
		text.append(cookingTimeInSeconds);
		text.append("\n");
		text.append(Text.get("ingredientsWithMeasure"));
		text.append(":\n");

		for (Map.Entry<Ingredient, Quantity> entry : ingredientsWihQuantity.entrySet()) {
			text.append("\t");
			text.append(entry.getKey()
					.getNameToDisplay());
			text.append(": ");
			text.append(entry.getValue()
					.getAmount());
			text.append(" ");
			text.append(entry.getValue()
					.getUnit()
					.getNameToDisplay());
			text.append("\n");
		}
		text.append(Text.get("description"));
		text.append(":\n\t");
		text.append(description);
		return text.toString();
	}

}
