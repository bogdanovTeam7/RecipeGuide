package recipeguide.gui.table;

import java.util.LinkedHashMap;

import recipeguide.gui.table.model.RecipeTableModel;
import recipeguide.model.entities.Recipe;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class RecipeTableData extends TableDate<Recipe> {

	private static final long serialVersionUID = 1L;

	public RecipeTableData() {
		super(new LinkedHashMap<>() {

			private static final long serialVersionUID = 1L;
			{
				put(Text.get("name"), Style.ICON_TABLE_RECIPE_NAME);
				put(Text.get("category"), Style.ICON_TABLE_RECIPE_CATEGORY);
				put(Text.get("ingredientsWithMeasure"), Style.ICON_TABLE_RECIPE_INGREDIENTS_WITH_QUANTITY);
				put(Text.get("ration"), Style.ICON_TABLE_RECIPE_RATION);
				put(Text.get("description"), Style.ICON_TABLE_RECIPE_DESCRIPTION);
				put(Text.get("preparingTimeInSeconds"), Style.ICON_TABLE_RECIPE_TIME);
				put(Text.get("cookingTimeInSeconds"), Style.ICON_TABLE_COOKING_TIME);
			}
		}, new RecipeTableModel());
	}

}
