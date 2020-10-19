package recipeguide.gui.dialog;

import javax.swing.JTextField;

import recipeguide.gui.MainFrame;
import recipeguide.model.entities.Entity;
import recipeguide.model.entities.MeasuryUnit;
import recipeguide.settings.Style;

public class MeasuryUnitAddEditDialog extends AddEditDialog {

	private static final long serialVersionUID = 1L;

	public MeasuryUnitAddEditDialog(MainFrame frame) {
		super(frame);
	}

	@Override
	void setComponents() {
		components.put("measuryUnitName", new JTextField());
		components.put("measuryUnitAbbreviation", new JTextField());
	}

	@Override
	void setIcons() {
		icons.put("measuryUnitName", Style.ICON_DIALOG_MEASURY_UNIT);
		icons.put("measuryUnitAbbreviation", Style.ICON_DIALOG_MEASURY_UNIT);
	}

	@Override
	void setValues() {
		if (entity != null && entity instanceof MeasuryUnit) {
			MeasuryUnit unit = (MeasuryUnit) entity;
			values.put("measuryUnitName", unit.getName());
			values.put("measuryUnitAbbreviation", unit.getAbbreviation());
		}
	}

	@Override
	Entity getEntityFromForm() {
		String name = ((JTextField) components.get("measuryUnitName")).getText();
		String abbreviation = ((JTextField) components.get("measuryUnitAbbreviation")).getText();
		return new MeasuryUnit(name, abbreviation);
	}

}
