package recipeguide.gui.table.model;

import recipeguide.model.entities.Ingredient;
import recipeguide.saveload.SaveData;

public class IngredientsTableModel extends MainTableModel<Ingredient> {

	private static final long serialVersionUID = 1L;

	public static final int NAME = 0;
	public static final int TYPE = 1;

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
		case NAME:
			return temp.getName();
		case TYPE:
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
