package recipeguide.entities;

import recipeguide.Description;

public abstract class AbstractIngredient implements Description {
	protected IngredientType type;
	protected String name;

	public String getDescription() {
		return name;
	}
}
