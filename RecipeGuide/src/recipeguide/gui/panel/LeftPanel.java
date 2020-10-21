package recipeguide.gui.panel;

import java.awt.BorderLayout;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import recipeguide.gui.MainFrame;
import recipeguide.saveload.SaveData;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class LeftPanel extends AbstractPanel {

	private static final long serialVersionUID = 1L;

	public LeftPanel(MainFrame frame) {
		super(frame);
		init();
	}

	@Override
	protected void init() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(Style.BORDER_PANEL);

		JLabel titleLable = new JLabel(Text.get("recipeBookContains:"));
		titleLable.setFont(Style.FONT_LEFT_PANEL_TITLE);
		titleLable.setIcon(Style.ICON_LEFT_PANEL_TITLE);
		titleLable.setAlignmentX(CENTER_ALIGNMENT);
		add(titleLable);

		Map<String, Integer> dates = new LinkedHashMap<>();
		dates.put(Text.get("recipesTotal"), SaveData.getInstance()
				.getRecipes()
				.size());
		dates.put(Text.get("ingredientsTotal"), SaveData.getInstance()
				.getIngredients()
				.size());

		addInfoPanels(dates);

	}

	private void addInfoPanels(Map<String, Integer> dates) {
		for (Map.Entry<String, Integer> entry : dates.entrySet()) {
			add(Box.createVerticalStrut(Style.PADDING_LEFT_PANEL_INFO_PANEL));

			JPanel infoPanel = new JPanel(new BorderLayout());
			infoPanel.setBackground(Style.COLOR_LEFT_PANEL_INFO_PANEL);

			JLabel lable = new JLabel(entry.getKey());
			lable.setFont(Style.FONT_LEFT_PANEL_INFO_PANEL);
			lable.setBorder(Style.BORDER_PANEL);
			infoPanel.add(lable, BorderLayout.WEST);

			JTextField infoField = new JTextField("" + entry.getValue());
			infoField.setFont(Style.FONT_LEFT_PANEL_INFO_PANEL);
			infoField.setBorder(Style.BORDER_PANEL);
			infoPanel.add(infoField, BorderLayout.EAST);

			add(infoPanel);

		}
	}

}
