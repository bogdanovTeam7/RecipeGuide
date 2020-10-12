package recipeguide.model.entities;

import recipeguide.model.AbstractEntity;

public class MeasuryUnit extends AbstractEntity {

	private String name;
	private String abbreviation;

	public MeasuryUnit() {
	}

	public MeasuryUnit(String name, String abbreviation) {
		this.name = name;
		this.abbreviation = abbreviation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
