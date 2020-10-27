package recipeguide.gui.search;

import recipeguide.gui.MainFrame;
import recipeguide.gui.search.checkboxdatas.IngredientCheckBoxData;
import recipeguide.settings.Text;

public class IngredientSearchPanel extends MonoSearchPanel {

	private static final long serialVersionUID = 1L;

	public IngredientSearchPanel(MainFrame frame) {
		super(frame, Text.get("ingredient"), new CheckBoxPanel<>(new IngredientCheckBoxData()));
	}

}
