package recipeguide.gui.handler;

import java.awt.event.ActionEvent;

import recipeguide.gui.MainFrame;
import recipeguide.gui.dialog.AboutDialog;
import recipeguide.settings.HandlerCode;

public class HelpAboutHandler extends Handler {

	public HelpAboutHandler(MainFrame frame) {
		super(frame);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case HandlerCode.HELP_ABOUT:
			new AboutDialog().setVisible(true);
			break;
		}
	}

}
