package recipeguide.validations;

import recipeguide.exceptions.ModelException;

public class NotEmptyValidator implements Validation {

	private String toTest;

	public NotEmptyValidator(String toTest) {
		this.toTest = toTest;
	}

	@Override
	public boolean test() throws ModelException {
		if (toTest == null || toTest.length() < 1) {
			throw new ModelException(ModelException.TITLE_EMPTY);
		}
		return true;
	}

}
