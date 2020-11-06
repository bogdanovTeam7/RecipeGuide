package recipeguide.gui.panel;

import java.util.List;

import recipeguide.gui.MainFrame;
import recipeguide.gui.search.FoodCategorySearchPanel;
import recipeguide.gui.search.IngredientSearchPanel;
import recipeguide.gui.search.IngredientTypeSearchPanel;
import recipeguide.gui.search.NameSearchPanel;
import recipeguide.gui.search.PoliSearchPanel;
import recipeguide.gui.toolbar.EditorToolbar;
import recipeguide.gui.toolbar.button.ButtonType;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class SearchPanel extends RightPanel {

	private static final long serialVersionUID = 1L;

	public SearchPanel(MainFrame frame) {
		super(frame, Text.get("search"), Style.ICON_SEARCH_MAIN, List.of(new PoliSearchPanel(frame),
				new EditorToolbar(frame, List.of(ButtonType.SEARCH), List.of(ButtonType.SEARCH))));
	}

	@Override
	void setDialog() {
		// TODO Auto-generated method stub

	}

}
