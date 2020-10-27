package recipeguide.gui.panel;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import recipeguide.gui.MainFrame;
import recipeguide.model.entities.Book;
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

		setContentLabel("actualBook:");
		setBookPanel();
		setContentLabel("recipeBookContains:");
		addInfoPanels();

	}

	private void setBookPanel() {
		Book book = SaveData.getInstance()
				.getBook();
		JPanel bookPanel = new JPanel();
		bookPanel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		bookPanel.setBackground(Style.COLOR_LEFT_PANEL_BOOK_PANEL);

		constraints.gridx = 0;
		constraints.gridy = 0;
		addRegistry("bookName", book.getNameToDisplay(), constraints, bookPanel);
		constraints.gridx = 0;
		constraints.gridy = 1;
		addRegistry("bookAuthor", book.getAuthor(), constraints, bookPanel);
		constraints.gridx = 0;
		constraints.gridy = 2;
		addRegistry("startedAt", book.getStartedAt()
				.toString(), constraints, bookPanel);
		constraints.gridx = 0;
		constraints.gridy = 3;
		addRegistry("lastEditedAt", book.getLastEditedAt()
				.toString(), constraints, bookPanel);

		add(Box.createVerticalStrut(Style.PADDING_LEFT_PANEL_INFO_PANEL));
		add(bookPanel);
		add(Box.createVerticalStrut(Style.PADDING_LEFT_PANEL_INFO_PANEL));
	}

	private void addRegistry(String title, String text, GridBagConstraints constraints, JPanel bookPanel) {
		JLabel nameLabel = new JLabel(Text.get(title));
		nameLabel.setFont(Style.FONT_LEFT_PANEL_BOOK_PANEL);
		nameLabel.setBorder(Style.BORDER_PANEL);
		bookPanel.add(nameLabel, constraints);

		constraints.gridx++;

		JTextField textField = new JTextField(text);
		textField.setFont(Style.FONT_LEFT_PANEL_BOOK_PANEL);
		textField.setBorder(Style.BORDER_PANEL);
		bookPanel.add(textField, constraints);

	}

	private void setContentLabel(String title) {
		JLabel titleLable = new JLabel(Text.get(title));
		titleLable.setFont(Style.FONT_LEFT_PANEL_TITLE);
		titleLable.setIcon(Style.ICON_LEFT_PANEL_TITLE);
		titleLable.setAlignmentX(CENTER_ALIGNMENT);
		add(titleLable);
	}

	private void addInfoPanels() {
		Map<String, Integer> dates = getDatasForInfoPanel();

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

	private Map<String, Integer> getDatasForInfoPanel() {
		Map<String, Integer> dates = new LinkedHashMap<>();
		dates.put(Text.get("recipesTotal"), SaveData.getInstance()
				.getRecipes()
				.size());
		dates.put(Text.get("ingredientsTotal"), SaveData.getInstance()
				.getIngredients()
				.size());
		return dates;
	}

}
