package recipeguide.gui.panel;

import java.util.List;

import recipeguide.gui.MainFrame;
import recipeguide.gui.dialog.MeasuryUnitAddEditDialog;
import recipeguide.gui.table.MeasuryUnitTableData;
import recipeguide.gui.toolbar.EditorToolbar;
import recipeguide.gui.toolbar.button.ButtonType;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class MeasuryUnitsPanel extends RightPanel {

	private static final long serialVersionUID = 1L;

	public MeasuryUnitsPanel(MainFrame frame) {
		super(frame, new MeasuryUnitTableData(frame), Text.get("MeasuryUnit"), Style.ICON_RIGHT_PANEL_MEASURY_UNIT,
				List.of(new EditorToolbar(frame, List.of(ButtonType.ADD, ButtonType.EDIT, ButtonType.DELETE),
						List.of(ButtonType.ADD))));
	}

	@Override
	protected void init() {
		super.init();
		setDialog();
	}

	@Override
	void setDialog() {
		dialog = new MeasuryUnitAddEditDialog(frame);
	}

}
