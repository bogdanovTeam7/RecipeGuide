package recipeguide.gui.dialog;

import javax.swing.JOptionPane;

import recipeguide.gui.MainFrame;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class ConfirmDialog {

	public static int show(MainFrame frame, String text, String title) {
		frame.setFont(Style.FONT_CONFIRM_DIALOG);
		String[] options = { Text.get("yes"), Text.get("no") };
		return JOptionPane.showOptionDialog(frame, Text.get(text), Text.get(title), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, options, options[1]);
	}
}
