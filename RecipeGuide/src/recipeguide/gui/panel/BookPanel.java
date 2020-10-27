package recipeguide.gui.panel;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import recipeguide.gui.MainFrame;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class BookPanel extends RightPanel {

	private static final long serialVersionUID = 1L;

	public BookPanel(MainFrame frame) {
		super(frame, Text.get("bookDatas"), Style.ICON_RIGHT_PANEL_BOOK, List.of());
		// TODO Auto-generated constructor stub
	}

}