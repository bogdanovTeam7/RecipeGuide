package recipeguide.entities;

public enum IngredientType {
	RED_MEAT,
	POULTRY,
	EGGS,
	FISH_AND_SEA_PRODUCT,
	MILK_PRODUCT,
	CEREALS,
	VEGETABLES,
	MUSHROOM,
	FRUIT,
	SEED,
	SPICE,
	MINERAL,
	OTHER;

	public static boolean isVega(Ingredient ingredient) {
		return IngredientType.VEGETABLES.equals(ingredient.getType())
				|| IngredientType.FRUIT.equals(ingredient.getType()) || IngredientType.SEED.equals(ingredient.getType())
				|| IngredientType.SPICE.equals(ingredient.getType())
				|| IngredientType.MINERAL.equals(ingredient.getType())
				|| IngredientType.CEREALS.equals(ingredient.getType())
				|| IngredientType.MUSHROOM.equals(ingredient.getType());
	}

	public static boolean isCerealsFree(Ingredient ingredient) {
		return !IngredientType.CEREALS.equals(ingredient.getType());
	}

	public static boolean isLactoseFree(Ingredient ingredient) {
		return !IngredientType.MILK_PRODUCT.equals(ingredient.getType());
	}
}
