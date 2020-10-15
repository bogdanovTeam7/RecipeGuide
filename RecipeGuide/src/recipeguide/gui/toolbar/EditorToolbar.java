package recipeguide.gui.toolbar;

import recipeguide.gui.EnableElement;
import recipeguide.gui.MainButton;
import recipeguide.settings.HandlerCode;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public final class EditorToolbar extends AbstractToolbar implements EnableElement {

	private static final long serialVersionUID = 1L;

	private MainButton editButton;
	private MainButton deleteButton;

	public EditorToolbar() {
		super(Style.BORDER_TOOLBAR_EDITOR);
		init();
	}

	@Override
	public void setEnableElement(boolean enable) {
		editButton.setEnabled(enable);
		deleteButton.setEnabled(enable);
	}

	@Override
	protected void init() {

		addMainButton(Text.get("toolbarAdd"), Style.ICON_TOOLBAR_ADD, HandlerCode.TOOLBAR_ADD, "", false);
		editButton = addMainButton(Text.get("toolbarEdit"), Style.ICON_TOOLBAR_EDIT, HandlerCode.TOOLBAR_EDIT, "",
				false);
		deleteButton = addMainButton(Text.get("toolbarDelete"), Style.ICON_TOOLBAR_DELETE, HandlerCode.TOOLBAR_DELETE,
				"", false);

	}

}
