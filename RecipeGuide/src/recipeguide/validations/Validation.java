package recipeguide.validations;

import recipeguide.exceptions.ModelException;

public interface Validation {

	boolean test() throws ModelException;
}
