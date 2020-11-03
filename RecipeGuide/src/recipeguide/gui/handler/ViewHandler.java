package recipeguide.gui.handler;

import java.awt.event.ActionEvent;

import recipeguide.gui.MainFrame;
import recipeguide.gui.panel.BookPanel;
import recipeguide.gui.panel.IngredientTypesPanel;
import recipeguide.gui.panel.IngredientsPanel;
import recipeguide.gui.panel.MeasuryUnitsPanel;
import recipeguide.gui.panel.RecipePanel;
import recipeguide.gui.panel.SearchPanel;
import recipeguide.settings.HandlerCode;

public class ViewHandler extends Handler {

	public ViewHandler(MainFrame frame) {
		super(frame);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case HandlerCode.MENU_VIEW_BOOK:
			showBookPanel();
			break;
		case HandlerCode.MENU_VIEW_INGREDIENT_TYPES:
			showIngredientTypesPanel();
			break;
		case HandlerCode.MENU_VIEW_INGREDIENTS:
			showIngredientsPanel();
			break;
		case HandlerCode.MENU_VIEW_FOOD_CATEGORIES:
			showCategoriesPanel();
			break;
		case HandlerCode.MENU_VIEW_MEASURY_UNITS:
			showMeasuryUnitsPanel();
			break;
		case HandlerCode.MENU_VIEW_RECIPES:
			showRecipesPanel();
			break;
		case HandlerCode.MENU_VIEW_SEARCH:
			showSearchPanel();
			break;
		}
		frame.refresh();
	}

	private void showSearchPanel() {
		frame.setRightPanel(new SearchPanel(frame));
	}

	private void showRecipesPanel() {
		frame.setRightPanel(new RecipePanel(frame));
	}

	private void showMeasuryUnitsPanel() {
		frame.setRightPanel(new MeasuryUnitsPanel(frame));
	}

	private void showCategoriesPanel() {
//		frame.setRightPanel(new CategoriesPanel(frame));
		// TODO Auto-generated method stub

	}

	private void showIngredientsPanel() {
		frame.setRightPanel(new IngredientsPanel(frame));
	}

	private void showIngredientTypesPanel() {
		frame.setRightPanel(new IngredientTypesPanel(frame));
	}

	private void showBookPanel() {
		frame.setRightPanel(new BookPanel(frame));
	}

}
