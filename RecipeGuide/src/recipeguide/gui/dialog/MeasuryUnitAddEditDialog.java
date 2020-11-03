package recipeguide.gui.dialog;

import javax.swing.JTextField;

import recipeguide.exceptions.ModelException;
import recipeguide.gui.MainFrame;
import recipeguide.model.entities.Entity;
import recipeguide.model.entities.MeasuryUnit;
import recipeguide.settings.Style;

public class MeasuryUnitAddEditDialog extends AddEditDialog {

	private static final long serialVersionUID = 1L;
	private MeasuryUnit unit;

	public MeasuryUnitAddEditDialog(MainFrame frame, DialogType type) {
		super(frame, type);
	}

	public MeasuryUnitAddEditDialog(MainFrame frame) {
		super(frame, null);
	}

	@Override
	public void setEntity(Entity entity) {
		super.entity = entity;
		if (entity != null && entity instanceof MeasuryUnit) {
			unit = (MeasuryUnit) entity;
		} else {
			unit = null;
		}
	}

	@Override
	public void setComponents() {
		components.put("measuryUnitName", new JTextField());
		components.put("measuryUnitAbbreviation", new JTextField());
	}

	@Override
	public void setIcons() {
		icons.put("measuryUnitName", Style.ICON_DIALOG_MEASURY_UNIT);
		icons.put("measuryUnitAbbreviation", Style.ICON_DIALOG_MEASURY_UNIT);
	}

	@Override
	public void setValues() {
		if (dialogType.equals(DialogType.EDIT) && unit != null) {
			values.put("measuryUnitName", unit.getName());
			values.put("measuryUnitAbbreviation", unit.getAbbreviation());
		}
	}

	@Override
	public Entity getEntityFromForm() throws ModelException {
		String name = ((JTextField) components.get("measuryUnitName")).getText();
		String abbreviation = ((JTextField) components.get("measuryUnitAbbreviation")).getText();
		return new MeasuryUnit(name, abbreviation);
	}

}
