package recipeguide.settings;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

public final class Style {

	public static final Color COLOR_BUTTON_BG_NORMAL = new Color(240, 240, 240);
	public static final Color COLOR_BUTTON_BG_HOVER = Color.YELLOW;

	public static final Font FONT_TOOLBAR_BUTTON = new Font("Kurale", Font.BOLD, 14);
	public static final Font FONT_MENU_BUTTON = new Font("Kurale", Font.BOLD, 14);

	public static final EmptyBorder BORDER_PANEL = new EmptyBorder(10, 10, 10, 10);

	public static final ImageIcon ICON_MAIN = new ImageIcon("images/main.png");
	public static final ImageIcon ICON_TOOLBAR_OVERVIEW = new ImageIcon("images/toolbarOverwiew.png");
	public static final ImageIcon ICON_TOOLBAR_RECIPE = new ImageIcon("images/toolbarRecipe.png");
	public static final ImageIcon ICON_TOOLBAR_INGREDIENT = new ImageIcon("images/toolbarIngredient.png");
}
