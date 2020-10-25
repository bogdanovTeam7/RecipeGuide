package recipeguide.model.entities;

import recipeguide.saveload.SaveData;

public abstract class AbstractEntity implements Entity {
	protected String name;

	@Override
	public String getNameToDisplay() {
		return name;
	}

	@Override
	public void postAdd(SaveData saveData) {
	}

	@Override
	public void postEdit(SaveData saveData) {
	}

	@Override
	public void postDelete(SaveData saveData) {
	}

}
