package recipeguide.gui.dialog;

import recipeguide.exceptions.ModelException;
import recipeguide.model.entities.Entity;

public interface Dialog {
	abstract void setComponents();

	void setIcons();

	void setValues();

	Entity getEntityFromForm() throws ModelException;

	void setEntity(Entity entity);

}
