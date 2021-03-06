package recipeguide.gui.panel;

import java.util.List;

import recipeguide.gui.MainFrame;
import recipeguide.gui.dialog.IngredientAddEditDialog;
import recipeguide.gui.table.IngredientTableData;
import recipeguide.gui.toolbar.EditorToolbar;
import recipeguide.gui.toolbar.button.ButtonType;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class IngredientsPanel extends RightPanel {

	private static final long serialVersionUID = 1L;

	public IngredientsPanel(MainFrame frame) {
		super(frame, new IngredientTableData(frame), Text.get("ingredients"), Style.ICON_RIGHT_PANEL_INGREDIENT,
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
		dialog = new IngredientAddEditDialog(frame);
	}
}
