package recipeguide.gui.panel;

import java.util.List;

import recipeguide.gui.MainFrame;
import recipeguide.gui.table.RecipeTableData;
import recipeguide.gui.toolbar.EditorToolbar;
import recipeguide.gui.toolbar.button.ButtonType;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class RecipePanel extends RightPanel {

	private static final long serialVersionUID = 1L;

	public RecipePanel(MainFrame frame) {
		super(frame, new RecipeTableData(), Text.get("recipes"), Style.ICON_RIGHT_PANEL_RECIPE,
				List.of(new EditorToolbar(List.of(ButtonType.ADD, ButtonType.EDIT, ButtonType.DELETE))));
	}

}
