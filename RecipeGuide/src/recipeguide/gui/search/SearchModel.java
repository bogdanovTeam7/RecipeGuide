package recipeguide.gui.search;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import recipeguide.gui.MainButton;
import recipeguide.gui.MainFrame;
import recipeguide.gui.panel.AbstractPanel;
import recipeguide.model.entities.FoodCategory;
import recipeguide.model.entities.Ingredient;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class SearchModel extends AbstractPanel {

	private static final long serialVersionUID = 1L;

	private JLabel nameLabel;
	private JTextField nameText;
	
	private JLabel categoryLabel;
	private CheckBoxPanel categoryPanel;
	private JComboBox<FoodCategory> categoryBox;
	
	private JLabel ingredientLabel;
	private JComboBox<Ingredient> ingredientBox;
	
	private JLabel ingredientTypeLabel;
	private JComboBox<Ingredient> ingredientTypeBox;
	
	private MainButton searchButton;

	public SearchModel(MainFrame frame) {
		super(frame);
		init();
	}

	@Override
	protected void init() {
		nameLabel = new JLabel(Text.get("name"));
		nameLabel.setFont(Style.FONT_SEARCH_PANEL);
		nameLabel.setIcon(Style.ICON_SEARCH_NAME);

		nameText = new JTextField();
		setFont(Style.FONT_SEARCH_PANEL);

		categoryLabel = new JLabel(Text.get("category"));
		categoryLabel.setFont(Style.FONT_SEARCH_PANEL);
		categoryLabel.setIcon(Style.ICON_SEARCH_CATEGORY);
		
		

		ingredientLabel = new JLabel(Text.get("ingredient"));
		ingredientLabel.setFont(Style.FONT_SEARCH_PANEL);
		ingredientLabel.setIcon(Style.ICON_SEARCH_INGREDIENT);
		
		ingredientTypeLabel = new JLabel(Text.get("ingredientType"));
		ingredientTypeLabel.setFont(Style.FONT_SEARCH_PANEL);
		ingredientTypeLabel.setIcon(Style.ICON_SEARCH_INGREDIENT_TYPE);

		HorisontalJPanel panel = new HorisontalJPanel(List.of(nameLabel, nameText));

		// TODO Auto-generated method stub

	}

	private class HorisontalJPanel extends JPanel {

		private static final long serialVersionUID = 1L;

		private HorisontalJPanel(List<JComponent> componenets) {
			setLayout(new FlowLayout(FlowLayout.LEFT, Style.PADDING_SEARCH_PANEL_HORIZONTAL,
					Style.PADDING_SEARCH_PANEL_VERTICAL));
			setFont(Style.FONT_SEARCH_PANEL);
			setBorder(Style.BORDER_PANEL);
			for (JComponent component : componenets) {
				add(component);
			}
		}

	}

}
