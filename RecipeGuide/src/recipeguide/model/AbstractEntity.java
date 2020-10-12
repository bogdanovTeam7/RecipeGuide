package recipeguide.model;

public abstract class AbstractEntity implements Entity {

	@Override
	public String getDescription() {
		return null;
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

}
