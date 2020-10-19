package recipeguide.model.entities;

import recipeguide.saveload.SaveData;

public interface Entity {

	String getNameToDisplay();

	void postAdd(SaveData saveData);

	void postEdit(SaveData saveData);

	void postDelete(SaveData saveData);
}
