package recipeguide.gui.dialog;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import recipeguide.gui.toolbar.button.ButtonType;
import recipeguide.gui.toolbar.button.MainButton;
import recipeguide.model.entities.Recipe;
import recipeguide.settings.HandlerCode;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class RecipeOverviewDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private Recipe recipe;

	public RecipeOverviewDialog(Recipe recipe) {
		this.recipe = recipe;
		init();
	}

	private void init() {
		setTitle(Text.get("recipeDetails"));
		setIconImage(Style.ICON_DIALOG_RECIPE_DETAILS.getImage());
		setFont(Style.FONT_RECIPE_DETAILS_DIALOG);
		setResizable(true);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		JTextArea description = new JTextArea(recipe.toString());
		description.setBorder(Style.BORDER_DIALOG);
		description.setFont(Style.FONT_RECIPE_DETAILS_DIALOG);
		description.setEditable(false);
		add(description);
		JPanel toolbar = createToolBar();
		add(toolbar);

		pack();
		setLocationRelativeTo(null);

	}

	private JPanel createToolBar() {
		JPanel toolbar = new JPanel();
		toolbar.setLayout(new BoxLayout(toolbar, BoxLayout.X_AXIS));
		toolbar.setFont(Style.FONT_ABOUT_DIALOG);
		toolbar.setBorder(Style.BORDER_DIALOG);
		toolbar.setAlignmentX(CENTER_ALIGNMENT);

		MainButton buttonCancel = MainButton.builder()
				.withAction(HandlerCode.CLOSE)
				.withActionListener(null)
				.withIcon(Style.ICON_BUTTON_CANCEL)
				.withTitle(Text.get("close"))
				.withType(ButtonType.CLOSE)
				.build();

		MainButton buttonSave = MainButton.builder()
				.withAction(HandlerCode.SAVE_TO_EXTERN_FILE)
				.withActionListener(null)
				.withIcon(Style.ICON_BUTTON_SAVE)
				.withTitle(Text.get("saveToExternFile"))
				.withType(ButtonType.SAVE)
				.build();
		toolbar.add(buttonCancel);
		toolbar.add(Box.createHorizontalStrut(Style.PADDING_DIALOG));
		toolbar.add(buttonSave);

		return toolbar;

	}

}
