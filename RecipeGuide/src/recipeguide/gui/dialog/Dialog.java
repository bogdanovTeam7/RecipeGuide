package recipeguide.gui.dialog;

import recipeguide.exceptions.ModelException;
import recipeguide.model.entities.Entity;

public interface Dialog {
	void setComponents();

	void setIcons();

	void setValues();

	void setLayoutX();

	Entity getEntityFromForm() throws ModelException;

	void setEntity(Entity entity);

}
