package recipeguide.gui.search.checkboxdatas;

import java.util.LinkedHashMap;
import java.util.Map;

import recipeguide.model.entities.FoodCategory;
import recipeguide.saveload.SaveData;

public class FoodCategoryCheckBoxData implements CheckBoxData<FoodCategory> {

	@Override
	public Map<FoodCategory, String> getData() {
		Map<FoodCategory, String> datas = new LinkedHashMap<>();
		for (FoodCategory category : SaveData.getInstance()
				.getCategories()) {
			datas.put(category, category.getNameToDisplay());
		}
		return datas;
	}

}
