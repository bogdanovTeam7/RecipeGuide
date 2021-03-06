package recipeguide.gui.table;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import recipeguide.gui.MainFrame;
import recipeguide.gui.Refresh;
import recipeguide.gui.handler.EditorHandler;
import recipeguide.gui.renderer.TableCellRenderer;
import recipeguide.gui.renderer.TableHeaderCellRenderer;
import recipeguide.gui.table.model.MainTableModel;
import recipeguide.settings.Style;

abstract public class TableDate<E> extends JTable implements Refresh {

	private static final long serialVersionUID = 1L;

	protected Map<String, ImageIcon> columns;
	protected MainTableModel<E> model;

	public TableDate(MainFrame frame, Map<String, ImageIcon> columns, MainTableModel<E> model) {
		model.setColumns(new ArrayList<>(columns.keySet()));
		this.model = model;
		super.setModel(model);
		this.columns = columns;

		setFont(Style.FONT_TABLE);
		getTableHeader().setFont(Style.FONT_TABLE_HEADER);
		setRowHeight(getRowHeight() + Style.PADDING_TABLE_ROW_ADD);
		setAutoCreateRowSorter(true);
		setPreferredScrollableViewportSize(Style.DIMENSION_RIGHT_PANEL);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		EditorHandler handler = new EditorHandler(frame);
		addMouseListener(handler);
		addKeyListener(handler);

		setHeaderRenderer();

		setDefaultRenderer(String.class, new TableCellRenderer());
		setDefaultRenderer(Number.class, new TableCellRenderer());

//		setToolTipRenderer();
	}

//	protected void setToolTipRenderer() {
//		
//	}

	private void setHeaderRenderer() {
		for (Map.Entry<String, ImageIcon> entry : columns.entrySet()) {
			getColumn(entry.getKey()).setHeaderRenderer(new TableHeaderCellRenderer(entry.getValue()));
		}
	}

	public MainTableModel<E> getModel() {
		return model;
	}

	@Override
	public void refresh() {
		int selectedRow = getSelectedRow();
		E temp = model.getValueAtIndex(selectedRow);
		model.refresh();
		if (temp != null && model.contains(temp)) {
			setRowSelectionInterval(model.getIndexOf(temp), model.getIndexOf(temp));
		}
		setHeaderRenderer();

	}

}
