package recipeguide.gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Arrays;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import recipeguide.gui.dialog.AboutDialog;
import recipeguide.gui.dialog.ConfirmDialog;
import recipeguide.gui.dialog.DialogType;
import recipeguide.gui.dialog.ErrorDialog;
import recipeguide.gui.dialog.FoodCategoryAddEditDialog;
import recipeguide.gui.dialog.IngredientAddEditDialog;
import recipeguide.gui.dialog.IngredientTypeAddEditDialog;
import recipeguide.gui.dialog.IngredientWithMeasuringAddEditDialog;
import recipeguide.gui.dialog.MeasuryUnitAddEditDialog;
import recipeguide.gui.dialog.RecipeAddEditDialog;
import recipeguide.gui.menu.MainMenu;
import recipeguide.gui.toolbar.EditorToolbar;
import recipeguide.gui.toolbar.MainToolbar;
import recipeguide.model.Quantity;
import recipeguide.model.entities.FoodCategory;
import recipeguide.model.entities.Ingredient;
import recipeguide.model.entities.IngredientType;
import recipeguide.model.entities.IngredientWithQuantity;
import recipeguide.model.entities.MeasuryUnit;
import recipeguide.model.entities.Recipe;
import recipeguide.saveload.SaveData;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class MainFrame extends JFrame implements Refresh {

	private static final long serialVersionUID = 1L;

	private GridBagConstraints constraints;
	private MainMenu menubar;
	private MainToolbar mainToolbar;

	public MainFrame() {
		super(Text.get("ProgramName"));

		DialogType dialogType = DialogType.ADD;
//		IngredientTypeAddEditDialog ingredientTypeAddEditDialog = new IngredientTypeAddEditDialog(this, dialogType);
//		IngredientType type = new IngredientType("water");
//		ingredientTypeAddEditDialog.setEntity(type);
//		ingredientTypeAddEditDialog.showDialog();
//
//		MeasuryUnitAddEditDialog measuryUnitAddEditDialog = new MeasuryUnitAddEditDialog(this, dialogType);
//		MeasuryUnit unit = new MeasuryUnit("tonna", "t");
//		measuryUnitAddEditDialog.setEntity(unit);
//		measuryUnitAddEditDialog.showDialog();
//
//		FoodCategoryAddEditDialog foodCategoryAddEditDialog = new FoodCategoryAddEditDialog(this, dialogType);
//		FoodCategory category = new FoodCategory("soup");
//		foodCategoryAddEditDialog.setEntity(category);
//		foodCategoryAddEditDialog.showDialog();
//
//		IngredientAddEditDialog ingredientAddEditDialog = new IngredientAddEditDialog(this, dialogType);
//		Ingredient ingredient = new Ingredient("salt", SaveData.getInstance()
//				.getTypes()
//				.get(3));
//		ingredientAddEditDialog.setEntity(ingredient);
//		ingredientAddEditDialog.showDialog();
//
//		RecipeAddEditDialog recipeAddEditDialog = new RecipeAddEditDialog(this, dialogType);
//		Recipe recipe = SaveData.getInstance()
//				.getRecipes()
//				.get(2);
//		recipeAddEditDialog.setEntity(recipe);
//		recipeAddEditDialog.showDialog();

		IngredientWithMeasuringAddEditDialog ingredientWithMeasuringAddEditDialog = new IngredientWithMeasuringAddEditDialog(
				this, dialogType);
		ingredientWithMeasuringAddEditDialog.setEntity(new IngredientWithQuantity(SaveData.getInstance()
				.getIngredients()
				.get(0),
				new Quantity(SaveData.getInstance()
						.getUnits()
						.get(0), 100)));
		ingredientWithMeasuringAddEditDialog.showDialog();

		setResizable(false);
		setIconImage(Style.ICON_MAIN.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Style.COLOR_MAIN_FRAME);

		menubar = new MainMenu(this);
		setJMenuBar(menubar);

		setLayout(new GridBagLayout());

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

	@Override
	public void refresh() {
		SwingUtilities.updateComponentTreeUI(this);
		menubar.refresh();
		pack();

	}

}
