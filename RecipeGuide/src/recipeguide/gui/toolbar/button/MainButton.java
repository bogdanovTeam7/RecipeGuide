package recipeguide.gui.toolbar.button;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import recipeguide.settings.Style;

public class MainButton extends JButton implements MouseListener {

	private static final long serialVersionUID = 1L;

	private ButtonType type;

	private MainButton(Builder builder) {
		super(builder.title);
		this.type = builder.type;
		setIcon(builder.icon);
		setActionCommand(builder.action);
		addActionListener(builder.actionListener);
		addMouseListener(this);

		setFont(Style.FONT_MENU_BUTTON);
		setBackground(Style.COLOR_BUTTON_BG_NORMAL);
		setFocusPainted(false);
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {

		private String title;
		private ImageIcon icon;
		private ActionListener actionListener;
		private String action;
		private ButtonType type;

		private Builder() {
		}

		public Builder withTitle(String title) {
			this.title = title;
			return this;
		}

		public Builder withIcon(ImageIcon icon) {
			this.icon = icon;
			return this;
		}

		public Builder withActionListener(ActionListener actionListener) {
			this.actionListener = actionListener;
			return this;
		}

		public Builder withAction(String action) {
			this.action = action;
			return this;
		}

		public Builder withType(ButtonType type) {
			this.type = type;
			return this;
		}

		public MainButton build() {
			return new MainButton(this);
		}
	}

	public ButtonType getType() {
		return type;
	}

	public void setType(ButtonType type) {
		this.type = type;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		MainButton button = (MainButton) e.getSource();
		if (button.isEnabled()) {
			button.setBackground(Style.COLOR_BUTTON_BG_HOVER);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		((MainButton) e.getSource()).setBackground(Style.COLOR_BUTTON_BG_NORMAL);

	}

}
