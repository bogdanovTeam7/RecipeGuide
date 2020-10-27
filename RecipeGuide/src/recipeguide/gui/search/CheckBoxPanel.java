package recipeguide.gui.search;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import recipeguide.gui.Refresh;
import recipeguide.gui.search.checkboxdatas.CheckBoxData;
import recipeguide.settings.Style;

public class CheckBoxPanel<E> extends JPanel implements EnableSearchElement, Refresh {

	private static final long serialVersionUID = 1L;

	private Map<E, JCheckBox> datas;
	private CheckBoxData<E> boxData;
	private boolean enable;

	public CheckBoxPanel(CheckBoxData<E> boxData) {
		this.boxData = boxData;

		init();
	}

	public void setDatasFromBoxDatas() {
		datas = new LinkedHashMap<>();
		for (Map.Entry<E, String> entry : boxData.getData()
				.entrySet()) {
			CheckBox checkbox = new CheckBox(entry.getValue());
			checkbox.setBackground(Style.COLOR_SEARCH_MONO_PANEL);
			checkbox.setFont(Style.FONT_SEARCH_CHECK_BOX);
			datas.put(entry.getKey(), checkbox);
		}
	}

	private void init() {

		setDatasFromBoxDatas();
		enable = false;

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

	@Override
	public void refresh() {
		init();
	}

}
