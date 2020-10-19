package recipeguide.gui.dialog;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import recipeguide.exceptions.ModelException;
import recipeguide.gui.MainButton;
import recipeguide.gui.MainFrame;
import recipeguide.model.entities.Entity;
import recipeguide.settings.HandlerCode;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

public abstract class AddEditDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	protected MainFrame frame;
	protected Map<String, JComponent> components = new LinkedHashMap<>();
	protected Map<String, ImageIcon> icons = new LinkedHashMap<>();
	protected Map<String, Object> values = new LinkedHashMap<>();
	protected Entity entity;
	protected Font font = Style.FONT_ADD_EDIT_DIALOG;

	public AddEditDialog(MainFrame frame) {
		super(frame, Text.get("add"), true);
		this.frame = frame;
		setResizable(false);
	}

	abstract void setComponents();

	abstract void setIcons();

	abstract void setValues();

	abstract Entity getEntityFromForm() throws ModelException;

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public void showDialog() {
		setDialog();
		setVisible(true);
	}

	public void close() {
		setVisible(false);
		entity = null;
		components.clear();
		icons.clear();
		values.clear();
		dispose();
	}

	private void setDialog() {
		getContentPane().removeAll();

		setComponents();
		setIcons();
		setValues();
		Image image = Style.ICON_DIALOG_ADD.getImage();
		if (getEntity() != null) {
			setTitle(Text.get("edit"));
			image = Style.ICON_DIALOG_EDIT.getImage();
		}
		setIconImage(image);
		frame.setFont(font);

		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		((JPanel) getContentPane()).setBorder(Style.BORDER_DIALOG);

		for (Map.Entry<String, JComponent> entry : components.entrySet()) {
			String key = entry.getKey();
			JLabel label = new JLabel(Text.get(key));
			label.setIcon(icons.get(key));

			JComponent component = (JComponent) entry.getValue();
			Object item = values.get(key);
			
			if (component instanceof JTextField) {
				((JTextField) component).setText((values.containsKey(key)) ? ("" + item) : "");
				component.setPreferredSize(Style.DIMENSION_DIALOG_TEXT_FIELD);
			
			} else if (component instanceof JComboBox) {
				if (values.containsKey(key)) {
					JComboBox<?> box = (JComboBox<?>) component;
					box.setSelectedItem(item);
					if (!box.getSelectedItem()
							.equals(item)) {
						((JComboBox<?>) component).setSelectedIndex(-1);
					}
				} else {
					((JComboBox<?>) component).setSelectedIndex(-1);
				}
			}

			component.setAlignmentX(JComponent.LEFT_ALIGNMENT);
			component.setFont(font);
			add(label);
			add(Box.createVerticalStrut(Style.PADDING_DIALOG));
			add(component);
			add(Box.createVerticalStrut(Style.PADDING_DIALOG));
		}

		MainButton okButton = MainButton.builder()
				.withTitle(entity == null ? Text.get("add") : Text.get("edit"))
				.withIcon(entity == null ? Style.ICON_BUTTON_ADD : Style.ICON_BUTTON_EDIT)
				.withAction(entity == null ? HandlerCode.ADD : HandlerCode.EDIT)
				.build();

		MainButton cancelButton = MainButton.builder()
				.withTitle(Text.get("cancel"))
				.withIcon(Style.ICON_BUTTON_CANCEL)
				.withAction(HandlerCode.CANCEL)
				.build();

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout());
		buttonPanel.setAlignmentX(JPanel.LEFT_ALIGNMENT);
		buttonPanel.add(okButton, BorderLayout.WEST);
		buttonPanel.add(cancelButton, BorderLayout.EAST);
		buttonPanel.add(Box.createHorizontalStrut(Style.PADDING_DIALOG));
		add(buttonPanel);
		pack();
		setLocationRelativeTo(null);
	}

	protected class MainComboBox extends JComboBox<Object> {

		private static final long serialVersionUID = 1L;

		public MainComboBox() {
			super();
			setRenderer(new DefaultListCellRenderer() {

				private static final long serialVersionUID = 1L;

				@Override
				public Component getListCellRendererComponent(JList<?> list, Object value, int index,
						boolean isSelected, boolean cellHasFocus) {
					Entity entity = (Entity) value;
					DefaultListCellRenderer renderer = (DefaultListCellRenderer) super.getListCellRendererComponent(
							list, value, index, isSelected, cellHasFocus);
					if (entity != null) {
						renderer.setText(entity.getNameToDisplay());
					}
					return renderer;
				}
			});
		}

		public void addItems(List<Entity> items) {
			for (Entity item : items) {
				addItem(item);
			}
		}
	}
}
