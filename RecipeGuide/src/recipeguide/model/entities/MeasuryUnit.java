package recipeguide.model.entities;

import java.util.List;

import recipeguide.saveload.SaveData;
import recipeguide.settings.Settings;
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
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof MeasuryUnit) {
			return name.equals(((MeasuryUnit) obj).getName());
		}
		return false;
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
	public void postEdit() {
		changeMesuryUnitsInRecepts((MeasuryUnit) SaveData.getInstance()
				.getOldEntity(), this);
	}

	@Override
	public void postDelete() {
		changeMesuryUnitsInRecepts(this, Settings.MEASURY_UNIT_DEFAULT);
	}

	public void changeMesuryUnitsInRecepts(MeasuryUnit unitOld, MeasuryUnit unitNew) {
		List<Recipe> recipesByMesuryUnit = SaveData.getInstance()
				.getFilter()
				.getRecipesByMesuryUnit(unitOld);
		for (Recipe recipe : recipesByMesuryUnit) {
			recipe.changeMeasuryUnits(unitOld, unitNew);
			recipe.setDescription(Text.get("measuryChangedInRecipies") + "\n" + recipe.getDescription());
		}
	}

}
