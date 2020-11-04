package recipeguide.gui.table.model;

import recipeguide.model.entities.FoodCategory;
import recipeguide.saveload.SaveData;

public class FoodCategoriesTableModel extends MainTableModel<FoodCategory> {

	private static final long serialVersionUID = 1L;
	private static final int name = 0;

	public FoodCategoriesTableModel() {
		super(SaveData.getInstance()
				.getCategories());
	}

	@Override
	public Object getValueAt(int row, int column) {
		if (datas.isEmpty()) {
			return null;
		}
		FoodCategory category = datas.get(row);
		switch (column) {
		case name:
			return category.getName();
		default:
			return null;
		}
	}

	@Override
	protected void updateData() {
		datas = SaveData.getInstance()
				.getCategories();
	}

}
