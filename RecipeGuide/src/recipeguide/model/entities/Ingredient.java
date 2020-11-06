package recipeguide.model.entities;

import recipeguide.saveload.SaveData;

public class Ingredient extends AbstractEntity {

	private IngredientType type;

	public Ingredient() {
	}

	public Ingredient(String name, IngredientType type) {
		super.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		super.name = name;
	}

	public IngredientType getType() {
		return type;
	}

	public void setType(IngredientType type) {
		this.type = type;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Ingredient)) {
			return false;
		}
		return name.equals(((Ingredient) obj).getName());
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

	@Override
	public void postEdit() {
		for (Ingredient ingredient : SaveData.getInstance()
				.getIngredients()) {
			if (ingredient.equals((Ingredient) SaveData.getInstance()
					.getOldEntity())) {
//				ingredient
			}
		}
	}

	@Override
	public void postDelete() {
		// TODO Auto-generated method stub
		super.postDelete();
	}

}
