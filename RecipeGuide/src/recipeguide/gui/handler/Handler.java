package recipeguide.gui.handler;

import java.awt.event.ActionListener;

import recipeguide.gui.MainFrame;

public abstract class Handler implements ActionListener {

	protected MainFrame frame;

	public Handler(MainFrame frame) {
		this.frame = frame;
	}

}
