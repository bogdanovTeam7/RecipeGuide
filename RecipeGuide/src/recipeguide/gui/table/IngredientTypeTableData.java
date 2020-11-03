package recipeguide.gui.table;

import java.util.LinkedHashMap;

import recipeguide.gui.MainFrame;
import recipeguide.gui.table.model.IngredientTypesTableModel;
import recipeguide.model.entities.IngredientType;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class IngredientTypeTableData extends TableDate<IngredientType> {

	private static final long serialVersionUID = 1L;

	public IngredientTypeTableData(MainFrame frame) {
		super(frame, new LinkedHashMap<>() {

			private static final long serialVersionUID = 1L;
			{
				put(Text.get("ingredientTypes"), Style.ICON_TABLE_INGREDIENT_TYPE_NAME);
			}

		}, new IngredientTypesTableModel());
	}

}
