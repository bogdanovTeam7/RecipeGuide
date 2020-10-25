package recipeguide.gui.search.button;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import recipeguide.gui.MainButton;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class SearchButtonPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private MainButton button;

	public SearchButtonPanel() {
		setBorder(Style.BORDER_PANEL);

		String action = null;
		ImageIcon icon = Style.ICON_BUTTON_SEARCH;
		String title = Text.get("search");
		ActionListener actionListener = null;
		button = MainButton.builder()
				.withAction(action)
				.withActionListener(actionListener)
				.withIcon(icon)
				.withTitle(title)
				.build();

		add(button);
	}

}
