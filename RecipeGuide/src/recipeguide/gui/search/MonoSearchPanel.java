package recipeguide.gui.search;

import java.awt.FlowLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import recipeguide.settings.Style;

abstract public class MonoSearchPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	protected String labelText;
	protected JComponent component;

	public MonoSearchPanel(String labelText, JComponent component) {
		this.labelText = labelText;
		this.component = component;
		init();
	}

	protected void init() {
		setLayout(new FlowLayout(FlowLayout.LEFT, Style.PADDING_SEARCH_PANEL_HORIZONTAL,
				Style.PADDING_SEARCH_PANEL_VERTICAL));
		setFont(Style.FONT_SEARCH_PANEL);
		setBorder(Style.BORDER_PANEL);
		setBackground(Style.COLOR_SEARCH_MONO_PANEL);

		JLabel label = new JLabel(labelText);
		label.setFont(Style.FONT_SEARCH_PANEL);
		label.setIcon(Style.ICON_SEARCH_NAME);

		add(label);
		add(component);

	}

}
