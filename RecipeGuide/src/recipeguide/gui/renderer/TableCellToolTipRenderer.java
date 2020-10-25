package recipeguide.gui.renderer;

import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JToolTip;
import javax.swing.table.DefaultTableCellRenderer;

public class TableCellToolTipRenderer extends DefaultTableCellRenderer {

	private static final long serialVersionUID = 1L;

	private JToolTip toolTip;

	public TableCellToolTipRenderer(String text) {
		toolTip = new JToolTip();
		toolTip.setToolTipText(text);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		Component сomponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		toolTip.setComponent((JComponent) сomponent);
		return this;
	}

}
