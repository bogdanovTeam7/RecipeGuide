package recipeguide.gui.search;

import recipeguide.gui.MainFrame;
import recipeguide.gui.search.checkboxdatas.FoodCategoryCheckBoxData;
import recipeguide.settings.Text;

public class FoodCategorySearchPanel extends MonoSearchPanel {

	private static final long serialVersionUID = 1L;

	public FoodCategorySearchPanel(MainFrame frame) {
		super(frame, Text.get("category"), new CheckBoxPanel<>(new FoodCategoryCheckBoxData()));
	}

}
