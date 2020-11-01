package recipeguide.gui.menu;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import recipeguide.gui.toolbar.button.ButtonType;

public class MenuItem extends JMenuItem {

	private static final long serialVersionUID = 1L;

	private ButtonType type;

	private MenuItem(Builder builder) {

		this.type = builder.type;
		setText(builder.title);
		setIcon(builder.icon);
		setActionCommand(builder.action);
		addActionListener(builder.listener);
		if (builder.key != 0) {
			int modifiers = Toolkit.getDefaultToolkit()
					.getMenuShortcutKeyMaskEx();
			KeyStroke hotKey = KeyStroke.getKeyStroke(builder.key, modifiers);
			setAccelerator(hotKey);
		}
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {

		private ButtonType type;
		private String title;
		private ImageIcon icon;
		private String action;
		private recipeguide.gui.handler.Handler listener;
		private int key;

		private Builder() {
		}

		public Builder withType(ButtonType type) {
			this.type = type;
			return this;
		}

		public Builder withTitle(String title) {
			this.title = title;
			return this;
		}

		public Builder withIcon(ImageIcon icon) {
			this.icon = icon;
			return this;
		}

		public Builder withAction(String action) {
			this.action = action;
			return this;
		}

		public Builder withListener(recipeguide.gui.handler.Handler listener) {
			this.listener = listener;
			return this;
		}

		public Builder withKey(int key) {
			this.key = key;
			return this;
		}

		public MenuItem build() {
			return new MenuItem(this);
		}
	}

	public ButtonType getType() {
		return type;
	}

}
