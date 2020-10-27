package recipeguide.gui.toolbar;

import recipeguide.settings.HandlerCode;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public final class MainToolbar extends AbstractToolbar {

	private static final long serialVersionUID = 1L;

	public MainToolbar() {
		super(Style.BORDER_TOOLBAR_MAIN);
		init();
	}

	@Override
	protected void init() {
		addMainButton(Text.get("toolbarBook"), Style.ICON_TOOLBAR_BOOK, HandlerCode.TOOLBAR_BOOK, "", true);
		addMainButton(Text.get("toolbarMeasuryUnits"), Style.ICON_TOOLBAR_MEASURY_UNITS,
				HandlerCode.TOOLBAR_MEASURY_UNITS, "", true);
		addMainButton(Text.get("toolbarIngredientTypes"), Style.ICON_TOOLBAR_INGREDIENT_TYPES,
				HandlerCode.TOOLBAR_INGREDIENT_TYPES, "", true);
		addMainButton(Text.get("toolbarIngredients"), Style.ICON_TOOLBAR_INGREDIENTS, HandlerCode.TOOLBAR_INGREDIENTS,
				"", true);
		addMainButton(Text.get("toolbarFoodCategories"), Style.ICON_TOOLBAR_FOOD_CATEGORIES,
				HandlerCode.TOOLBAR_FOOD_CATEGORIES, "", true);
		addMainButton(Text.get("toolbarRecipes"), Style.ICON_TOOLBAR_RECIPES, HandlerCode.TOOLBAR_RECIPES, "", true);
		addMainButton(Text.get("toolbarSearchRecipes"), Style.ICON_TOOLBAR_SEARCH_RECIPES, HandlerCode.TOOLBAR_SEARCH_RECIPES, "", true);
	}

}
