package recipeguide.gui.panel;

import java.awt.BorderLayout;

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
		add(createMonoPanel("bookName", Style.ICON_RIGHT_PANEL_BOOK_NAME, book.getNameToDisplay(), true));
		add(createMonoPanel("bookAuthor", Style.ICON_RIGHT_PANEL_BOOK_AUTHOR, book.getAuthor(), true));
		add(createMonoPanel("startedAt", Style.ICON_RIGHT_PANEL_BOOK_STARTED_AT, book.getFormattedStartedAt(), false));
		add(createMonoPanel("lastEditedAt", Style.ICON_RIGHT_PANEL_BOOK_EDITED_AT, book.getFormattedLastEditedAt(), false));
	}

	private JPanel createMonoPanel(String title, ImageIcon icon, String text, boolean isEditable) {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(Style.BORDER_PANEL);

		panel.add(Box.createHorizontalStrut(Style.PADDING_RIGHT_PANEL));

		JLabel label = new JLabel(Text.get(title));
		label.setFont(Style.FONT_RIGHT_PANEL_TITLE);
		label.setIcon(icon);
		panel.add(label, BorderLayout.WEST);

		panel.add(Box.createHorizontalStrut(Style.PADDING_RIGHT_PANEL));

		JTextArea textArea = new JTextArea(text);
		textArea.setFont(Style.FONT_RIGHT_PANEL_TITLE);
		if (!isEditable) {
			textArea.setBackground(panel.getBackground());
		} else {
			textArea.setPreferredSize(Style.DIMENSION_DIALOG_TEXT_FIELD);
		}
		textArea.setEditable(isEditable);

		panel.add(textArea, BorderLayout.EAST);

		return panel;
	}

}
