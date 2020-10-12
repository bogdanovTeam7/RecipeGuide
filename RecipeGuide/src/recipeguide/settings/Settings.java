package recipeguide.settings;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.prefs.Preferences;

import org.ini4j.Ini;
import org.ini4j.IniPreferences;
import org.ini4j.Wini;

public final class Settings {

	public static final File FONT_KURALE = new File("fonts/Kurale.ttf");
	public static final File SAVE_DIR = new File("saves/");
	public static final String SAVE_FILE_EXT = "userfile";

	public static final String FORMAT_DOUBLE = "%.2f";
	public static final String FORMAT_DATE = "yyyy.MM.dd";

	private static final File FILE_SETTINGS = new File("saves/settings.ini");
	private static File fileSave = new File("saves/default.userfile");

	public static File getFileSave() {
		return fileSave;
	}

	public static void setFileSave(File fileSave) {
		Settings.fileSave = fileSave;
		saveToNode();
	}

	private static void saveToNode() {
		try {
			Wini wini = new Wini(FILE_SETTINGS);
			wini.put("settings", "fileSave", fileSave.getAbsolutePath()
					.replace("\\", "\\\\"));
			wini.store();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void init() {
		try {
			Ini ini = new Ini(FILE_SETTINGS);
			Preferences preferences = new IniPreferences(ini);
			String path = preferences.node("settings")
					.get("fileSave", null);
			if (path != null) {
				fileSave = new File(path);
			}
			setLocale();
		} catch (IOException e) {
			saveToNode();
			e.printStackTrace();
		}
	}

	private static void setLocale() {
		Locale.setDefault(new Locale("hu"));
	}
}
