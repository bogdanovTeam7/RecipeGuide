package recipeguide.gui.search;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import recipeguide.settings.Style;

public class CheckBoxPanel<E> extends JPanel implements EnableSearchElement {

	private static final long serialVersionUID = 1L;

	private Map<E, JCheckBox> datas;
	private boolean enable;

	public CheckBoxPanel(Map<E, String> items) {
		datas = new LinkedHashMap<>();
		for (Map.Entry<E, String> entry : items.entrySet()) {
			CheckBox checkbox = new CheckBox(entry.getValue());
			checkbox.setBackground(Style.COLOR_SEARCH_MONO_PANEL);
			checkbox.setFont(Style.FONT_SEARCH_CHECK_BOX);
			datas.put(entry.getKey(), checkbox);
		}
		enable = false;

		init();
	}

	private void init() {

		setLayout(new FlowLayout(FlowLayout.LEFT, Style.PADDING_SEARCH_PANEL_HORIZONTAL,
				Style.PADDING_SEARCH_PANEL_VERTICAL));
		setFont(Style.FONT_SEARCH_PANEL);
		setBorder(Style.BORDER_PANEL);
		setBackground(Style.COLOR_SEARCH_MONO_PANEL);
		for (Map.Entry<E, JCheckBox> data : datas.entrySet()) {
			add(data.getValue());
		}

	}

	public List<E> getSelected() {
		List<E> result = new ArrayList<>();
		for (Map.Entry<E, JCheckBox> data : datas.entrySet()) {
			if (data.getValue()
					.isSelected()) {
				result.add(data.getKey());
			}
		}
		return result;
	}

	public boolean isEnable() {
		return enable;
	}

	@Override
	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	private class CheckBox extends JCheckBox {

		private static final long serialVersionUID = 1L;

		public CheckBox(String text) {
			super(text);
			setFont(Style.FONT_SEARCH_PANEL);

		}

	}

}
