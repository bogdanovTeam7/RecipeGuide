package recipeguide.model.entities;

import java.util.Objects;

import recipeguide.saveload.SaveData;

public abstract class AbstractEntity implements Entity {
	protected String name;

	private String getName() {
		return name;
	}

	@Override
	public String getNameToDisplay() {
		return name;
	}

	@Override
	public void postAdd() {
	}

	@Override
	public void postEdit() {
	}

	@Override
	public void postDelete() {
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof AbstractEntity)) {
			return false;
		}
		AbstractEntity other = (AbstractEntity) obj;
		return Objects.equals(name, other.getName());
	}

}
