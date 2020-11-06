package recipeguide.validations;

import recipeguide.exceptions.ModelException;

public class ParsebleToLongValidator implements Validation {
	private String toTest;

	public ParsebleToLongValidator(String toTest) {
		this.toTest = toTest;
	}

	@Override
	public boolean test() throws ModelException {
		if (toTest == null) {
			return false;
		}
		try {
			Long.parseLong(toTest);
		} catch (Exception e) {
			throw new ModelException(ModelException.NUMBER_FORMAT);
		}
		return true;
	}

}
