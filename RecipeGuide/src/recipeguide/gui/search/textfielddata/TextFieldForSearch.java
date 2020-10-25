package recipeguide.gui.search.textfielddata;

import javax.swing.JTextField;

import recipeguide.settings.Style;

public class TextFieldForSearch extends JTextField {

	private static final long serialVersionUID = 1L;

	public TextFieldForSearch() {
		setPreferredSize(Style.DIMENSION_SEARCH_TEXT_FIELD);
		setFont(Style.FONT_SEARCH_PANEL);
	}

}
