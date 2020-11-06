package recipeguide.gui.dialog;

import javax.swing.JTextField;

import recipeguide.exceptions.ModelException;
import recipeguide.gui.MainFrame;
import recipeguide.model.entities.Entity;
import recipeguide.model.entities.FoodCategory;
import recipeguide.settings.Style;
import recipeguide.validations.NotEmptyValidator;

public class FoodCategoryAddEditDialog extends AddEditDialog {

	private static final long serialVersionUID = 1L;
	private FoodCategory category;

	public FoodCategoryAddEditDialog(MainFrame frame, DialogType type) {
		super(frame, type);
	}

	public FoodCategoryAddEditDialog(MainFrame frame) {
		super(frame, null);
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
	public void setComponents() {
		components.put("foodCategory", new JTextField());
	}

	@Override
	public void setIcons() {
		icons.put("foodCategory", Style.ICON_DIALOG_FOOD_CATEGORY);
	}

	@Override
	public void setValues() {
		if (dialogType.equals(DialogType.EDIT) && category != null) {
			values.put("foodCategory", category.getName());
		}
	}

	@Override
	public Entity getEntityFromForm() throws ModelException {
		String name = ((JTextField) components.get("foodCategory")).getText()
				.trim();
		new NotEmptyValidator(name).test();
		return new FoodCategory(name);
	}

}
