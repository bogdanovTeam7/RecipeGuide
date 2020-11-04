package recipeguide.gui.toolbar;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import recipeguide.gui.MainFrame;
import recipeguide.gui.Refresh;
import recipeguide.gui.handler.EditorHandler;
import recipeguide.gui.handler.Handler;
import recipeguide.gui.toolbar.button.ButtonType;
import recipeguide.gui.toolbar.button.MainButton;
import recipeguide.settings.HandlerCode;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public abstract class AbstractToolbar extends JPanel implements Refresh {

	private static final long serialVersionUID = 1L;
	protected MainFrame frame;

	public AbstractToolbar(MainFrame frame, EmptyBorder border) {
		super();
		this.frame = frame;
		setBorder(border);
	}

	protected abstract void init();

	protected MainButton addToolBarButton(ButtonType type) {
		String title = "";
		ImageIcon icon = null;
		Handler listener = null;
		String action = "";

		switch (type) {
		case ADD:
			title = "toolbarAdd";
			icon = Style.ICON_TOOLBAR_ADD;
			listener = new EditorHandler(frame);
			action = HandlerCode.ADD;
			break;
		case EDIT:
			title = "toolbarEdit";
			icon = Style.ICON_TOOLBAR_EDIT;
			listener = new EditorHandler(frame);
			action = HandlerCode.EDIT;
			break;
		case DELETE:
			title = "toolbarDelete";
			icon = Style.ICON_TOOLBAR_DELETE;
			listener = new EditorHandler(frame);
			action = HandlerCode.DELETE;
			break;
		case DETAILS_OVERVIEW:
			title = "detailsOverview";
			icon = Style.ICON_TOOLBAR_DETAILS_OVERVIEW;
			listener = new EditorHandler(frame);
			action = HandlerCode.DETAILS_OVERVIEW;
			break;
		case CANCEL:
			break;
		case SEARCH:
			title = "search";
			icon = Style.ICON_TOOLBAR_SEARCH;
			listener = null;
			action = HandlerCode.SEARCH;
			break;
		case UNSPECIFIED:
			break;
		default:
			break;
		}
		return addMainButton(Text.get(title), icon, listener, action, false, type);
	}

	protected MainButton addMainButton(String title, ImageIcon icon, Handler listener, String action,
			boolean isImageOnTop, ButtonType type) {
		MainButton mainButton = MainButton.builder()
				.withAction(action)
				.withActionListener(listener)
				.withIcon(icon)
				.withTitle(title)
				.withType(type)
				.build();
		if (isImageOnTop) {
			mainButton.setHorizontalTextPosition(SwingConstants.CENTER);
			mainButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		} else {
			mainButton.setHorizontalTextPosition(SwingConstants.RIGHT);
			mainButton.setVerticalTextPosition(SwingConstants.CENTER);
		}

		add(mainButton);
		return mainButton;
	}

	@Override
	public void refresh() {
		removeAll();
		init();
	}

}
