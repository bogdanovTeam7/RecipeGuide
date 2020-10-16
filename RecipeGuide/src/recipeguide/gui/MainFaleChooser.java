package recipeguide.gui;

import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import recipeguide.settings.Settings;
import recipeguide.settings.Style;

public class MainFaleChooser extends JFileChooser {

	private static final long serialVersionUID = 1L;

	private MainFrame frame;

	public MainFaleChooser(MainFrame frame) {
		this.frame = frame;
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Program files", Settings.SAVE_FILE_EXT);
		setFileFilter(filter);
		setAcceptAllFileFilterUsed(false);
		setCurrentDirectory(Settings.SAVE_DIR);

		setFont();

		setText();

		updateUI();
	}

	private void setText() {
		// TODO Auto-generated method stub

	}

	private void setFont() {
		for (Entry<Object, Object> e : UIManager.getDefaults()
				.entrySet()) {
			if (e.getKey()
					.toString()
					.contains("font")) {
				UIManager.put(e.getKey(), Style.FONT_MAIN_FILE_CHOOSER);
			}
		}
	}

	public void open() {
		super.showOpenDialog(frame);
	}

	public void save() {
		super.showSaveDialog(frame);
	}

}
