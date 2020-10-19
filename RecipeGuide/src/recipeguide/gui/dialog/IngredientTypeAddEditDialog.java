package recipeguide.gui.dialog;

import javax.swing.JTextField;

import recipeguide.gui.MainFrame;
import recipeguide.model.entities.Entity;
import recipeguide.model.entities.IngredientType;
import recipeguide.settings.Style;

public class IngredientTypeAddEditDialog extends AddEditDialog {

	private static final long serialVersionUID = 1L;

	public IngredientTypeAddEditDialog(MainFrame frame) {
		super(frame);
	}

	@Override
	void setComponents() {
		components.put("ingredientType", new JTextField());

	}

	@Override
	void setIcons() {
		icons.put("ingredientType", Style.ICON_DIALOG_INGREDIENT_TYPE);

	}

	@Override
	void setValues() {
		if (entity != null & entity instanceof IngredientType) {
			IngredientType type = (IngredientType) entity;
			values.put("ingredientType", type.getName());
		}
	}

	@Override
	Entity getEntityFromForm() {
		String name = ((JTextField) components.get("ingredientType")).getText();
		return new IngredientType(name);
	}

}
