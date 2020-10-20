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
		data.put("ProgramName", "Receptek");

		data.put("ingredientType", "Alapanyagok csoportja");
		data.put("ingredient", "Alapanyag");
		data.put("ingredientName", "Alapanyag neve");
		data.put("ingredientNew", "Új alapanyag");
		data.put("ingredientsWithMeasure", "Alapanyagok adagolással");

		data.put("measuryUnit", "Mérési egység");
		data.put("measuryUnitName", "Mérési egység neve");
		data.put("measuryUnitNew", "Új mérési egység");
		data.put("measuryUnitAbbreviation", "Mérési egység rövíditése");

		data.put("foodCategory", "Ételek csoportja");

		data.put("recipe", "Recept");
		data.put("recipeName", "Recept megnevezése");

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
		data.put("description", "Leírás");

		data.put("amount", "Mennyiség");

		data.put("yes", "Igen");
		data.put("no", "Nem");

		data.put("add", "Hozzaadás");
		data.put("addIngredientWihQuantity", "Új alapanyg és mennyiségét hozzaadása");
		data.put("edit", "Modosítás");
		data.put("delete", "Törlés");
		data.put("cancel", "Visszavonás");

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

		data.put("Kurale", "kurale");
		data.put("Nexa Script Light", "nexaScriptLight");
		data.put("Vinque Rg", "vinqueRG");
		data.put("Michroma", "michroma");
		data.put("RF Krabuler", "rFKrabuler");

		data.put("error", "Hiba");
		data.put("errorTitleEmpty", "Üres a megnevezés");
		data.put("errorIsExist", "Ilyen nev már létezik");
		data.put("errorNumberFormat", "Hibás szám");
		data.put("errorMesuryEmpty", "Üres mérték egység");
		data.put("errorTypeEmpty", "Üres típus");
		data.put("errorIngredientsListEmpty", "Üres alapanyagok listaja");
		data.put("errorIngredientsEmpty", "Üres alapanyag");
		data.put("errorNetConnection", "Internet csatlakozási hiba");
		data.put("errorUnknown", "Ismeretlen hiba");

		data.put("toolbarAdd", "Hozzáadás");
		data.put("toolbarEdit", "Modosítás");
		data.put("toolbarDelete", "Törlés");

		data.put("FileChooserSaveDialogTitleText", "Mentés");
		data.put("FileChooserOpenDialogTitleText", "Nyítás");
		data.put("FileChooserSaveButtonToolTipText", "Mentés");
		data.put("FileChooserSaveButtonToolTipText", "Kiválasztótt fájl mentése");
		data.put("FileChooserOpenButtonText", "Nyítás");
		data.put("FileChooserOpenButtonToolTipText", "Kiválasztótt fájl nyítása");
		data.put("FileChooserCancelButtonText", "Törlés");
		data.put("FileChooserCancelButtonToolTipText", "Kiválasztótt fájl törlése");
		data.put("FileChooserFileNameLabelText", "Fájl neve:");
		data.put("FileChooserFilesOfTypeLabelText", "Fájl típusa:");
		data.put("FileChooserLookInLabelText", "Könyvtár:");
		data.put("FileChooserSaveInLabelText", "Mentés könyvtárba:");
		data.put("FileChooserFolderNameLabelText", "Elérési út:");
		data.put("FileChooserUpFolderToolTipText", "Egy szinttel fel felé");
		data.put("FileChooserNewFolderToolTipText", "Új könyvtár");
		data.put("FileChooserHomeFolderToolTipText", "Fő könyvtár");
		data.put("FileChooserListViewButtonToolTipText", "Lista nézet");
		data.put("FileChooserDetailsViewButtonToolTipText", "Részletek");
		data.put("FileChooserFileNameHeaderText", "Név");
		data.put("FileChooserFileSizeHeaderText", "Méret ");
		data.put("FileChooserFileTypeHeaderText", "Típus");
		data.put("FileChooserFileDateHeaderText", "Dátum");
		data.put("FileChooserFileAttrHeaderText", "Attributumok");
		data.put("FileChooserAcceptAllFilesFilterText", "Összes fájl");

		data.put("dialogAboutTitle", "Programról");
		data.put("aboutProgramm", "Programról");

	}
}
