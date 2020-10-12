package recipeguide;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

import recipeguide.settings.Settings;
import recipeguide.settings.Text;

public class Main {

	public static void main(String[] args) {

		init();

		System.out.println(Text.get("May"));

	}

	private static void init() {
		Settings.init();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, Settings.FONT_KURALE));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
