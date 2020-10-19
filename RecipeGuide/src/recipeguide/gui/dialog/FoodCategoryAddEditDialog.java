package recipeguide.gui.dialog;

import javax.swing.JTextField;

import recipeguide.gui.MainFrame;
import recipeguide.model.entities.Entity;
import recipeguide.model.entities.FoodCategory;
import recipeguide.settings.Style;

public class FoodCategoryAddEditDialog extends AddEditDialog {

	private static final long serialVersionUID = 1L;

	public FoodCategoryAddEditDialog(MainFrame frame) {
		super(frame);
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
		if (entity != null && entity instanceof FoodCategory) {
			FoodCategory category = (FoodCategory) entity;
			values.put("foodCategory", category.getName());
		}
	}

	@Override
	Entity getEntityFromForm() {
		String name = ((JTextField) components.get("foodCategory")).getText();
		return new FoodCategory(name);
	}

}
