package recipeguide.gui;

import javax.swing.JFrame;

import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public MainFrame() {
		super(Text.get("ProgramName"));
		setResizable(false);
		setIconImage(Style.ICON_MAIN.getImage());
		setLocationRelativeTo(null);

	}

}
