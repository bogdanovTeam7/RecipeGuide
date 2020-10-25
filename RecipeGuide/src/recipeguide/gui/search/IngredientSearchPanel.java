package recipeguide.gui.search;

import recipeguide.gui.search.checkboxdatas.IngredientCheckBoxData;
import recipeguide.settings.Text;

public class IngredientSearchPanel extends MonoSearchPanel {

	private static final long serialVersionUID = 1L;

	public IngredientSearchPanel() {
		super(Text.get("ingredient"), new CheckBoxPanel<>(new IngredientCheckBoxData().getData()));
	}

}
