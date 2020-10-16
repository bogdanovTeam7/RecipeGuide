package recipeguide.settings;

import java.util.HashMap;
import java.util.Map;

final public class Text {

	private static final Map<String, String> data = new HashMap<>();

	public static String get(String key) {
		if (data.containsKey(key)) {
			return data.get(key);
		}
		return "not definition for key. " + key;
	}

	static {
		data.put("ProgramName", "Recept könyv");
		data.put("menuFile", "Könyvtár");
		data.put("menuEdit", "Szerkesztés");
		data.put("menuView", "Nézet");
		data.put("menuHelp", "Segitség");

		data.put("menuFileNew", "Új könyv létrehozása");
		data.put("menuFileOpen", "Betöltés");
		data.put("menuFileSave", "Mentés");
		data.put("menuFileExit", "Kilépés");

		data.put("menuEditAdd", "Hozzáadás");
		data.put("menuEditEdit", "Modosítás");
		data.put("menuEditDelete", "Törlés");

		data.put("menuViewOverview", "Általános");
		data.put("menuViewIngredientTypes", "Alapanyagok csoportosítása");
		data.put("menuViewIngredients", "Alapanyagok");
		data.put("menuViewMeasuryUnits", "Mérési egységek");
		data.put("menuViewFoodCategories", "Ételek csoportosítása");
		data.put("menuViewRecipes", "Receptek");

		data.put("menuHelpAbout", "Programról");

		data.put("toolbarOverview", "Általános");
		data.put("toolbarIngredientTypes", "Alapanyagok csoportosítása");
		data.put("toolbarIngredients", "Alapanyagok");
		data.put("toolbarMeasuryUnits", "Mérési egységek");
		data.put("toolbarFoodCategories", "Ételek csoportosítása");
		data.put("toolbarRecipes", "Receptek");

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
		data.put("toolbarAdd", "Hozzáadás");
		data.put("toolbarEdit", "Modosítás");
		data.put("toolbarDelete", "Törlés");

	}
}
