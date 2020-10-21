package recipeguide.gui.panel;

import javax.swing.JPanel;

import recipeguide.gui.MainFrame;
import recipeguide.gui.Refresh;

public abstract class AbstractPanel extends JPanel implements Refresh {

	private static final long serialVersionUID = 1L;

	protected final MainFrame frame;

	public AbstractPanel(MainFrame frame) {
		this.frame = frame;
	}

	@Override
	public void refresh() {
		removeAll();
		init();
	}

	protected abstract void init();

}
