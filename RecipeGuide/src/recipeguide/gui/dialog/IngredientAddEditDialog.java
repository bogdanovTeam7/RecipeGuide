package recipeguide.gui.dialog;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import recipeguide.exceptions.ModelException;
import recipeguide.gui.MainFrame;
import recipeguide.model.entities.Entity;
import recipeguide.model.entities.Ingredient;
import recipeguide.model.entities.IngredientType;
import recipeguide.saveload.SaveData;
import recipeguide.settings.Style;

public class IngredientAddEditDialog extends AddEditDialog {

	private static final long serialVersionUID = 1L;

	private Ingredient ingredient;

	public IngredientAddEditDialog(MainFrame frame, DialogType type) {
		super(frame, type);
	}

	public IngredientAddEditDialog(MainFrame frame) {
		super(frame, null);
	}

	@Override
	public void setEntity(Entity entity) {
		super.entity = entity;
		if (entity != null && entity instanceof Ingredient) {
			ingredient = (Ingredient) entity;
		} else {
			ingredient = null;
		}
	}

	@Override
	public void setComponents() {
		components.put("ingredientName", new JTextField());
		MainComboBox ingredientTypesBox = new MainComboBox(new ArrayList<>(SaveData.getInstance()
				.getTypes()));
		components.put("ingredientType", ingredientTypesBox);
	}

	@Override
	public void setIcons() {
		icons.put("ingredientName", Style.ICON_DIALOG_INGREDIENT);
		icons.put("ingredientType", Style.ICON_DIALOG_INGREDIENT);
	}

	@Override
	public void setValues() {
		if (dialogType.equals(DialogType.EDIT) && ingredient != null) {
			values.put("ingredientName", ingredient.getName());
			values.put("ingredientType", ingredient.getType());
		}
	}

	@Override
	public Entity getEntityFromForm() throws ModelException {
		String name = ((JTextField) components.get("ingredientName")).getText();
		JComboBox<?> jComboBox = (JComboBox<?>) components.get("ingredientType");
		IngredientType type = (IngredientType) jComboBox.getSelectedItem();
		return new Ingredient(name, type);
	}

}
