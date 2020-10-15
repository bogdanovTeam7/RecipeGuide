package recipeguide.gui.toolbar;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import recipeguide.gui.MainButton;
import recipeguide.gui.Refresh;

public abstract class AbstractToolbar extends JPanel implements Refresh {

	private static final long serialVersionUID = 1L;

	public AbstractToolbar(EmptyBorder border) {
		super();
		setBorder(border);
	}

	abstract void init();

	protected MainButton addMainButton(String title, ImageIcon icon, ActionListener listener, String action,
			boolean isImageOnTop) {
		MainButton mainButton = MainButton.builder()
				.withAction(action)
				.withActionListener(listener)
				.withIcon(icon)
				.withTitle(title)
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
