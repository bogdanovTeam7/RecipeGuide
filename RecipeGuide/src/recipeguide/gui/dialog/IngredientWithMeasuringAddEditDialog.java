package recipeguide.gui.dialog;

import java.util.ArrayList;

import javax.swing.JTextField;

import recipeguide.exceptions.ModelException;
import recipeguide.gui.MainFrame;
import recipeguide.gui.toolbar.button.MainButton;
import recipeguide.model.entities.Entity;
import recipeguide.model.entities.IngredientWithQuantity;
import recipeguide.saveload.SaveData;
import recipeguide.settings.Format;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class IngredientWithMeasuringAddEditDialog extends AddEditDialog {

	private static final long serialVersionUID = 1L;
	private IngredientWithQuantity ingredientWithQuantity;

	public IngredientWithMeasuringAddEditDialog(MainFrame frame, DialogType type) {
		super(frame, type);
	}

	@Override
	public void setEntity(Entity entity) {
		if (entity != null && entity instanceof IngredientWithQuantity) {
			ingredientWithQuantity = (IngredientWithQuantity) entity;
		}
	}

	@Override
	public void setComponents() {
		components.put("ingredient", new MainComboBox(new ArrayList<>(SaveData.getInstance()
				.getIngredients())));
		components.put("ingredientNew", MainButton.builder()
				.withTitle(Text.get("add"))
				.build());
		components.put("measuryUnit", new MainComboBox(new ArrayList<>(SaveData.getInstance()
				.getUnits())));
		components.put("measuryUnitNew", MainButton.builder()
				.withTitle(Text.get("add"))
				.build());
		components.put("amount", new JTextField());
	}

	@Override
	public void setIcons() {
		icons.put("ingredient", Style.ICON_DIALOG_INGREDIENT);
		icons.put("ingredientNew", Style.ICON_DIALOG_ADD);
		icons.put("measuryUnit", Style.ICON_DIALOG_MEASURY_UNIT);
		icons.put("measuryUnitNew", Style.ICON_DIALOG_ADD);
		icons.put("amount", Style.ICON_DIALOG_AMOUNT);
	}

	@Override
	public void setValues() {
		values.put("amount", Format.measury(0));
		if (dialogType.equals(DialogType.EDIT) && ingredientWithQuantity != null) {
			values.put("ingredient", ingredientWithQuantity.getIngredient());
			values.put("measuryUnit", ingredientWithQuantity.getQuantity()
					.getUnit());
			values.put("amount", Format.measury(ingredientWithQuantity.getQuantity()
					.getAmount()));
		}
	}

	@Override
	public Entity getEntityFromForm() throws ModelException {
		// TODO Auto-generated method stub
		return null;
	}

}
