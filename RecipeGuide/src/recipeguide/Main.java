package recipeguide;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import recipeguide.model.Entity;
import recipeguide.model.entities.Ingredient;
import recipeguide.settings.Settings;
import recipeguide.settings.Text;

public class Main {

	public static void main(String[] args) {
		Entity e = new Ingredient("krumpli", null);
		Ingredient i = new Ingredient("répa", null);
		System.out.println(e.getClass());
		System.out.println(i.getClass());
		List<Ingredient>l=new ArrayList<>();
		l.add((Ingredient)e);
		i=(Ingredient)e;

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
