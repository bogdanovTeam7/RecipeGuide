package recipeguide.exceptions;

import recipeguide.settings.Text;

public class ModalException extends Exception {

	private static final long serialVersionUID = 1L;

	public static final int TITLE_EMPTY = 1;
	public static final int IS_EXIST = 2;
	public static final int NUMBER_FORMAT = 3;
	public static final int TYPE_EMPTY = 4;
	public static final int MESURY_EMPTY = 5;
	public static final int INGREDIENT_LIST_EMPTY = 6;
	public static final int INGREDIENT_EMPTY = 7;

	private int code;

	public ModalException(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public String getMassege() {
		switch (code) {
		case TITLE_EMPTY:
			return Text.get("errorTitleEmpty");
		case IS_EXIST:
			return Text.get("errorIsExist");
		case NUMBER_FORMAT:
			return Text.get("errorNumberFormat");
		case TYPE_EMPTY:
			return Text.get("errorTypeEmpty");
		case MESURY_EMPTY:
			return Text.get("errorMesuryEmpty");
		case INGREDIENT_LIST_EMPTY:
			return Text.get("errorIngredientsListEmpty");
		case INGREDIENT_EMPTY:
			return Text.get("errorIngredientsEmpty");
		default:
			return "errorUnknown";
		}
	}
}
