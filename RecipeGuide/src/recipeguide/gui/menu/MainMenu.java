package recipeguide.gui.menu;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import recipeguide.gui.EnableElement;
import recipeguide.gui.MainFrame;
import recipeguide.gui.Refresh;
import recipeguide.gui.handler.Handler;
import recipeguide.gui.handler.MenuFileHandler;
import recipeguide.settings.HandlerCode;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class MainMenu extends JMenuBar implements Refresh, EnableElement {

	private static final long serialVersionUID = 1L;
	private MainFrame frame;
	private JMenuItem menuEdit;
	private JMenuItem menuDelete;

	public MainMenu(MainFrame frame) {
		this.frame = frame;
		setBorder(Style.BORDER_MENU_BAR);

		init();
	}

	private void init() {

		JMenu file = addMenu(Text.get("menuFile"), Style.ICON_MENU_FILE);
		JMenu edit = addMenu(Text.get("menuEdit"), Style.ICON_MENU_EDIT);
		JMenu view = addMenu(Text.get("menuView"), Style.ICON_MENU_VIEW);
		JMenu help = addMenu(Text.get("menuHelp"), Style.ICON_MENU_HELP);

		addMenuItem(file, Text.get("menuFileNew"), Style.ICON_MENU_FILE_NEW, HandlerCode.MENU_FILE_NEW,
				new MenuFileHandler(frame), KeyEvent.VK_N);
		addMenuItem(file, Text.get("menuFileOpen"), Style.ICON_MENU_FILE_OPEN, HandlerCode.MENU_FILE_OPEN,
				new MenuFileHandler(frame), KeyEvent.VK_O);
		addMenuItem(file, Text.get("menuFileSave"), Style.ICON_MENU_FILE_SAVE, HandlerCode.MENU_FILE_SAVE,
				new MenuFileHandler(frame), KeyEvent.VK_S);
		addMenuItem(file, Text.get("menuFileExit"), Style.ICON_MENU_FILE_EXIT, HandlerCode.MENU_FILE_EXIT,
				new MenuFileHandler(frame), KeyEvent.VK_E);

		addMenuItem(edit, Text.get("menuEditAdd"), Style.ICON_MENU_EDIT_ADD, HandlerCode.MENU_EDIT_ADD);
		menuEdit = addMenuItem(edit, Text.get("menuEditEdit"), Style.ICON_MENU_EDIT_EDIT, HandlerCode.MENU_EDIT_EDIT);
		menuDelete = addMenuItem(edit, Text.get("menuEditDelete"), Style.ICON_MENU_EDIT_DELETE,
				HandlerCode.MENU_EDIT_DELETE);
		menuEdit.setEnabled(false);
		menuDelete.setEnabled(false);

		addMenuItem(view, Text.get("menuViewBook"), Style.ICON_MENU_VIEW_BOOK, HandlerCode.MENU_VIEW_BOOK,
				KeyEvent.VK_B);
		addMenuItem(view, Text.get("menuViewIngredientTypes"), Style.ICON_MENU_VIEW_INGREDIENT_TYPES,
				HandlerCode.MENU_INGREDIENT_TYPES, KeyEvent.VK_T);
		addMenuItem(view, Text.get("menuViewIngredients"), Style.ICON_MENU_VIEW_INGREDIENTS,
				HandlerCode.MENU_VIEW_INGREDIENTS, KeyEvent.VK_I);
		addMenuItem(view, Text.get("menuViewMeasuryUnits"), Style.ICON_MENU_VIEW_MEASURY_UNITS,
				HandlerCode.MENU_VIEW_MEASURY_UNITS, KeyEvent.VK_M);
		addMenuItem(view, Text.get("menuViewFoodCategories"), Style.ICON_MENU_VIEW_FOOD_CATEGORIES,
				HandlerCode.MENU_VIEW_FOOD_CATEGORIES, KeyEvent.VK_C);
		addMenuItem(view, Text.get("menuViewRecipes"), Style.ICON_MENU_VIEW_RECIPES, HandlerCode.MENU_VIEW_RECIPES,
				KeyEvent.VK_R);
		addMenuItem(view, Text.get("menuViewSearchRecipes"), Style.ICON_MENU_VIEW_SEARCH, HandlerCode.MENU_VIEW_SEARCH);

		addMenuItem(help, Text.get("menuHelpAbout"), Style.ICON_MENU_HELP_ABOUT, HandlerCode.MENU_HELP_ABOUT);

		setBackground(Style.COLOR_MAIN_MENU);
	}

	private JMenu addMenu(String title, ImageIcon icon) {
		JMenu menu = new JMenu(title);
		menu.setIcon(icon);
		menu.setFont(Style.FONT_MENU_ITEM);
		menu.setForeground(Style.COLOR_MAIN_MENU_FOREGROUND);
		menu.setBorder(BorderFactory.createLineBorder(Style.COLOR_MAIN_MENU_FOREGROUND, 2));
		add(menu);
		JMenu separator = new JMenu("|");
		separator.setEnabled(false);
		add(separator);
		return menu;
	}

	private JMenuItem addMenuItem(JMenu menu, String title, ImageIcon icon, String action, Handler listener, int key) {
		JMenuItem item = new JMenuItem();
		item.setText(title);
		item.setFont(Style.FONT_MENU_ITEM);
		item.setIcon(icon);
		item.setActionCommand(action);
		item.addActionListener(listener);
		if (key != 0) {
			int modifiers = Toolkit.getDefaultToolkit()
					.getMenuShortcutKeyMaskEx();
			KeyStroke hotKey = KeyStroke.getKeyStroke(key, modifiers);
			item.setAccelerator(hotKey);
		}
		menu.add(item);
		menu.addSeparator();
		return item;
	}

	private JMenuItem addMenuItem(JMenu menu, String title, ImageIcon icon, String action) {
		return addMenuItem(menu, title, icon, action, null, 0);
	}

	private JMenuItem addMenuItem(JMenu menu, String title, ImageIcon icon, String action, int key) {
		return addMenuItem(menu, title, icon, action, null, key);
	}

	@Override
	public void setEnableElement(boolean enable) {
		menuEdit.setEnabled(enable);
		menuDelete.setEnabled(enable);
	}

	@Override
	public void refresh() {
		removeAll();
		init();
	}

}
