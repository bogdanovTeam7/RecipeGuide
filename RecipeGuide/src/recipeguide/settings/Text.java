package recipeguide.settings;

import java.util.HashMap;
import java.util.Map;

final public class Text {

	private static final Map<String, String> data = new HashMap<>();

	public static String get(String key) {
		return data.get(key);
	}

	static {
		data.put("ProgramName", "Recept könyv");
		data.put("MenuFile", "Fájl");
		data.put("MenuEdit", "Modosítás");
		data.put("MenuView", "Nézet");
		data.put("MenuHelp", "Segitség");

		data.put("NoDescription", "Nincs leírás");

		data.put("January", "Január");
		data.put("February", "Február");
		data.put("March", "Március");
		data.put("April", "Április");
		data.put("May", "Május");
		data.put("June", "Június");
		data.put("July", "Július");
		data.put("August", "Augusztus");
		data.put("September", "Szeptember");
		data.put("October", "Október");
		data.put("November", "November");
		data.put("December", "December");

		data.put("errorTitleEmpty", "Üres a megnevezés");
		data.put("errorIsExist", "Ilyen nev már létezik");
		data.put("errorNumberFormat", "Hibás szám");
		data.put("errorMesuryEmpty", "Üres mérték egység");
		data.put("errorTypeEmpty", "Üres típus");
		data.put("errorIngredientsListEmpty", "Üres alapanyagok listaja");
		data.put("errorIngredientsEmpty", "Üres alapanyag");
		data.put("errorUnknown", "Ismeretlen hiba");

	}
}
