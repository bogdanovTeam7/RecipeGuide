package recipeguide.gui.search;

import recipeguide.gui.search.textfielddata.TextFieldForSearch;
import recipeguide.settings.Text;

public class NameSearchPanel extends MonoSearchPanel {

	private static final long serialVersionUID = 1L;

	public NameSearchPanel() {
		super(Text.get("name"), new TextFieldForSearch());
	}

}
