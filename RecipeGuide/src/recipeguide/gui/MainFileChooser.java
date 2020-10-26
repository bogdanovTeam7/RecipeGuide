package recipeguide.gui;

import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import recipeguide.settings.Settings;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class MainFileChooser extends JFileChooser {

	private static final long serialVersionUID = 1L;

	private MainFrame frame;

	public MainFileChooser(MainFrame frame) {
		this.frame = frame;
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Program files", Settings.SAVE_FILE_EXT);
		setFileFilter(filter);
		setAcceptAllFileFilterUsed(false);
		setCurrentDirectory(Settings.SAVE_DIR);

		frame.setFont(Style.FONT_MAIN_FILE_CHOOSER);

		setText();

		updateUI();
	}

	private void setText() {

		UIManager.put("FileChooser.saveDialogTitleText", Text.get("FileChooserSaveDialogTitleText"));
		UIManager.put("FileChooser.openDialogTitleText", Text.get("FileChooserOpenDialogTitleText"));
		UIManager.put("FileChooser.saveButtonText", Text.get("FileChooserSaveButtonToolTipText"));
		UIManager.put("FileChooser.saveButtonToolTipText", Text.get("FileChooserSaveButtonToolTipText"));
		UIManager.put("FileChooser.openButtonText", Text.get("FileChooserOpenButtonText"));
		UIManager.put("FileChooser.openButtonToolTipText", Text.get("FileChooserOpenButtonToolTipText"));
		UIManager.put("FileChooser.cancelButtonText", Text.get("FileChooserCancelButtonText"));
		UIManager.put("FileChooser.cancelButtonToolTipText", Text.get("FileChooserCancelButtonToolTipText"));
		UIManager.put("FileChooser.fileNameLabelText", Text.get("FileChooserFileNameLabelText"));
		UIManager.put("FileChooser.filesOfTypeLabelText", Text.get("FileChooserFilesOfTypeLabelText"));
		UIManager.put("FileChooser.lookInLabelText", Text.get("FileChooserLookInLabelText"));
		UIManager.put("FileChooser.saveInLabelText", Text.get("FileChooserSaveInLabelText"));
		UIManager.put("FileChooser.folderNameLabelText", Text.get("FileChooserFolderNameLabelText"));
		UIManager.put("FileChooser.upFolderToolTipText", Text.get("FileChooserUpFolderToolTipText"));
		UIManager.put("FileChooser.newFolderToolTipText", Text.get("FileChooserNewFolderToolTipText"));
		UIManager.put("FileChooser.homeFolderToolTipText", Text.get("FileChooserHomeFolderToolTipText"));
		UIManager.put("FileChooser.listViewButtonToolTipText", Text.get("FileChooserListViewButtonToolTipText"));
		UIManager.put("FileChooser.detailsViewButtonToolTipText", Text.get("FileChooserDetailsViewButtonToolTipText"));
		UIManager.put("FileChooser.fileNameHeaderText", Text.get("FileChooserFileNameHeaderText"));
		UIManager.put("FileChooser.fileSizeHeaderText", Text.get("FileChooserFileSizeHeaderText"));
		UIManager.put("FileChooser.fileTypeHeaderText", Text.get("FileChooserFileTypeHeaderText"));
		UIManager.put("FileChooser.fileDateHeaderText", Text.get("FileChooserFileDateHeaderText"));
		UIManager.put("FileChooser.fileAttrHeaderText", Text.get("FileChooserFileAttrHeaderText"));
		UIManager.put("FileChooser.acceptAllFilesFilterText", Text.get("FileChooserAcceptAllFilesFilterText"));

		// TODO Auto-generated method stub

	}

	public int open() {
		return super.showOpenDialog(frame);
	}

	public int save() {
		return super.showSaveDialog(frame);
	}

}
