package recipeguide.gui.dialog;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import recipeguide.exceptions.ModelException;
import recipeguide.gui.MainFrame;
import recipeguide.gui.toolbar.button.MainButton;
import recipeguide.model.Quantity;
import recipeguide.model.entities.Entity;
import recipeguide.model.entities.Ingredient;
import recipeguide.model.entities.Recipe;
import recipeguide.saveload.SaveData;
import recipeguide.settings.Format;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

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
	public void setComponents() {
		components.put("recipeName", new JTextField());
		MainComboBox categoryBox = new MainComboBox(new ArrayList<>(SaveData.getInstance()
				.getCategories()));
		components.put("foodCategory", categoryBox);
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
		icons.put("foodCategory", Style.ICON_DIALOG_FOOD_CATEGORY);
		icons.put("ingredientsWithMeasure", Style.ICON_DIALOG_INGREDIENT_WITH_MEASURE);
		icons.put("addIngredientWihQuantity", Style.ICON_DIALOG_ADD);
		icons.put("description", Style.ICON_DIALOG_DESCRIPTION);
	}

	@Override
	public void setValues() {
		if (dialogType.equals(DialogType.EDIT) && recipe != null) {
			values.put("recipeName", recipe.getNameToDisplay());
			values.put("foodCategory", recipe.getCategory());
			values.put("description", recipe.getDescription());
		}
	}

	@Override
	public Entity getEntityFromForm() throws ModelException {
		// TODO Auto-generated method stub
		return null;
	}

}
