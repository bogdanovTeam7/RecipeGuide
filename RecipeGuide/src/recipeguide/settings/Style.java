package recipeguide.settings;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

public final class Style {

	public static final Color COLOR_MAIN_FRAME = Color.ORANGE;
	public static final Color COLOR_MAIN_MENU = Color.GRAY;
	public static final Color COLOR_MAIN_MENU_FOREGROUND = Color.ORANGE;
	public static final Color COLOR_BUTTON_BG_NORMAL = new Color(240, 240, 240);
	public static final Color COLOR_BUTTON_BG_HOVER = Color.YELLOW;
	public static final Color COLOR_LEFT_PANEL_INFO_PANEL = Color.WHITE;
	public static final Color COLOR_SEARCH_MONO_PANEL = Color.WHITE;

	public static final Font FONT_MENU_BUTTON = new Font(Settings.FONT_NAME, Font.BOLD, 14);
	public static final Font FONT_MENU_ITEM = new Font(Settings.FONT_NAME, Font.BOLD, 14);
	public static final Font FONT_TOOLBAR_BUTTON = new Font(Settings.FONT_NAME, Font.BOLD, 14);
	public static final Font FONT_MAIN_FILE_CHOOSER = new Font(Settings.FONT_NAME, Font.BOLD, 12);
	public static final Font FONT_ERROR_DIALOG = new Font(Settings.FONT_NAME, Font.BOLD, 12);
	public static final Font FONT_CONFIRM_DIALOG = new Font(Settings.FONT_NAME, Font.BOLD, 12);
	public static final Font FONT_ABOUT_DIALOG = new Font(Settings.FONT_NAME, Font.BOLD, 12);
	public static final Font FONT_ADD_EDIT_DIALOG = new Font(Settings.FONT_NAME, Font.BOLD, 14);
	public static final Font FONT_LEFT_PANEL_TITLE = new Font(Settings.FONT_NAME, Font.BOLD, 16);
	public static final Font FONT_LEFT_PANEL_INFO_PANEL = new Font(Settings.FONT_NAME, Font.BOLD, 14);
	public static final Font FONT_RIGHT_PANEL_TITLE = new Font(Settings.FONT_NAME, Font.BOLD, 16);
	public static final Font FONT_TABLE_HEADER = new Font(Settings.FONT_NAME, Font.BOLD, 16);
	public static final Font FONT_TABLE = new Font(Settings.FONT_NAME, Font.BOLD, 12);
	public static final Font FONT_SEARCH_PANEL = new Font(Settings.FONT_NAME, Font.BOLD, 14);
	public static final Font FONT_SEARCH_CHECK_BOX = new Font(Settings.FONT_NAME, Font.BOLD, 12);

	public static final EmptyBorder BORDER_MENU_BAR = new EmptyBorder(10, 10, 10, 10);
	public static final EmptyBorder BORDER_TOOLBAR_MAIN = new EmptyBorder(10, 10, 10, 10);
	public static final EmptyBorder BORDER_TOOLBAR_EDITOR = new EmptyBorder(5, 5, 5, 5);
	public static final EmptyBorder BORDER_DIALOG = new EmptyBorder(10, 10, 10, 10);
	public static final EmptyBorder BORDER_PANEL = new EmptyBorder(10, 10, 10, 10);

	public static final Dimension DIMENSION_DIALOG_TEXT_FIELD = new Dimension(300, 30);
	public static final Dimension DIMENSION_SEARCH_TEXT_FIELD = new Dimension(570, 30);
	public static final Dimension DIMENSION_TABLE = new Dimension(1000, 400);

	public static final int PADDING_DIALOG = 15;
	public static final int PADDING_DIALOG_GRID_HORIZONTAL = 10;
	public static final int PADDING_DIALOG_GRID_VERTICAL = 10;
	public static final int PADDING_LEFT_PANEL_INFO_PANEL = 5;
	public static final int PADDING_RIGHT_PANEL = 10;
	public static final int PADDING_TABLE_ROW_ADD = 15;
	public static final int PADDING_SEARCH_PANEL_HORIZONTAL = 15;

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
	public static final ImageIcon ICON_BUTTON_SEARCH = new ImageIcon("images/buttonSearch.png");

