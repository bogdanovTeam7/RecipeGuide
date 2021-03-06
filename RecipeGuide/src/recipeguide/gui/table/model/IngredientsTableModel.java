package recipeguide.gui.table.model;

import recipeguide.model.entities.Ingredient;
import recipeguide.saveload.SaveData;

public class IngredientsTableModel extends MainTableModel<Ingredient> {

	private static final long serialVersionUID = 1L;

	private static final int name = 0;
	private static final int type = 1;

	public IngredientsTableModel() {
		super(SaveData.getInstance()
				.getIngredients());
	}

	@Override
	public Object getValueAt(int row, int column) {
		if (datas.isEmpty()) {
			return null;
		}
		Ingredient temp = datas.get(row);
		switch (column) {
		case name:
			return temp.getName();
		case type:
			return temp.getType()
					.getNameToDisplay();
		default:
			return null;
		}
	}

	@Override
	protected void updateData() {
		datas = SaveData.getInstance()
				.getIngredients();
	}

}
