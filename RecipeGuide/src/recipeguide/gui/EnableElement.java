package recipeguide.gui;

import java.util.List;

import recipeguide.gui.toolbar.button.ButtonType;

public interface EnableElement {
	
	void setEnableElement(List<ButtonType> types);

	List<ButtonType> getEnableTypes();

}
