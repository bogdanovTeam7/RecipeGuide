package recipeguide.gui.dialog;

import javax.swing.JTextField;

import recipeguide.exceptions.ModelException;
import recipeguide.gui.MainFrame;
import recipeguide.model.entities.Entity;
import recipeguide.model.entities.IngredientType;
import recipeguide.settings.Style;

public class IngredientTypeAddEditDialog extends AddEditDialog {

	private static final long serialVersionUID = 1L;
	private IngredientType ingredientType;

	public IngredientTypeAddEditDialog(MainFrame frame, DialogType type) {
		super(frame, type);
	}

	@Override
	public void setEntity(Entity entity) {
		super.entity = entity;
		if (entity != null & entity instanceof IngredientType) {
			ingredientType = (IngredientType) entity;
		} else {
			ingredientType = null;
		}
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
		if (dialogType.equals(DialogType.EDIT) && ingredientType != null) {
			values.put("ingredientType", ingredientType.getName());
		}
	}

	@Override
	Entity getEntityFromForm() throws ModelException {
		String name = ((JTextField) components.get("ingredientType")).getText();
		return new IngredientType(name);
	}

}
