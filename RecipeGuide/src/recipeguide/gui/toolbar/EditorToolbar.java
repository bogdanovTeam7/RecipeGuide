package recipeguide.gui.toolbar;

import java.util.ArrayList;
import java.util.List;

import recipeguide.gui.EnableElement;
import recipeguide.gui.MainFrame;
import recipeguide.gui.toolbar.button.ButtonType;
import recipeguide.gui.toolbar.button.MainButton;
import recipeguide.settings.Style;

public final class EditorToolbar extends AbstractToolbar implements EnableElement {

	private static final long serialVersionUID = 1L;

	private List<ButtonType> types;
	private List<ButtonType> enableTypes;
	private List<MainButton> buttons;

	public EditorToolbar(MainFrame frame, List<ButtonType> types, List<ButtonType> enableTypes) {
		super(frame, Style.BORDER_TOOLBAR_EDITOR);
		this.types = types;
		this.enableTypes = enableTypes;
		init();
	}

	@Override
	protected void init() {
		buttons = new ArrayList<>();
		for (ButtonType type : types) {
			buttons.add(addToolBarButton(type));
			setEnableElement(enableTypes);
		}
	}

	@Override
	public void setEnableElement(List<ButtonType> types) {
		for (MainButton button : buttons) {
			if (types != null && types.contains(button.getType())) {
				button.setEnabled(true);
			} else {
				button.setEnabled(false);
			}
		}
	}

	@Override
	public List<ButtonType> getEnableTypes() {
		List<ButtonType> enableTypes = new ArrayList<>();
		for (MainButton button : buttons) {
			if (button.isEnabled()) {
				enableTypes.add(button.getType());
			}
		}
		return enableTypes;
	}

}
