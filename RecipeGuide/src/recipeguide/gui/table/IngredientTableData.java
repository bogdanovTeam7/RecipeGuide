package recipeguide.gui.table;

import java.util.LinkedHashMap;

import recipeguide.gui.table.model.IngredientsTableModel;
import recipeguide.model.entities.Ingredient;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class IngredientTableData extends TableDate<Ingredient> {

	private static final long serialVersionUID = 1L;

	public IngredientTableData() {
		super(new LinkedHashMap<>() {

			private static final long serialVersionUID = 1L;
			{
				put(Text.get("ingredientName"), Style.ICON_TABLE_INGREDIENT_NAME);
				put(Text.get("ingredientType"), Style.ICON_TABLE_INGREDIENT_TYPE);
			}

		}, new IngredientsTableModel());
	}

}
