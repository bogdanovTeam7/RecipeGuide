package recipeguide.gui.dialog;

public enum DialogType {
	EDIT("edit"),
	ADD("add");

	private String action;

	private DialogType(String action) {
		this.action = action;
	}

	public String getAction() {
		return action;
	}

}
