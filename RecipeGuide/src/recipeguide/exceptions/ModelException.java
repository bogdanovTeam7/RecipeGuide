package recipeguide.exceptions;

import recipeguide.settings.Text;

public class ModelException extends Exception {

	private static final long serialVersionUID = 1L;

	public static final CodeScript TITLE_EMPTY = new CodeScript(1, "errorTitleEmpty");

	public static final CodeScript NUMBER_FORMAT = new CodeScript(10, "errorNumberFormat");;

	public static final CodeScript ENTITY_EXISTS = new CodeScript(20, "errorEntityExists");;
	public static final CodeScript ENTITY_DEFAULT = new CodeScript(21, "errorEntityDefault");;
	public static final CodeScript ENTITY_BASIC_INVALID_TO_DELETE = new CodeScript(22,
			"errorBasicEntityInvalidToDelete");;
	public static final CodeScript ENTITY_TO_EDIT_DONT_CHOOSEN = new CodeScript(21, "errorEntityToEditDontChoosen");

	public static final CodeScript TYPE_EMPTY = new CodeScript(30, "errorTypeEmpty");;

	public static final CodeScript MEASURY_EMPTY = new CodeScript(40, "errorMeasuryEmpty");;

	public static final CodeScript INGREDIENT_LIST_EMPTY = new CodeScript(50, "errorIngredientListEmpty");;
	public static final CodeScript INGREDIENT_EMPTY = new CodeScript(51, "errorIngredientEmpty");

	private CodeScript codeScript;

	public ModelException(CodeScript codeScript) {
		this.codeScript = codeScript;
	}

	@Override
	public String getMessage() {
		return codeScript.getTitle();
	}

}
