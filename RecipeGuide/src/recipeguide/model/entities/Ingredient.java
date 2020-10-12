package recipeguide.model.entities;

import recipeguide.model.AbstractEntity;

public class Ingredient extends AbstractEntity {

	private String name;
	private IngredientType type;

	public Ingredient() {
	}

	public Ingredient(String name, IngredientType type) {
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IngredientType getType() {
		return type;
	}

	public void setType(IngredientType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ingredient [name=");
		builder.append(name);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}

}
