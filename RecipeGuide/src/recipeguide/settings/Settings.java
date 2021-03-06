package recipeguide.settings;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.prefs.Preferences;

import org.ini4j.Ini;
import org.ini4j.IniPreferences;
import org.ini4j.Wini;

import recipeguide.model.entities.Entity;
import recipeguide.model.entities.FoodCategory;
import recipeguide.model.entities.Ingredient;
import recipeguide.model.entities.IngredientType;
import recipeguide.model.entities.MeasuryUnit;

public final class Settings {

	public static final MeasuryUnit MEASURY_UNIT_DEFAULT = new MeasuryUnit("piece", "pc");
	public static final List<MeasuryUnit> BASIC_UNITS = List.of(new MeasuryUnit("piece", "pc"),
			new MeasuryUnit("liter", "l"), new MeasuryUnit("deciliter", "dl"), new MeasuryUnit("milliliter", "ml"),
			new MeasuryUnit("kilogram", "kg"), new MeasuryUnit("decagram", "dcg"), new MeasuryUnit("gram", "g"),
			new MeasuryUnit("tablespoon", "tbs"), new MeasuryUnit("teaspoon", "tsp"),
			new MeasuryUnit("coffee spoon", "cfs"), new MeasuryUnit("cup", "c"), new MeasuryUnit("drop", "dr"));
	public static final IngredientType INGREDIENT_TYPE_DEFAULT = new IngredientType("other");
	public static final FoodCategory FOOD_CATEGORY_DEFAULT = new FoodCategory("common");
	public static final Ingredient INGREDIENT_DEFAULT = new Ingredient("no ingredient", new IngredientType("no type"));

	public static final List<Entity> ENTITIES_DEFAULT = new ArrayList<>();

	public static final String FONT_DIR = "fonts/";
	public static final String FONT_NAME = "Kurale";
	public static final String FONT_FILE_NAME = Text.get(FONT_NAME);
	public static final String FONT_EXT = "ttf";
	public static final File FONT_FILE = new File(FONT_DIR + FONT_FILE_NAME + "." + FONT_EXT);
	public static final File FONT_KURALE = new File("fonts/kurale.ttf");
	public static final File FONT_NEXA_SCRIPT_LIGHT = new File("fonts/nexaScriptLight.ttf");
	public static final File FONT_VINQUE_RG_REGULAR = new File("fonts/vinqueRg.ttf");

	public static final String FORMAT_DOUBLE = "%.2f";
	public static final String FORMAT_DATE = "yyyy.MM.dd";

	public static final File SAVE_DIR = new File("saves/");
	public static final String SAVE_FILE_EXT = "book";

	private static final File FILE_SETTINGS = new File("saves/settings.ini");
	public static final File DEFAUL_FILE_SAVE = new File("saves/default.book");
	private static File fileSave = DEFAUL_FILE_SAVE;

	public static final File ABOUT_FILE = new File("res/aboutProgram.html");

	public static File getFileSave() {
		return fileSave;
	}

	public static void setFileSave(File fileSave) {
		Settings.fileSave = fileSave;
	}

	public static void saveFileSaveToIniFile(File fileSave) {
		Settings.fileSave = fileSave;
		saveToNode();
	}

	private static void saveToNode() {
		try {
			Wini wini = new Wini(FILE_SETTINGS);
			String formattedPath = fileSave.getAbsolutePath()
					.replace("\\", "\\\\");
			wini.put("settings", "fileSave", formattedPath);
			wini.store();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void init() {
		try {
			Ini ini = new Ini(new FileReader(FILE_SETTINGS));
			Preferences preferences = new IniPreferences(ini);
			String path = preferences.node("settings")
					.get("fileSave", null);
			if (path != null) {
				fileSave = new File(path);
			} else {
				saveToNode();
			}
			setLocale();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void setLocale() {
		Locale.setDefault(new Locale("hu"));
	}
}
