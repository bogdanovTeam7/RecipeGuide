package recipeguide.gui.dialog;

import javax.swing.JTextField;

import recipeguide.exceptions.ModelException;
import recipeguide.gui.MainFrame;
import recipeguide.model.entities.Entity;

public class RecipeAddEditDialog extends AddEditDialog {

	private static final long serialVersionUID = 1L;
	private MainComboBox categoryBox = new MainComboBox();

	public RecipeAddEditDialog(MainFrame frame) {
		super(frame);
	}

	@Override
	void setComponents() {
		components.put("recipeName", new JTextField());
		components.put("foodCategory", categoryBox);
		components.put("recipeName", new JTextField());
		components.put("recipeName", new JTextField());
		// TODO Auto-generated method stub

	}

	@Override
	void setIcons() {
		// TODO Auto-generated method stub

	}

	@Override
	void setValues() {
		// TODO Auto-generated method stub

	}

	@Override
	Entity getEntityFromForm() throws ModelException {
		// TODO Auto-generated method stub
		return null;
	}

}