	public static final ImageIcon ICON_DIALOG_ABOUT = new ImageIcon("images/menuHelpAbout.png");
	public static final ImageIcon ICON_DIALOG_ADD = new ImageIcon("images/menuEditAdd.png");
	public static final ImageIcon ICON_DIALOG_EDIT = new ImageIcon("images/menuEditEdit.png");
	public static final ImageIcon ICON_DIALOG_MEASURY_UNIT = new ImageIcon("images/menuViewMeasuryUnits.png");
	public static final ImageIcon ICON_DIALOG_INGREDIENT_TYPE = new ImageIcon("images/menuViewIngredientTypes.png");
	public static final ImageIcon ICON_DIALOG_FOOD_CATEGORY = new ImageIcon("images/menuViewFoodCategories.png");
	public static final ImageIcon ICON_DIALOG_INGREDIENT = new ImageIcon("images/menuViewIngredients.png");
	public static final ImageIcon ICON_DIALOG_INGREDIENT_WITH_MEASURE = new ImageIcon("images/menuViewIngredients.png");
	public static final ImageIcon ICON_DIALOG_RECIPE_NAME = new ImageIcon("images/menuViewRecipes.png");
	public static final ImageIcon ICON_DIALOG_DESCRIPTION = new ImageIcon("images/menuViewRecipes.png");
	public static final ImageIcon ICON_DIALOG_AMOUNT = new ImageIcon("images/dialogAmount.png");

	public static final ImageIcon ICON_LEFT_PANEL_TITLE = new ImageIcon("images/leftPanelTitle.png");

	public static final ImageIcon ICON_RIGHT_PANEL_INGREDIENT = new ImageIcon("images/menuViewIngredients.png");
	public static final ImageIcon ICON_RIGHT_PANEL_INGREDIENT_TYPE = new ImageIcon(
			"images/menuViewIngredientTypes.png");
	public static final ImageIcon ICON_RIGHT_PANEL_RECIPE = new ImageIcon("images/menuViewRecipes.png");

	public static final ImageIcon ICON_TABLE_INGREDIENT_NAME = new ImageIcon("images/menuViewIngredients.png");
	public static final ImageIcon ICON_TABLE_INGREDIENT_TYPE = new ImageIcon("images/menuViewIngredientTypes.png");
	public static final ImageIcon ICON_TABLE_INGREDIENT_TYPE_NAME = new ImageIcon("images/menuViewIngredientTypes.png");

	public static final ImageIcon ICON_TABLE_RECIPE_NAME = new ImageIcon("images/tableRecipeName.png");
	public static final ImageIcon ICON_TABLE_RECIPE_CATEGORY = new ImageIcon("images/tableRecipeFoodCategories.png");
	public static final ImageIcon ICON_TABLE_RECIPE_INGREDIENTS_WITH_QUANTITY = new ImageIcon(
			"images/tableRecipeIngredients.png");
	public static final ImageIcon ICON_TABLE_RECIPE_RATION = new ImageIcon("images/tableRecipeRation.png");
	public static final ImageIcon ICON_TABLE_RECIPE_DESCRIPTION = new ImageIcon("images/tableRecipeDescription.png");
	public static final ImageIcon ICON_TABLE_RECIPE_TIME = new ImageIcon("images/tableRecipeTime.png");
	public static final ImageIcon ICON_TABLE_COOKING_TIME = new ImageIcon("images/tableRecipeTime.png");

	public static final ImageIcon ICON_SEARCH_MAIN = new ImageIcon("images/searchMain.png");

	public static final int PADDING_SEARCH_PANEL_VERTICAL = 0;
	public static final Icon ICON_SEARCH_NAME = null;
	public static final Icon ICON_SEARCH_CATEGORY = null;
	public static final Icon ICON_SEARCH_INGREDIENT = null;
	public static final Icon ICON_SEARCH_INGREDIENT_TYPE = null;

}
