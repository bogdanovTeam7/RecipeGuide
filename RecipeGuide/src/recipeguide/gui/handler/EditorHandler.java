package recipeguide.gui.handler;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import recipeguide.exceptions.ModelException;
import recipeguide.gui.MainFrame;
import recipeguide.gui.dialog.AddEditDialog;
import recipeguide.gui.dialog.ConfirmDialog;
import recipeguide.gui.dialog.DialogType;
import recipeguide.gui.dialog.ErrorDialog;
import recipeguide.gui.table.TableDate;
import recipeguide.gui.table.model.MainTableModel;
import recipeguide.model.entities.Entity;
import recipeguide.saveload.SaveData;
import recipeguide.settings.HandlerCode;
import recipeguide.settings.Text;

public class EditorHandler extends Handler implements MouseListener, KeyListener {

	protected AddEditDialog dialog;

	public EditorHandler(MainFrame frame) {
		super(frame);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case HandlerCode.ADD:
			add();
			break;
		case HandlerCode.EDIT:
			edit();
			break;
		case HandlerCode.DELETE:
			delete();
			break;
		}
	}

	private void delete() {
		Entity e = getSelectedEntity();
		if (e != null) {
			int result = ConfirmDialog.show(frame, "confirmationOfDelete", "confirmationOfIntent");
			if (result == JOptionPane.YES_OPTION) {
				try {
					SaveData.getInstance()
							.delete(e);
					frame.refresh();
				} catch (ModelException e1) {
					ErrorDialog.show(frame, "errorBasicEntityInvalidToDelete");
					e1.printStackTrace();
				}
			}
		}
	}

	private void edit() {
		Entity e = getSelectedEntity();
		setDialog();
		dialog.setDialogType(DialogType.EDIT);
		dialog.setEntity(e);
		dialog.showDialog();
	}

	private void add() {
		setDialog();
		dialog.setDialogType(DialogType.ADD);
		dialog.setEntity(null);
		dialog.showDialog();
	}

	public Entity getSelectedEntity() {
		return frame.getRightPanel()
				.getSelectedeEtity();
	}

	private void setDialog() {
		dialog = frame.getRightPanel()
				.getDialog();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DELETE) {
			delete();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() instanceof TableDate<?> && e.getClickCount() >= 2 && e.getButton() == e.BUTTON1) {
			edit();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
