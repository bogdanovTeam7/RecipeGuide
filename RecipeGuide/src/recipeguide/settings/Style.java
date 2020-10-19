package recipeguide.settings;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

public final class Style {

	public static final Color COLOR_MAIN_FRAME = Color.ORANGE;
	public static final Color COLOR_MAIN_MENU = Color.GRAY;
	public static final Color COLOR_MAIN_MENU_FOREGROUND = Color.ORANGE;
	public static final Color COLOR_BUTTON_BG_NORMAL = new Color(240, 240, 240);
	public static final Color COLOR_BUTTON_BG_HOVER = Color.YELLOW;

	public static final Font FONT_MENU_BUTTON = new Font(Settings.FONT_NAME, Font.BOLD, 14);
	public static final Font FONT_MENU_ITEM = new Font(Settings.FONT_NAME, Font.BOLD, 14);
	public static final Font FONT_TOOLBAR_BUTTON = new Font(Settings.FONT_NAME, Font.BOLD, 14);
	public static final Font FONT_MAIN_FILE_CHOOSER = new Font(Settings.FONT_NAME, Font.BOLD, 12);
	public static final Font FONT_ERROR_DIALOG = new Font(Settings.FONT_NAME, Font.BOLD, 12);
	public static final Font FONT_CONFIRM_DIALOG = new Font(Settings.FONT_NAME, Font.BOLD, 12);
	public static final Font FONT_ABOUT_DIALOG = new Font(Settings.FONT_NAME, Font.BOLD, 12);
	public static final Font FONT_ADD_EDIT_DIALOG = new Font(Settings.FONT_NAME, Font.BOLD, 14);

	public static final EmptyBorder BORDER_MENU_BAR = new EmptyBorder(10, 10, 10, 10);
	public static final EmptyBorder BORDER_TOOLBAR_MAIN = new EmptyBorder(10, 10, 10, 10);
	public static final EmptyBorder BORDER_TOOLBAR_EDITOR = new EmptyBorder(5, 5, 5, 5);
	public static final EmptyBorder BORDER_DIALOG = new EmptyBorder(10, 10, 10, 10);

	public static final Dimension DIMENSION_DIALOG_TEXT_FIELD = new Dimension(200, 30);

	public static final int PADDING_DIALOG = 15;

	public static final ImageIcon ICON_MAIN = new ImageIcon("images/main.png");

	public static final ImageIcon ICON_MENU_FILE = new ImageIcon("images/menuFile.png");
	public static final ImageIcon ICON_MENU_EDIT = new ImageIcon("images/menuEdit.png");
	public static final ImageIcon ICON_MENU_VIEW = new ImageIcon("images/menuView.png");
	public static final ImageIcon ICON_MENU_HELP = new ImageIcon("images/menuHelp.png");

	public static final ImageIcon ICON_MENU_FILE_NEW = new ImageIcon("images/menuFileNew.png");
	public static final ImageIcon ICON_MENU_FILE_OPEN = new ImageIcon("images/menuFileOpen.png");
	public static final ImageIcon ICON_MENU_FILE_SAVE = new ImageIcon("images/menuFileSave.png");
	public static final ImageIcon ICON_MENU_FILE_EXIT = new ImageIcon("images/menuFileExit.png");

	public static final ImageIcon ICON_MENU_EDIT_ADD = new ImageIcon("images/menuEditAdd.png");
	public static final ImageIcon ICON_MENU_EDIT_EDIT = new ImageIcon("images/menuEditEdit.png");
	public static final ImageIcon ICON_MENU_EDIT_DELETE = new ImageIcon("images/menuEditDelete.png");

	public static final ImageIcon ICON_MENU_VIEW_OVERVIEW = new ImageIcon("images/menuViewOverview.png");
	public static final ImageIcon ICON_MENU_VIEW_INGREDIENT_TYPES = new ImageIcon("images/menuViewIngredientTypes.png");
	public static final ImageIcon ICON_MENU_VIEW_INGREDIENTS = new ImageIcon("images/menuViewIngredients.png");
	public static final ImageIcon ICON_MENU_VIEW_MEASURY_UNITS = new ImageIcon("images/menuViewMeasuryUnits.png");
	public static final ImageIcon ICON_MENU_VIEW_FOOD_CATEGORIES = new ImageIcon("images/menuViewFoodCategories.png");
	public static final ImageIcon ICON_MENU_VIEW_RECIPES = new ImageIcon("images/menuViewRecipes.png");

	public static final ImageIcon ICON_MENU_HELP_ABOUT = new ImageIcon("images/menuHelpAbout.png");

	public static final ImageIcon ICON_TOOLBAR_OVERVIEW = new ImageIcon("images/toolbarOverview.png");
	public static final ImageIcon ICON_TOOLBAR_MEASURY_UNITS = new ImageIcon("images/toolbarViewMeasuryUnits.png");
	public static final ImageIcon ICON_TOOLBAR_INGREDIENT_TYPES = new ImageIcon(
			"images/toolbarViewIngredientTypes.png");
	public static final ImageIcon ICON_TOOLBAR_INGREDIENTS = new ImageIcon("images/toolbarViewIngredients.png");
	public static final ImageIcon ICON_TOOLBAR_FOOD_CATEGORIES = new ImageIcon("images/toolbarViewFoodCategories.png");
	public static final ImageIcon ICON_TOOLBAR_RECIPES = new ImageIcon("images/toolbarViewRecipes.png");
	public static final ImageIcon ICON_TOOLBAR_ADD = new ImageIcon("images/toolbarAdd.png");
	public static final ImageIcon ICON_TOOLBAR_EDIT = new ImageIcon("images/toolbarEdit.png");
	public static final ImageIcon ICON_TOOLBAR_DELETE = new ImageIcon("images/toolbarDelete.png");

	public static final ImageIcon ICON_BUTTON_ADD = new ImageIcon("images/buttonAdd.png");
	public static final ImageIcon ICON_BUTTON_EDIT = new ImageIcon("images/buttonEdit.png");
	public static final ImageIcon ICON_BUTTON_CANCEL = new ImageIcon("images/buttonCancel.png");

	public static final ImageIcon ICON_DIALOG_ABOUT = new ImageIcon("images/menuHelpAbout.png");
	public static final ImageIcon ICON_DIALOG_ADD = new ImageIcon("images/menuEditAdd.png");
	public static final ImageIcon ICON_DIALOG_EDIT = new ImageIcon("images/menuEditEdit.png");
	public static final ImageIcon ICON_DIALOG_MEASURY_UNIT = new ImageIcon("images/menuViewMeasuryUnits.png");
	public static final ImageIcon ICON_DIALOG_INGREDIENT_TYPE = new ImageIcon("images/menuViewIngredientTypes.png");
	public static final ImageIcon ICON_DIALOG_FOOD_CATEGORY = new ImageIcon("images/menuViewFoodCategories.png");
	public static final ImageIcon ICON_DIALOG_INGREDIENT = new ImageIcon("images/menuViewIngredients.png");

}
