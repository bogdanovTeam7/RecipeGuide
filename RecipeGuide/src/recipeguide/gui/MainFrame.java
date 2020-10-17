package recipeguide.gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Arrays;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import recipeguide.gui.dialog.AboutDialog;
import recipeguide.gui.dialog.ConfirmDialog;
import recipeguide.gui.dialog.ErrorDialog;
import recipeguide.gui.menu.MainMenu;
import recipeguide.gui.toolbar.EditorToolbar;
import recipeguide.gui.toolbar.MainToolbar;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class MainFrame extends JFrame implements Refresh {

	private static final long serialVersionUID = 1L;

	private GridBagConstraints constraints;
	private MainMenu menubar;
	private MainToolbar mainToolbar;

	public MainFrame() {
		super(Text.get("ProgramName"));
		setResizable(false);
		setIconImage(Style.ICON_MAIN.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Style.COLOR_MAIN_FRAME);

		menubar = new MainMenu(this);
		setJMenuBar(menubar);

		setLayout(new GridBagLayout());

		AboutDialog dialog = new AboutDialog();
		dialog.setVisible(true);

		constraints = new GridBagConstraints();

		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;

		mainToolbar = new MainToolbar();
		add(mainToolbar, constraints);

		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.anchor = GridBagConstraints.NORTH;

		add(new EditorToolbar(), constraints);

		// TODO leftpanel
		pack();
		setLocationRelativeTo(null);
	}

	public void setFont(Font font) {
		for (Entry<Object, Object> e : UIManager.getDefaults()
				.entrySet()) {
			if (e.getKey()
					.toString()
					.contains("font")) {
				UIManager.put(e.getKey(), font);
			}
		}
	}

	@Override
	public void refresh() {
		SwingUtilities.updateComponentTreeUI(this);
		menubar.refresh();
		pack();

	}

}
