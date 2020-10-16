package recipeguide.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

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

		MainFaleChooser faleChooser = new MainFaleChooser(this);
		faleChooser.open();

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

	@Override
	public void refresh() {
		SwingUtilities.updateComponentTreeUI(this);
		menubar.refresh();
		pack();

	}

}
