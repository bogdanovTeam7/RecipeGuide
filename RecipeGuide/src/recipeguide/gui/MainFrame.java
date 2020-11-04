package recipeguide.gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import recipeguide.gui.handler.MainWindowHandler;
import recipeguide.gui.menu.MainMenu;
import recipeguide.gui.panel.BookPanel;
import recipeguide.gui.panel.LeftPanel;
import recipeguide.gui.panel.RightPanel;
import recipeguide.gui.toolbar.MainToolbar;
import recipeguide.gui.toolbar.button.ButtonType;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class MainFrame extends JFrame implements Refresh {

	private static final long serialVersionUID = 1L;

	private GridBagConstraints constraints;
	private MainMenu menubar;
	private LeftPanel leftPanel;
	private RightPanel rightPanel;
	private MainToolbar mainToolbar;
	private List<ButtonType> enableTypes;

	public MainFrame() {
		super(Text.get("ProgramName"));

		setResizable(false);
		setIconImage(Style.ICON_MAIN.getImage());
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setBackground(Style.COLOR_MAIN_FRAME);

		menubar = new MainMenu(this);
		setJMenuBar(menubar);

		setLayout(new GridBagLayout());

		constraints = new GridBagConstraints();

		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;

		mainToolbar = new MainToolbar(this);
		add(mainToolbar, constraints);

		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.anchor = GridBagConstraints.NORTH;

		leftPanel = new LeftPanel(this);
		add(leftPanel, constraints);

		setRightPanel(new BookPanel(this));

		pack();
		setLocationRelativeTo(null);

		addWindowListener(new MainWindowHandler());
	}

	public void setRightPanel(RightPanel panel) {
		if (rightPanel != null) {
			remove(rightPanel);
		}
		constraints.gridy = 1;
		constraints.gridx = 1;
		rightPanel = panel;
		add(rightPanel, constraints);
		pack();
	}

	public MainMenu getMenu() {
		return menubar;
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

	public List<ButtonType> getEnableTypes() {
		return enableTypes;
	}

	public void setEnableTypes(List<ButtonType> enableTypes) {
		this.enableTypes = enableTypes;
	}

	public RightPanel getRightPanel() {
		return rightPanel;
	}

	@Override
	public void refresh() {
		SwingUtilities.updateComponentTreeUI(this);
		menubar.refresh();
		leftPanel.refresh();
		rightPanel.refresh();
		pack();
		setLocationRelativeTo(null);
	}

}
