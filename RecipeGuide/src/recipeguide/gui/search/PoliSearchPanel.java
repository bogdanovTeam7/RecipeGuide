package recipeguide.gui.search;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import recipeguide.gui.MainFrame;
import recipeguide.gui.panel.AbstractPanel;
import recipeguide.settings.Style;

public class PoliSearchPanel extends AbstractPanel {

	private static final long serialVersionUID = 1L;

	public PoliSearchPanel(MainFrame frame) {
		super(frame);
	}

	@Override
	protected void init() {

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(Style.BORDER_PANEL);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(Style.BORDER_PANEL);

		panel.add(new NameSearchPanel(frame));
		panel.add(Box.createVerticalStrut(Style.PADDING_RIGHT_PANEL));
		panel.add(new FoodCategorySearchPanel(frame));
		panel.add(Box.createVerticalStrut(Style.PADDING_RIGHT_PANEL));
		panel.add(new IngredientTypeSearchPanel(frame));
		panel.add(Box.createVerticalStrut(Style.PADDING_RIGHT_PANEL));
		panel.add(new IngredientSearchPanel(frame));

		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
	}

}
