package recipeguide.gui.search;

import recipeguide.gui.MainFrame;
import recipeguide.gui.search.checkboxdatas.IngredientTypeCheckBoxData;
import recipeguide.settings.Text;

public class IngredientTypeSearchPanel extends MonoSearchPanel {

	private static final long serialVersionUID = 1L;

	public IngredientTypeSearchPanel(MainFrame frame) {
		super(frame,Text.get("ingredientType"), new CheckBoxPanel<>(new IngredientTypeCheckBoxData()));
	}

}
