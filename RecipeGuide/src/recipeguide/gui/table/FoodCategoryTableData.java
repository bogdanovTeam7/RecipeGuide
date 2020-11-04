package recipeguide.gui.table;

import java.util.LinkedHashMap;

import recipeguide.gui.MainFrame;
import recipeguide.gui.table.model.FoodCategoriesTableModel;
import recipeguide.model.entities.FoodCategory;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class FoodCategoryTableData extends TableDate<FoodCategory> {

	private static final long serialVersionUID = 1L;

	public FoodCategoryTableData(MainFrame frame) {
		super(frame, new LinkedHashMap<>() {

			private static final long serialVersionUID = 1L;
			{
				put(Text.get("foodCategory"), Style.ICON_TABLE_FOOD_CATEGORY_NAME);
			}

		}, new FoodCategoriesTableModel());
	}
}
