package recipeguide.gui.panel;

import java.util.List;

import recipeguide.gui.MainFrame;
import recipeguide.gui.table.IngredientTableData;
import recipeguide.gui.toolbar.EditorToolbar;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class IngredientsPanel extends RightPanel {

	private static final long serialVersionUID = 1L;

	public IngredientsPanel(MainFrame frame) {
		super(frame, new IngredientTableData(), Text.get("ingredients"), Style.ICON_LEFT_PANEL_INGREDIENT,
				List.of(new EditorToolbar()));
	}

}
