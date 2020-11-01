package recipeguide.gui.toolbar;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import recipeguide.gui.Refresh;
import recipeguide.gui.toolbar.button.ButtonType;
import recipeguide.gui.toolbar.button.MainButton;
import recipeguide.settings.HandlerCode;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public abstract class AbstractToolbar extends JPanel implements Refresh {

	private static final long serialVersionUID = 1L;

	public AbstractToolbar(EmptyBorder border) {
		super();
		setBorder(border);
	}

	abstract void init();

	protected MainButton addToolBarButton(ButtonType type) {
		String title = "";
		ImageIcon icon = null;
		ActionListener listener = null;
		String action = "";

		switch (type) {
		case ADD:
			title = "toolbarAdd";
			icon = Style.ICON_TOOLBAR_ADD;
			listener = HandlerCode.TOOLBAR_ADD;
			action = "";
			break;
		case EDIT:
			title = "toolbarEdit";
			icon = Style.ICON_TOOLBAR_EDIT;
			listener = HandlerCode.TOOLBAR_EDIT;
			action = "";
			break;
		case DELETE:
			title = "toolbarDelete";
			icon = Style.ICON_TOOLBAR_DELETE;
			listener = HandlerCode.TOOLBAR_DELETE;
			action = "";
			break;
		case CANCEL:
			break;
		case UNSPECIFIED:
			break;
		default:
			break;
		}
		return addMainButton(Text.get(title), icon, listener, action, false, type);
	}

	protected MainButton addMainButton(String title, ImageIcon icon, ActionListener listener, String action,
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
