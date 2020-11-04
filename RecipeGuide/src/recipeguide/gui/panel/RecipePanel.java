package recipeguide.gui.panel;

import java.util.List;

import recipeguide.gui.MainFrame;
import recipeguide.gui.dialog.RecipeAddEditDialog;
import recipeguide.gui.table.RecipeTableData;
import recipeguide.gui.toolbar.EditorToolbar;
import recipeguide.gui.toolbar.button.ButtonType;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class RecipePanel extends RightPanel {

	private static final long serialVersionUID = 1L;

	public RecipePanel(MainFrame frame) {
		super(frame, new RecipeTableData(frame), Text.get("recipes"), Style.ICON_RIGHT_PANEL_RECIPE,
				List.of(new EditorToolbar(frame,
						List.of(ButtonType.ADD, ButtonType.DETAILS_OVERVIEW, ButtonType.EDIT, ButtonType.DELETE),
						List.of(ButtonType.ADD))));
	}

	@Override
	protected void init() {
		super.init();
		setDialog();
	}

	@Override
	void setDialog() {
		dialog = new RecipeAddEditDialog(frame);
	}
}
