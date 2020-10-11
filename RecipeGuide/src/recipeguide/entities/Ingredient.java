package recipeguide.entities;

import recipeguide.exceptions.ModalException;

public class Ingredient extends AbstractIngredient {

	public Ingredient(IngredientType type, String name) throws ModalException {
		if (name == null || name.length() < 1) {
			throw new ModalException(ModalException.TITLE_EMPTY);
		}
		if (type == null) {
			throw new ModalException(ModalException.TYPE_EMPTY);
		}
		super.type = type;
		super.name = name;
	}

	public IngredientType getType() {
		return type;
	}

	public void setType(IngredientType type) {
		super.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		super.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ingredient [type=");
		builder.append(type);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

}
