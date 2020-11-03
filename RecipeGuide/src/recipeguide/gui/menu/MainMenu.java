package recipeguide.gui.menu;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import recipeguide.gui.EnableElement;
import recipeguide.gui.MainFrame;
import recipeguide.gui.Refresh;
import recipeguide.gui.handler.EditorHandler;
import recipeguide.gui.handler.Handler;
import recipeguide.gui.handler.ViewHandler;
import recipeguide.gui.handler.FileHandler;
import recipeguide.gui.toolbar.button.ButtonType;
import recipeguide.settings.HandlerCode;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class MainMenu extends JMenuBar implements Refresh, EnableElement {

	private static final long serialVersionUID = 1L;
	private MainFrame frame;
	private List<MenuItem> editorItems;

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

		FileHandler fileHandler = new FileHandler(frame);
		addMenuItem(file, Text.get("menuFileNew"), Style.ICON_MENU_FILE_NEW, HandlerCode.MENU_FILE_NEW, fileHandler,
				KeyEvent.VK_N);
		addMenuItem(file, Text.get("menuFileOpen"), Style.ICON_MENU_FILE_OPEN, HandlerCode.MENU_FILE_OPEN, fileHandler,
				KeyEvent.VK_O);
		addMenuItem(file, Text.get("menuFileSave"), Style.ICON_MENU_FILE_SAVE, HandlerCode.MENU_FILE_SAVE, fileHandler,
				KeyEvent.VK_S);
		addMenuItem(file, Text.get("menuFileExit"), Style.ICON_MENU_FILE_EXIT, HandlerCode.MENU_FILE_EXIT, fileHandler,
				KeyEvent.VK_E);

		editorItems = new ArrayList<>();
		EditorHandler editorHandler = new EditorHandler(frame);
		editorItems.add(addMenuItem(edit, Text.get("menuEditAdd"), Style.ICON_MENU_EDIT_ADD, HandlerCode.ADD,
				editorHandler, ButtonType.ADD));
		editorItems.add(addMenuItem(edit, Text.get("menuEditEdit"), Style.ICON_MENU_EDIT_EDIT, HandlerCode.EDIT,
				editorHandler, ButtonType.EDIT));
		editorItems.add(addMenuItem(edit, Text.get("menuEditDelete"), Style.ICON_MENU_EDIT_DELETE, HandlerCode.DELETE,
				editorHandler, ButtonType.DELETE));
		setEnableElement(frame.getEnableTypes());

		ViewHandler viewHandler = new ViewHandler(frame);
		addMenuItem(view, Text.get("menuViewBook"), Style.ICON_MENU_VIEW_BOOK, HandlerCode.MENU_VIEW_BOOK, viewHandler,
				KeyEvent.VK_B);
		addMenuItem(view, Text.get("menuViewIngredientTypes"), Style.ICON_MENU_VIEW_INGREDIENT_TYPES,
				HandlerCode.MENU_VIEW_INGREDIENT_TYPES, viewHandler, KeyEvent.VK_T);
		addMenuItem(view, Text.get("menuViewIngredients"), Style.ICON_MENU_VIEW_INGREDIENTS,
				HandlerCode.MENU_VIEW_INGREDIENTS, viewHandler, KeyEvent.VK_I);
		addMenuItem(view, Text.get("menuViewMeasuryUnits"), Style.ICON_MENU_VIEW_MEASURY_UNITS,
				HandlerCode.MENU_VIEW_MEASURY_UNITS, viewHandler, KeyEvent.VK_M);
		addMenuItem(view, Text.get("menuViewFoodCategories"), Style.ICON_MENU_VIEW_FOOD_CATEGORIES,
				HandlerCode.MENU_VIEW_FOOD_CATEGORIES, viewHandler, KeyEvent.VK_C);
		addMenuItem(view, Text.get("menuViewRecipes"), Style.ICON_MENU_VIEW_RECIPES, HandlerCode.MENU_VIEW_RECIPES,
				viewHandler, KeyEvent.VK_R);
		addMenuItem(view, Text.get("menuViewSearchRecipes"), Style.ICON_MENU_VIEW_SEARCH, HandlerCode.MENU_VIEW_SEARCH,
				viewHandler);

		addMenuItem(help, Text.get("menuHelpAbout"), Style.ICON_MENU_HELP_ABOUT, HandlerCode.MENU_HELP_ABOUT, null);

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

	private MenuItem addMenuItem(JMenu menu, String title, ImageIcon icon, String action, Handler listener, int key,
			ButtonType type) {
		MenuItem item = MenuItem.builder()
				.withTitle(title)
				.withIcon(icon)
				.withAction(action)
				.withListener(listener)
				.withKey(key)
				.withAction(action)
				.withType(type)
				.build();
		item.setFont(Style.FONT_MENU_ITEM);

		menu.add(item);
		menu.addSeparator();
		return item;
	}

	private MenuItem addMenuItem(JMenu menu, String title, ImageIcon icon, String action, Handler listener, int key) {
		return addMenuItem(menu, title, icon, action, listener, key, ButtonType.UNSPECIFIED);
	}

	private MenuItem addMenuItem(JMenu menu, String title, ImageIcon icon, String action, Handler listener,
			ButtonType type) {
		return addMenuItem(menu, title, icon, action, listener, 0, type);
	}

	private MenuItem addMenuItem(JMenu menu, String title, ImageIcon icon, String action, Handler listener) {
		return addMenuItem(menu, title, icon, action, listener, 0, ButtonType.UNSPECIFIED);
	}

	@Override
	public void refresh() {
		removeAll();
		init();
	}

	@Override
	public void setEnableElement(List<ButtonType> types) {
		for (MenuItem item : editorItems) {
			item.setEnabled(types != null && types.contains(item.getType()));
		}
	}

	@Override
	public List<ButtonType> getEnableTypes() {
		List<ButtonType> enableTypes = new ArrayList<>();
		for (MenuItem item : editorItems) {
			if (item.isEnabled()) {
				enableTypes.add(item.getType());
			}
		}
		return enableTypes;
	}
}
