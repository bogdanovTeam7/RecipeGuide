package recipeguide.gui.dialog;

import java.awt.GridLayout;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import recipeguide.exceptions.ModelException;
import recipeguide.gui.MainFrame;
import recipeguide.gui.toolbar.button.MainButton;
import recipeguide.model.Quantity;
import recipeguide.model.entities.Entity;
import recipeguide.model.entities.FoodCategory;
import recipeguide.model.entities.Ingredient;
import recipeguide.model.entities.Recipe;
import recipeguide.saveload.SaveData;
import recipeguide.settings.Format;
import recipeguide.settings.Settings;
import recipeguide.settings.Style;
import recipeguide.settings.Text;
import recipeguide.validations.NotEmptyValidator;
import recipeguide.validations.ParsebleToIntegerValidator;
import recipeguide.validations.ParsebleToLongValidator;

public class RecipeAddEditDialog extends AddEditDialog {

	private static final long serialVersionUID = 1L;
	private Recipe recipe;

	public RecipeAddEditDialog(MainFrame frame, DialogType type) {
		super(frame, type);
	}

	public RecipeAddEditDialog(MainFrame frame) {
		super(frame, null);
	}

	@Override
	public void setEntity(Entity entity) {
		if (entity != null && entity instanceof Recipe) {
			recipe = (Recipe) entity;
		} else {
			recipe = null;
		}
	}

	@Override
	public void setLayoutX() {
		layoutX.add("recipeName");
		layoutX.add("foodCategory");
		layoutX.add("ration");
		layoutX.add("preparingTime");
		layoutX.add("cookingTime");
	}

	@Override
	public void setComponents() {
		components.put("recipeName", new JTextField());
		MainComboBox categoryBox = new MainComboBox(new ArrayList<>(SaveData.getInstance()
				.getCategories()));
		components.put("foodCategory", categoryBox);
		components.put("ration", new JTextField());
		components.put("preparingTime", new JTextField());
		components.put("cookingTime", new JTextField());
		JPanel ingredientsWithQuantityPanel = new JPanel();
		ingredientsWithQuantityPanel.setLayout(new BoxLayout(ingredientsWithQuantityPanel, BoxLayout.Y_AXIS));
		components.put("ingredientsWithMeasure", ingredientsWithQuantityPanel);
		if (recipe != null && dialogType.equals(DialogType.EDIT)) {
			Map<Ingredient, Quantity> ingredientsWihQuantity = recipe.getIngredientsWihQuantity();

			int counter = 1;
			for (Map.Entry<Ingredient, Quantity> entry : ingredientsWihQuantity.entrySet()) {
				JPanel panel = createPanel(entry, counter++);
				ingredientsWithQuantityPanel.add(panel);
				ingredientsWithQuantityPanel.add(Box.createVerticalStrut(Style.PADDING_DIALOG_GRID_VERTICAL));
			}
		}
		components.put("addIngredientWihQuantity", MainButton.builder()
				.withTitle(Text.get("add"))
				.build());
		components.put("description", new JTextArea());
	}

	private JPanel createPanel(Entry<Ingredient, Quantity> entry, int counter) {
		JPanel panel = new JPanel(new GridLayout(1, 3, Style.PADDING_DIALOG_GRID_HORIZONTAL, 0));

		String ingredientWithQuantityDescription = counter + ". " + entry.getKey()
				.getNameToDisplay() + " "
				+ Format.measury(entry.getValue()
						.getAmount())
				+ " " + entry.getValue()
						.getUnit()
						.getNameToDisplay();
		JTextField ingredientPanel = new JTextField(ingredientWithQuantityDescription);
		ingredientPanel.setFont(font);
		ingredientPanel.setEditable(false);
		panel.add(ingredientPanel);

		panel.add(MainButton.builder()
				.withTitle(Text.get("edit"))
				.build());
		panel.add(MainButton.builder()
				.withTitle(Text.get("delete"))
				.build());
		return panel;
	}

	@Override
	public void setIcons() {

		icons.put("recipeName", Style.ICON_DIALOG_RECIPE_NAME);
		icons.put("ration", Style.ICON_DIALOG_RECIPE_RATION);
		icons.put("preparingTime", Style.ICON_DIALOG_RECIPE_PREPARING_TIME);
		icons.put("cookingTime", Style.ICON_DIALOG_RECIPE_COOCING_TIME);
		icons.put("foodCategory", Style.ICON_DIALOG_FOOD_CATEGORY);
		icons.put("ingredientsWithMeasure", Style.ICON_DIALOG_INGREDIENT_WITH_MEASURE);
		icons.put("addIngredientWihQuantity", Style.ICON_DIALOG_ADD);
		icons.put("description", Style.ICON_DIALOG_DESCRIPTION);
	}

	@Override
	public void setValues() {
		if (dialogType.equals(DialogType.EDIT) && recipe != null) {
			values.put("recipeName", recipe.getNameToDisplay());
			values.put("ration", recipe.getRation());
			values.put("preparingTime", recipe.getPreparingTimeInSeconds());
			values.put("cookingTime", recipe.getCookingTimeInSeconds());
			values.put("foodCategory", recipe.getCategory());
			values.put("description", recipe.getDescription());
		}
	}

	@Override
	public Entity getEntityFromForm() throws ModelException {
		String name = ((JTextField) components.get("recipeName")).getText()
				.trim();
		new NotEmptyValidator(name).test();

		String rationAsString = ((JTextField) components.get("ration")).getText()
				.trim();
		new ParsebleToIntegerValidator(rationAsString).test();
		int ration = Integer.parseInt(rationAsString);

		String preparingTimeInSecondsAsString = ((JTextField) components.get("preparingTime")).getText()
				.trim();
		new ParsebleToLongValidator(preparingTimeInSecondsAsString).test();
		long secondsAsString = Long.parseLong(preparingTimeInSecondsAsString);
		Duration preparingTime = Duration.ofSeconds(secondsAsString);

		String cookingTimeInSecondsAsString = ((JTextField) components.get("cookingTime")).getText()
				.trim();
		new ParsebleToLongValidator(cookingTimeInSecondsAsString).test();
		secondsAsString = Long.parseLong(cookingTimeInSecondsAsString);
		Duration cookingTime = Duration.ofSeconds(secondsAsString);

		JComboBox<?> jComboBox = (JComboBox<?>) components.get("foodCategory");
		FoodCategory category = (FoodCategory) jComboBox.getSelectedItem();
		if (category == null) {
			category = Settings.FOOD_CATEGORY_DEFAULT;
		}

		String description = ((JTextArea) components.get("description")).getText();

		Map<Ingredient, Quantity> ingredientsWihQuantity = new LinkedHashMap<>();
		return Recipe.builder()
				.withName(name)
				.withRation(ration)
				.withPreparingTime(preparingTime)
				.withCookingTime(cookingTime)
				.withCategory(category)
				.withDescription(description)
				.withIngredientsWihQuantity(ingredientsWihQuantity)
				.build();
	}

}
