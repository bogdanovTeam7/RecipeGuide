package recipeguide.model.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import recipeguide.model.Quantity;
import recipeguide.saveload.SaveData;
import recipeguide.settings.Text;

public class MeasuryUnit extends AbstractEntity {

	private String abbreviation;

	public MeasuryUnit() {
	}

	public MeasuryUnit(String name, String abbreviation) {
		super.name = name;
		this.abbreviation = abbreviation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		super.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MeasuryUnit [name=");
		builder.append(name);
		builder.append(", abbreviation=");
		builder.append(abbreviation);
		builder.append("]");
		return builder.toString();
	}

	public String getFullDescription() {
		return name + " (" + abbreviation + ")";
	}

	@Override
	public void postEdit(SaveData saveData) {

		for (Recipe recipe : saveData.getFilter()
				.getRecipesByMesuryUnit((MeasuryUnit) saveData.getOldEntity())) {
			Map<Ingredient, Quantity> ingredientsWihQuantity = recipe.getIngredientsWihQuantity();

			for (Map.Entry<Ingredient, Quantity> entry : recipe.getIngredientsWihQuantity()
					.entrySet()) {
				if (entry.getValue()
						.getUnit()
						.equals((MeasuryUnit) saveData.getOldEntity())) {
					Ingredient key = entry.getKey();
					Quantity value = new Quantity(this, 0);
					ingredientsWihQuantity.put(key, value);
				}
			}
			recipe.setIngredientsWihQuantity(ingredientsWihQuantity);
			recipe.setDescription(Text.get("measuryChangedInRecipies") + "\n" + recipe.getDescription());
		}
	}

	@Override
	public void postDelete(SaveData saveData) {
		// TODO Auto-generated method stub
		super.postDelete(saveData);
	}

}
