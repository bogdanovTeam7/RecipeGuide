package recipeguide.gui.table.model;

import recipeguide.model.entities.IngredientType;
import recipeguide.saveload.SaveData;

public class IngredientTypesTableModel extends MainTableModel<IngredientType> {

	private static final long serialVersionUID = 1L;
	private static final int name = 0;

	public IngredientTypesTableModel() {
		super(SaveData.getInstance()
				.getTypes());
	}

	@Override
	public Object getValueAt(int row, int column) {
		if (datas.isEmpty()) {
			return null;
		}
		IngredientType type = datas.get(row);
		switch (column) {
		case name:
			return type.getName();
		default:
			return null;
		}
	}

	@Override
	protected void updateData() {
		datas = SaveData.getInstance()
				.getTypes();
	}

}
