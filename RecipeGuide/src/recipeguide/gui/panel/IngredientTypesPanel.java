package recipeguide.gui.panel;

import java.util.List;

import recipeguide.gui.MainFrame;
import recipeguide.gui.table.IngredientTypeTableData;
import recipeguide.gui.toolbar.EditorToolbar;
import recipeguide.gui.toolbar.button.ButtonType;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class IngredientTypesPanel extends RightPanel {

	private static final long serialVersionUID = 1L;

	public IngredientTypesPanel(MainFrame frame) {
		super(frame, new IngredientTypeTableData(), Text.get("ingredientTypes"), Style.ICON_RIGHT_PANEL_INGREDIENT_TYPE,
				List.of(new EditorToolbar(List.of(ButtonType.ADD, ButtonType.EDIT, ButtonType.DELETE))));
	}

}
