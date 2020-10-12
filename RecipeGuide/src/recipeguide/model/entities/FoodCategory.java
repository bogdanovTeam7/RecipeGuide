package recipeguide.model.entities;

import recipeguide.model.AbstractEntity;

public class FoodCategory extends AbstractEntity {
	private String name;

	public FoodCategory() {
	}

	public FoodCategory(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FoodCategory [name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

}
