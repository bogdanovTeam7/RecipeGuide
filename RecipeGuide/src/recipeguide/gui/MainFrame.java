package recipeguide.gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Arrays;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import recipeguide.gui.dialog.AboutDialog;
import recipeguide.gui.dialog.ConfirmDialog;
import recipeguide.gui.dialog.ErrorDialog;
import recipeguide.gui.dialog.FoodCategoryAddEditDialog;
import recipeguide.gui.dialog.IngredientAddEditDialog;
import recipeguide.gui.dialog.IngredientTypeAddEditDialog;
import recipeguide.gui.dialog.MeasuryUnitAddEditDialog;
import recipeguide.gui.menu.MainMenu;
import recipeguide.gui.toolbar.EditorToolbar;
import recipeguide.gui.toolbar.MainToolbar;
import recipeguide.model.entities.FoodCategory;
import recipeguide.model.entities.Ingredient;
import recipeguide.model.entities.IngredientType;
import recipeguide.model.entities.MeasuryUnit;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class MainFrame extends JFrame implements Refresh {

	private static final long serialVersionUID = 1L;

	private GridBagConstraints constraints;
	private MainMenu menubar;
	private MainToolbar mainToolbar;

	public MainFrame() {
		super(Text.get("ProgramName"));

//		IngredientTypeAddEditDialog ingredientTypeAddEditDialog = new IngredientTypeAddEditDialog(this);
//		IngredientType type = new IngredientType("water");
//		ingredientTypeAddEditDialog.setEntity(type);
//		ingredientTypeAddEditDialog.showDialog();

//		MeasuryUnitAddEditDialog measuryUnitAddEditDialog = new MeasuryUnitAddEditDialog(this);
//		MeasuryUnit unit = new MeasuryUnit("tonna", "t");
//		measuryUnitAddEditDialog.setEntity(unit);
//		measuryUnitAddEditDialog.showDialog();

//		FoodCategoryAddEditDialog foodCategoryAddEditDialog = new FoodCategoryAddEditDialog(this);
//		FoodCategory category = new FoodCategory("soup");
//		foodCategoryAddEditDialog.setEntity(category);
//		foodCategoryAddEditDialog.showDialog();

//		IngredientAddEditDialog ingredientAddEditDialog = new IngredientAddEditDialog(this);
//		Ingredient ingredient = new Ingredient("salt", new IngredientType("minerals"));
//		ingredientAddEditDialog.setEntity(ingredient);
//		ingredientAddEditDialog.showDialog();

		setResizable(false);
		setIconImage(Style.ICON_MAIN.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Style.COLOR_MAIN_FRAME);

		menubar = new MainMenu(this);
		setJMenuBar(menubar);

		setLayout(new GridBagLayout());

		constraints = new GridBagConstraints();

		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;

		mainToolbar = new MainToolbar();
		add(mainToolbar, constraints);

		constraints.gridy = 1;
		constraints.gridwidth = 1;
		constraints.anchor = GridBagConstraints.NORTH;

		add(new EditorToolbar(), constraints);

		// TODO leftpanel
		pack();
		setLocationRelativeTo(null);
	}

	public void setFont(Font font) {
		for (Entry<Object, Object> e : UIManager.getDefaults()
				.entrySet()) {
			if (e.getKey()
					.toString()
					.contains("font")) {
				UIManager.put(e.getKey(), font);
			}
		}
	}

	@Override
	public void refresh() {
		SwingUtilities.updateComponentTreeUI(this);
		menubar.refresh();
		pack();

	}

}
