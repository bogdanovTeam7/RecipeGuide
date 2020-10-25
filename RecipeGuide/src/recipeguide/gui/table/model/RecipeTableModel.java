package recipeguide.gui.table.model;

import recipeguide.model.entities.Recipe;
import recipeguide.saveload.SaveData;
import recipeguide.settings.Format;

public class RecipeTableModel extends MainTableModel<Recipe> {

	private static final long serialVersionUID = 1L;

	private static final int name = 0;
	private static final int category = 1;
	private static final int ingredientsWihQuantity = 2;
	private static final int ration = 3;
	private static final int description = 4;
	private static final int preparingTimeInSeconds = 5;
	private static final int cookingTimeInSeconds = 6;

	public RecipeTableModel() {
		super(SaveData.getInstance()
				.getRecipes());
	}

	@Override
	public Object getValueAt(int row, int column) {
		if (datas.isEmpty()) {
			return null;
		}
		Recipe recipe = datas.get(row);
		switch (column) {
		case name:
			return recipe.getName();
		case category:
			return recipe.getCategory()
					.getName();
		case ingredientsWihQuantity:
			return recipe.printIngredientsWithQuantity();
		case ration:
			return recipe.getRation();
		case preparingTimeInSeconds:
			return Format.getTime(recipe.getPreparingTimeInSeconds());
		case cookingTimeInSeconds:
			return Format.getTime(recipe.getCookingTimeInSeconds());
		case description:
			return recipe.getDescription();
		default:
			return null;
		}

	}

	@Override
	protected void updateData() {
		datas = SaveData.getInstance()
				.getRecipes();
	}

}
