package recipeguide.gui.panel;

import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import recipeguide.gui.MainFrame;
import recipeguide.model.entities.Book;
import recipeguide.saveload.SaveData;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class BookDataPanel extends AbstractPanel {

	private static final long serialVersionUID = 1L;
	private Book book;

	public BookDataPanel(MainFrame frame) {
		super(frame);
		init();
	}

	@Override
	protected void init() {
		book = SaveData.getInstance()
				.getBook();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(createMonoPanel("bookName", Style.ICON_RIGHT_PANEL_BOOK_NAME, book.getNameToDisplay()));
		add(createMonoPanel("bookAuthor", Style.ICON_RIGHT_PANEL_BOOK_AUTHOR, book.getAuthor()));
		add(createMonoPanel("startedAt", Style.ICON_RIGHT_PANEL_BOOK_STARTED_AT, book.getFormattedStartedAt()));
		add(createMonoPanel("lastEditedAt", Style.ICON_RIGHT_PANEL_BOOK_EDITED_AT, book.getFormattedLastEditedAt()));
	}

	private JPanel createMonoPanel(String title, ImageIcon icon, String text) {
		JPanel panel = new JPanel(new GridLayout());
		panel.setBorder(Style.BORDER_PANEL);

		panel.add(Box.createHorizontalStrut(Style.PADDING_RIGHT_PANEL));

		JLabel label = new JLabel(Text.get(title));
		label.setFont(Style.FONT_RIGHT_PANEL_TITLE);
		label.setIcon(icon);
		panel.add(label);

		JTextArea textArea = new JTextArea(text);
		textArea.setAlignmentX(RIGHT_ALIGNMENT);
		textArea.setFont(Style.FONT_RIGHT_PANEL_TITLE);
		textArea.setBackground(panel.getBackground());
		textArea.setEditable(false);

		panel.add(Box.createHorizontalStrut(Style.PADDING_BOOK_PANEL));

		panel.add(textArea);

		return panel;
	}

}
