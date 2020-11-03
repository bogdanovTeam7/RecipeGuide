package recipeguide.gui.table;

import java.util.LinkedHashMap;
import recipeguide.gui.MainFrame;
import recipeguide.gui.table.model.MeasuryUnitsTableModel;
import recipeguide.model.entities.MeasuryUnit;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class MeasuryUnitTableData extends TableDate<MeasuryUnit> {

	private static final long serialVersionUID = 1L;

	public MeasuryUnitTableData(MainFrame frame) {
		super(frame, new LinkedHashMap<>() {

			private static final long serialVersionUID = 1L;
			{
				put(Text.get("measuryUnitName"), Style.ICON_TABLE_MEASURY_UNIT_NAME);
				put(Text.get("measuryUnitAbbreviation"), Style.ICON_TABLE_MEASURY_UNIT_ABBREVIATION);
			}

		}, new MeasuryUnitsTableModel());
	}

}
