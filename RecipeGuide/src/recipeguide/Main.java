package recipeguide;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import recipeguide.entities.Ingredient;
import recipeguide.entities.IngredientType;
import recipeguide.exceptions.ModalException;
import recipeguide.settings.Text;

public class Main {

	public static void main(String[] args) {
		init();

		System.out.println(Text.get("May"));

		Ingredient in;
		try {
			in = new Ingredient(IngredientType.EGGS, "");
			System.out.println(in.getDescription());
			System.out.println(in);
		} catch (ModalException e) {
			System.out.println(e.getMassege());
		}

	}

	private static void init() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts//Kurale.ttf")));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
