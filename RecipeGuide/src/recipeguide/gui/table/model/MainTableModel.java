package recipeguide.gui.table.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import recipeguide.gui.Refresh;
import recipeguide.model.entities.Entity;

public abstract class MainTableModel<E> extends AbstractTableModel implements Refresh {

	private static final long serialVersionUID = 1L;

	protected List<E> datas;
	protected List<String> columns = new ArrayList<>();

	public MainTableModel(List<E> datas) {
		this.datas = datas;
	}

	public void setColumns(List<String> columns) {
		this.columns = columns;
	}

	public List<String> getColumns() {
		return columns;
	}

	@Override
	public int getRowCount() {
		return datas.size();
	}

	@Override
	public int getColumnCount() {
		return columns.size();
	}

	@Override
	public String getColumnName(int column) {
		return columns.get(column);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		Object obj = getValueAt(0, columnIndex);
		if (obj == null) {
			return Object.class;
		} else {
			return obj.getClass();
		}
	}

	@Override
	public void refresh() {
		updateData();
		fireTableStructureChanged();
		fireTableDataChanged();
	}

	abstract protected void updateData();

	public E getValueAtIndex(int index) {
		if (index < 0 || index >= datas.size()) {
			return null;
		}
		return datas.get(index);
	}

	public boolean contains(E element) {
		return datas.contains(element);
	}

	public int getIndexOf(E element) {
		return datas.indexOf(element);
	}

}
