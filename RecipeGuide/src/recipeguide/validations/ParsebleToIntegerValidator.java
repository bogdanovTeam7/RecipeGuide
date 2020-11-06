package recipeguide.validations;

import recipeguide.exceptions.ModelException;

public class ParsebleToIntegerValidator implements Validation {
	private String toTest;

	public ParsebleToIntegerValidator(String toTest) {
		this.toTest = toTest;
	}

	@Override
	public boolean test() throws ModelException {
		if (toTest == null) {
			return false;
		}
		try {
			Integer.parseInt(toTest);
		} catch (Exception e) {
			throw new ModelException(ModelException.NUMBER_FORMAT);
		}
		return true;
	}

}
