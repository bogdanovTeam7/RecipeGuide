package recipeguide.gui.search;

import recipeguide.gui.search.checkboxdatas.IngredientTypeCheckBoxData;
import recipeguide.settings.Text;

public class IngredientTypeSearchPanel extends MonoSearchPanel {

	private static final long serialVersionUID = 1L;

	public IngredientTypeSearchPanel() {
		super(Text.get("ingredientType"), new CheckBoxPanel<>(new IngredientTypeCheckBoxData().getData()));
	}

}
