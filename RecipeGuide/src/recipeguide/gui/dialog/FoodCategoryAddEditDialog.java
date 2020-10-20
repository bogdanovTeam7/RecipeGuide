package recipeguide.gui.dialog;

import javax.swing.JTextField;

import recipeguide.exceptions.ModelException;
import recipeguide.gui.MainFrame;
import recipeguide.model.entities.Entity;
import recipeguide.model.entities.FoodCategory;
import recipeguide.settings.Style;

public class FoodCategoryAddEditDialog extends AddEditDialog {

	private static final long serialVersionUID = 1L;
	private FoodCategory category;

	public FoodCategoryAddEditDialog(MainFrame frame, DialogType type) {
		super(frame, type);
	}

	@Override
	public void setEntity(Entity entity) {
		super.entity = entity;
		if (entity != null && entity instanceof FoodCategory) {
			category = (FoodCategory) entity;
		} else {
			category = null;
		}
	}

	@Override
	void setComponents() {
		components.put("foodCategory", new JTextField());
	}

	@Override
	void setIcons() {
		icons.put("foodCategory", Style.ICON_DIALOG_FOOD_CATEGORY);
	}

	@Override
	void setValues() {
		if (dialogType.equals(DialogType.EDIT) && category != null) {
			values.put("foodCategory", category.getName());
		}
	}

	@Override
	Entity getEntityFromForm() throws ModelException {
		String name = ((JTextField) components.get("foodCategory")).getText();
		return new FoodCategory(name);
	}

}