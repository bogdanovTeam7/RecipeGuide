package recipeguide.gui.table.model;

import recipeguide.model.entities.MeasuryUnit;
import recipeguide.saveload.SaveData;

public class MeasuryUnitsTableModel extends MainTableModel<MeasuryUnit> {

	private static final long serialVersionUID = 1L;

	private static final int name = 0;
	private static final int abbreviation = 1;

	public MeasuryUnitsTableModel() {
		super(SaveData.getInstance()
				.getUnits());
	}

	@Override
	public Object getValueAt(int row, int column) {
		if (datas.isEmpty()) {
			return null;
		}
		MeasuryUnit temp = datas.get(row);
		switch (column) {
		case name:
			return temp.getName();
		case abbreviation:
			return temp.getAbbreviation();
		default:
			return null;
		}
	}

	@Override
	protected void updateData() {
		datas = SaveData.getInstance()
				.getUnits();
	}

}
