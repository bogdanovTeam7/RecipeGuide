package recipeguide.gui.handler;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import recipeguide.exceptions.ModelException;
import recipeguide.gui.MainFrame;
import recipeguide.gui.dialog.AddEditDialog;
import recipeguide.gui.dialog.DialogType;
import recipeguide.gui.dialog.ErrorDialog;
import recipeguide.saveload.SaveData;
import recipeguide.settings.HandlerCode;

public class AddEditDialogHandler extends Handler implements KeyListener, WindowListener {

	private AddEditDialog dialog;

	public AddEditDialogHandler(MainFrame frame, AddEditDialog dialog) {
		super(frame);
		this.dialog = dialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		action(actionCommand);

	}

	private void action(String actionCommand) {
		try {
			switch (actionCommand) {
			case HandlerCode.ADD:
				SaveData.getInstance()
						.add(dialog.getEntityFromForm());
				dialog.close();
				break;
			case HandlerCode.CREATE:
				SaveData.getInstance()
				.add(dialog.getEntityFromForm());
				dialog.close();
				break;
			case HandlerCode.EDIT:
				SaveData.getInstance()
						.edit(dialog.getEntity(), dialog.getEntityFromForm());
				dialog.close();
				break;
			case HandlerCode.CANCEL:
				dialog.close();
				break;
			}
			frame.refresh();
		} catch (ModelException exception) {
			ErrorDialog.show(frame, exception.getMessage());
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			DialogType dialogType = dialog.getDialogType();
			switch (dialogType) {
			case ADD:
				action(HandlerCode.ADD);
				break;
			case EDIT:
				action(HandlerCode.EDIT);
				break;
			}
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		dialog.close();
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
