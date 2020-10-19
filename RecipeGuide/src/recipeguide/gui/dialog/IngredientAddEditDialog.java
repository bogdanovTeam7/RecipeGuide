package recipeguide.gui.dialog;

import java.util.ArrayList;
import javax.swing.JTextField;

import recipeguide.exceptions.ModelException;
import recipeguide.gui.MainFrame;
import recipeguide.model.entities.Entity;
import recipeguide.model.entities.Ingredient;
import recipeguide.saveload.SaveData;
import recipeguide.settings.Style;

public class IngredientAddEditDialog extends AddEditDialog {

	private static final long serialVersionUID = 1L;

	private MainComboBox ingredientTypesBox = new MainComboBox();

	public IngredientAddEditDialog(MainFrame frame) {
		super(frame);
	}

	@Override
	void setComponents() {
		components.put("ingredientName", new JTextField());
		ingredientTypesBox.addItems(new ArrayList<>(SaveData.getInstance()
				.getTypes()));
		components.put("ingredientType", ingredientTypesBox);
	}

	@Override
	void setIcons() {
		icons.put("ingredientName", Style.ICON_DIALOG_INGREDIENT);
		icons.put("ingredientType", Style.ICON_DIALOG_INGREDIENT);
	}

	@Override
	void setValues() {
		if (entity != null && entity instanceof Ingredient) {
			Ingredient ingredient = (Ingredient) entity;
			values.put("ingredientName", ingredient.getName());
			ingredientTypesBox.addItem(ingredient.getType());
			values.put("ingredientType", ingredient.getType());
		}
	}

	@Override
	Entity getEntityFromForm() throws ModelException {
		// TODO Auto-generated method stub
		return null;
	}

}
