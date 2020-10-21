package recipeguide.tests;

import recipeguide.gui.MainFrame;
import recipeguide.gui.dialog.DialogType;
import recipeguide.gui.dialog.FoodCategoryAddEditDialog;
import recipeguide.gui.dialog.IngredientAddEditDialog;
import recipeguide.gui.dialog.IngredientTypeAddEditDialog;
import recipeguide.gui.dialog.IngredientWithMeasuringAddEditDialog;
import recipeguide.gui.dialog.MeasuryUnitAddEditDialog;
import recipeguide.gui.dialog.RecipeAddEditDialog;
import recipeguide.model.Quantity;
import recipeguide.model.entities.FoodCategory;
import recipeguide.model.entities.Ingredient;
import recipeguide.model.entities.IngredientType;
import recipeguide.model.entities.IngredientWithQuantity;
import recipeguide.model.entities.MeasuryUnit;
import recipeguide.model.entities.Recipe;
import recipeguide.saveload.SaveData;

public class TestDialogs {
	private MainFrame frame;
	private DialogType dialogType = DialogType.ADD;

	public TestDialogs() {
	}

	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}

	public void setDialogType(DialogType dialogType) {
		this.dialogType = dialogType;
	}

	public void test() {

		dialogType = DialogType.ADD;
		IngredientTypeAddEditDialog ingredientTypeAddEditDialog = new IngredientTypeAddEditDialog(frame, dialogType);
		IngredientType type = new IngredientType("water");
		ingredientTypeAddEditDialog.setEntity(type);
		ingredientTypeAddEditDialog.showDialog();

		MeasuryUnitAddEditDialog measuryUnitAddEditDialog = new MeasuryUnitAddEditDialog(frame, dialogType);
		MeasuryUnit unit = new MeasuryUnit("tonna", "t");
		measuryUnitAddEditDialog.setEntity(unit);
		measuryUnitAddEditDialog.showDialog();

		FoodCategoryAddEditDialog foodCategoryAddEditDialog = new FoodCategoryAddEditDialog(frame, dialogType);
		FoodCategory category = new FoodCategory("soup");
		foodCategoryAddEditDialog.setEntity(category);
		foodCategoryAddEditDialog.showDialog();

		IngredientAddEditDialog ingredientAddEditDialog = new IngredientAddEditDialog(frame, dialogType);
		Ingredient ingredient = new Ingredient("salt", SaveData.getInstance()
				.getTypes()
				.get(3));
		ingredientAddEditDialog.setEntity(ingredient);
		ingredientAddEditDialog.showDialog();

		RecipeAddEditDialog recipeAddEditDialog = new RecipeAddEditDialog(frame, dialogType);
		Recipe recipe = SaveData.getInstance()
				.getRecipes()
				.get(2);
		recipeAddEditDialog.setEntity(recipe);
		recipeAddEditDialog.showDialog();

		IngredientWithMeasuringAddEditDialog ingredientWithMeasuringAddEditDialog = new IngredientWithMeasuringAddEditDialog(
				frame, dialogType);
		ingredientWithMeasuringAddEditDialog.setEntity(new IngredientWithQuantity(SaveData.getInstance()
				.getIngredients()
				.get(0),
				new Quantity(SaveData.getInstance()
						.getUnits()
						.get(0), 100)));
		ingredientWithMeasuringAddEditDialog.showDialog();
	}

}
