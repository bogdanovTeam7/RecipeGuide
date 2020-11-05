package recipeguide.model.entities;

public interface Entity {

	String getNameToDisplay();

	void postAdd();

	void postEdit();

	void postDelete();
}
