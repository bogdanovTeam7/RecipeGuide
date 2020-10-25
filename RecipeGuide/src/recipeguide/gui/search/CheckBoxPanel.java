package recipeguide.gui.search;

import java.awt.Component;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import recipeguide.settings.Style;

public class CheckBoxPanel<E> extends JPanel {

	private static final long serialVersionUID = 1L;

	private List<E> items;
	private List<JCheckBox> boxes;

	public CheckBoxPanel(List<E> items) {
		this.items = items;
		init();
	}

	private void init() {

		setLayout(new FlowLayout(FlowLayout.LEFT, Style.PADDING_SEARCH_PANEL_HORIZONTAL,
				Style.PADDING_SEARCH_PANEL_VERTICAL));
		setFont(Style.FONT_SEARCH_PANEL);
		setBorder(Style.BORDER_PANEL);
		for (E item : items) {
			JCheckBox component = new JCheckBox("item ???");
			boxes.add(component);
			add(component);
		}

	}

	public List<E> getSelected() {
		List<E> result = new ArrayList<>();
		for (JCheckBox box : boxes) {
			if (box.isSelected()) {

			}
		}
		;
	}
}
