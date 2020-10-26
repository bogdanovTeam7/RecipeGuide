package recipeguide.gui.handler;

import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import recipeguide.gui.MainFileChooser;
import recipeguide.gui.MainFrame;
import recipeguide.gui.dialog.ConfirmDialog;
import recipeguide.gui.dialog.ErrorDialog;
import recipeguide.saveload.SaveData;
import recipeguide.settings.HandlerCode;
import recipeguide.settings.Settings;

public class MenuFileHandler extends Handler {

	private MainFileChooser fileChooser;

	public MenuFileHandler(MainFrame frame) {
		super(frame);
		fileChooser = new MainFileChooser(frame);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case HandlerCode.MENU_FILE_NEW:
			createNewFile();
			break;
		case HandlerCode.MENU_FILE_OPEN:
			loadFromSelectedFile();
			break;
		case HandlerCode.MENU_FILE_EXIT:
			exit();
			break;
		case HandlerCode.MENU_FILE_SAVE:
			save();
			break;
		}
	}

	public void save() {
		if (Settings.getFileSave() == null) {
			int value = fileChooser.save();
			if (value == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				String path = getRequiredPath(selectedFile.getAbsolutePath());
				Settings.saveFileSaveToIniFile(new File(path));
			}

		}
		if (Settings.getFileSave() != null) {
			SaveData.getInstance()
					.save();
		}
	}

	private String getRequiredPath(String path) {
		String ext = path.substring(path.indexOf(".") + 1);
		String requiredPath = path;
		if (!Settings.SAVE_FILE_EXT.equals(ext)) {
			requiredPath += Settings.SAVE_FILE_EXT;
		}
		return requiredPath;
	}

	public void exit() {
		if (SaveData.getInstance()
				.isSaved()) {
			System.exit(0);
		} else {
			int value = ConfirmDialog.show(frame, "confirmExitIntention", "confirmationOfIntent");
			if (value == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}

	public void loadFromSelectedFile() {
		int value = fileChooser.open();
		if (value == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			if (isCorrectFileExtension(selectedFile)) {
				Settings.saveFileSaveToIniFile(selectedFile);
				SaveData.getInstance()
						.clearAll();
				SaveData.getInstance()
						.load();
				frame.refresh();
			} else {
				ErrorDialog.show(frame, "errorFileFormat");
			}
		}
	}

	public void createNewFile() {
		Settings.setFileSave(null);
		SaveData.getInstance()
				.clearAll();
		frame.refresh();
	}

	private boolean isCorrectFileExtension(File selectedFile) {
		if (selectedFile == null) {
			return false;
		}
		String path = selectedFile.getAbsolutePath();
		String ext = path.substring(path.lastIndexOf(".") + 1);
		return Settings.SAVE_FILE_EXT.equals(ext);
	}

}
