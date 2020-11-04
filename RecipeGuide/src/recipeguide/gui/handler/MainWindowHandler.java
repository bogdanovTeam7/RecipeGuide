package recipeguide.gui.handler;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import recipeguide.gui.MainFrame;
import recipeguide.gui.dialog.ConfirmDialog;
import recipeguide.saveload.SaveData;

public class MainWindowHandler extends WindowAdapter {

	@Override
	public void windowClosing(WindowEvent e) {
		if (SaveData.getInstance()
				.isSaved()) {
			System.exit(0);
		} else {
			MainFrame frame = (MainFrame) e.getWindow();
			int value = ConfirmDialog.show(frame, "confirmExitIntention", "confirmationOfIntent");
			if (value == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}

}
