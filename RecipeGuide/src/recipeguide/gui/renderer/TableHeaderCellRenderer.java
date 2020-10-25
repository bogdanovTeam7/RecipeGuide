package recipeguide.gui.renderer;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class TableHeaderCellRenderer extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;

	private JLabel label;

	public TableHeaderCellRenderer(ImageIcon icon) {
		label = new JLabel(icon);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		TableCellRenderer defaultRenderer = table.getTableHeader()
				.getDefaultRenderer();
		Component component = defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
				column);
		label.setFont(component.getFont());
		label.setForeground(component.getForeground());
		label.setBorder(((JComponent) component).getBorder());
		label.setText((String) value);
		return label;
	}

}
