package recipeguide.gui.dialog;

import javax.swing.JOptionPane;

import recipeguide.gui.MainFrame;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class ErrorDialog {

	public static void show(MainFrame frame, String text) {

		frame.setFont(Style.FONT_ERROR_DIALOG);

		JOptionPane.showMessageDialog(frame, text, Text.get("error"), JOptionPane.ERROR_MESSAGE);
	}
}
