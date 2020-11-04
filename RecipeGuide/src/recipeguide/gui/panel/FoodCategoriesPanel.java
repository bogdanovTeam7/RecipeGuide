package recipeguide.gui.panel;

import java.util.List;

import recipeguide.gui.MainFrame;
import recipeguide.gui.dialog.FoodCategoryAddEditDialog;
import recipeguide.gui.table.FoodCategoryTableData;
import recipeguide.gui.toolbar.EditorToolbar;
import recipeguide.gui.toolbar.button.ButtonType;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class FoodCategoriesPanel extends RightPanel {

	private static final long serialVersionUID = 1L;

	public FoodCategoriesPanel(MainFrame frame) {
		super(frame, new FoodCategoryTableData(frame), Text.get("foodCategories"), Style.ICON_RIGHT_PANEL_FOOD_CATEGORY,
				List.of(new EditorToolbar(frame, List.of(ButtonType.ADD, ButtonType.EDIT, ButtonType.DELETE),
						List.of(ButtonType.ADD))));
	}

	@Override
	protected void init() {
		super.init();
		setDialog();
	}

	@Override
	void setDialog() {
		dialog = new FoodCategoryAddEditDialog(frame);
	}

}
