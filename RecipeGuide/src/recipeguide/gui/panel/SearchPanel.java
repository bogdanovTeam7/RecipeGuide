package recipeguide.gui.panel;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import recipeguide.gui.MainFrame;
import recipeguide.gui.search.SearchModel;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class SearchPanel extends RightPanel {

	public SearchPanel(MainFrame frame, String title, ImageIcon icon, List<JPanel> panels) {
		super(frame, title, icon, panels);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

//	public SearchPanel(MainFrame frame) {
//		super(frame, Text.get("Search"), Style.ICON_SEARCH_MAIN, List.of(new SearchModel()));
//
//		// TODO Auto-generated constructor stub
//	}

}
