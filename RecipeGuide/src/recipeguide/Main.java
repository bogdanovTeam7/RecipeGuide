package recipeguide;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

import recipeguide.gui.MainFrame;
import recipeguide.gui.dialog.IngredientTypeAddEditDialog;
import recipeguide.saveload.SaveData;
import recipeguide.saveload.SaveLoad;
import recipeguide.settings.Settings;
import recipeguide.tests.TestDates;

public class Main {

	public static void main(String[] args) {
		init();
		SaveData saveData = SaveData.getInstance();

		MainFrame frame = new MainFrame();
		frame.setVisible(true);

		System.out.println(saveData);
	}

	private static void init() {
		Settings.init();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, Settings.FONT_FILE));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
