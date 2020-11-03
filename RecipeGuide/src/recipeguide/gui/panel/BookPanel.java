package recipeguide.gui.panel;

import java.util.List;

import recipeguide.gui.MainFrame;
import recipeguide.gui.dialog.BookDialog;
import recipeguide.gui.toolbar.EditorToolbar;
import recipeguide.gui.toolbar.button.ButtonType;
import recipeguide.model.entities.Entity;
import recipeguide.saveload.SaveData;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class BookPanel extends RightPanel {

	private static final long serialVersionUID = 1L;

	public BookPanel(MainFrame frame) {
		super(frame, Text.get("bookDatas"), Style.ICON_RIGHT_PANEL_BOOK, List.of(new BookDataPanel(frame),
				new EditorToolbar(frame, List.of(ButtonType.EDIT), List.of(ButtonType.EDIT))));
	}

	@Override
	public Entity getSelectedeEtity() {
		return SaveData.getInstance()
				.getBook();
	}

	@Override
	protected void init() {
		super.init();
		setDialog();
	}

	@Override
	void setDialog() {
		dialog = new BookDialog(frame);
		dialog.setEntity(SaveData.getInstance()
				.getBook());
	}

}
