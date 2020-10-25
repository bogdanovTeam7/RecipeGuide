package recipeguide.gui.search.checkboxdatas;

import java.util.LinkedHashMap;
import java.util.Map;

import recipeguide.model.entities.IngredientType;
import recipeguide.saveload.SaveData;

public class IngredientTypeCheckBoxData implements CheckBoxData<IngredientType> {

	@Override
	public Map<IngredientType, String> getData() {
		Map<IngredientType, String> datas = new LinkedHashMap<>();
		for (IngredientType type : SaveData.getInstance()
				.getTypes()) {
			datas.put(type, type.getNameToDisplay());
		}
		return datas;
	}

}
