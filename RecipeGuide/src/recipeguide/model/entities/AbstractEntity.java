package recipeguide.model.entities;

import recipeguide.saveload.SaveData;
import recipeguide.settings.Text;

public abstract class AbstractEntity implements Entity {
	protected String name;

	@Override
	public String getTitle() {
		return Text.get(name);
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
