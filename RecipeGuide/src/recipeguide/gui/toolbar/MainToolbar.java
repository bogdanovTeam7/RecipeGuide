package recipeguide.gui.toolbar;

import recipeguide.gui.MainFrame;
import recipeguide.gui.handler.Handler;
import recipeguide.gui.handler.ViewHandler;
import recipeguide.gui.toolbar.button.ButtonType;
import recipeguide.settings.HandlerCode;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public final class MainToolbar extends AbstractToolbar {

	private static final long serialVersionUID = 1L;

	public MainToolbar(MainFrame frame) {
		super(frame, Style.BORDER_TOOLBAR_MAIN);
		init();
	}

	@Override
	protected void init() {
		Handler viewHandler = new ViewHandler(frame);
		addMainButton(Text.get("toolbarBook"), Style.ICON_TOOLBAR_BOOK, viewHandler, HandlerCode.MENU_VIEW_BOOK, true,
				ButtonType.UNSPECIFIED);
		addMainButton(Text.get("toolbarMeasuryUnits"), Style.ICON_TOOLBAR_MEASURY_UNITS, viewHandler,
				HandlerCode.MENU_VIEW_MEASURY_UNITS, true, ButtonType.UNSPECIFIED);
		addMainButton(Text.get("toolbarIngredientTypes"), Style.ICON_TOOLBAR_INGREDIENT_TYPES, viewHandler,
				HandlerCode.MENU_VIEW_INGREDIENT_TYPES, true, ButtonType.UNSPECIFIED);
		addMainButton(Text.get("toolbarIngredients"), Style.ICON_TOOLBAR_INGREDIENTS, viewHandler,
				HandlerCode.MENU_VIEW_INGREDIENTS, true, ButtonType.UNSPECIFIED);
		addMainButton(Text.get("toolbarFoodCategories"), Style.ICON_TOOLBAR_FOOD_CATEGORIES, viewHandler,
				HandlerCode.MENU_VIEW_FOOD_CATEGORIES, true, ButtonType.UNSPECIFIED);
		addMainButton(Text.get("toolbarRecipes"), Style.ICON_TOOLBAR_RECIPES, viewHandler,
				HandlerCode.MENU_VIEW_RECIPES, true, ButtonType.UNSPECIFIED);
		addMainButton(Text.get("toolbarSearchRecipes"), Style.ICON_TOOLBAR_SEARCH_RECIPES, viewHandler,
				HandlerCode.MENU_VIEW_SEARCH, true, ButtonType.UNSPECIFIED);
	}

}
