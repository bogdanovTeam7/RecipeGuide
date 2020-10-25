package recipeguide.gui.search.checkboxdatas;

import java.util.LinkedHashMap;
import java.util.Map;

import recipeguide.model.entities.Ingredient;
import recipeguide.saveload.SaveData;

public class IngredientCheckBoxData implements CheckBoxData<Ingredient> {

	@Override
	public Map<Ingredient, String> getData() {
		Map<Ingredient, String> datas = new LinkedHashMap<>();
		for (Ingredient ingredient : SaveData.getInstance()
				.getIngredients()) {
			datas.put(ingredient, ingredient.getNameToDisplay());
		}
		return datas;
	}

}
