package recipeguide.gui.panel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import recipeguide.gui.EnableElement;
import recipeguide.gui.MainFrame;
import recipeguide.gui.Refresh;
import recipeguide.gui.table.TableDate;
import recipeguide.gui.toolbar.button.ButtonType;
import recipeguide.settings.Style;

abstract public class RightPanel extends AbstractPanel implements Refresh {

	private static final long serialVersionUID = 1L;

	protected TableDate<?> tableData;
	private String title;
	private ImageIcon icon;
	protected List<JPanel> panels;

	public RightPanel(MainFrame frame, TableDate<?> tableData, String title, ImageIcon icon, List<JPanel> panels) {
		super(frame);
		this.tableData = tableData;
		this.title = title;
		this.icon = icon;
		this.panels = panels;

		init();
	}

	public RightPanel(MainFrame frame, TableDate<?> tableData, String title, ImageIcon icon) {
		super(frame);
		this.tableData = tableData;
		this.title = title;
		this.icon = icon;
		panels = new ArrayList<>();
		init();
	}

	public RightPanel(MainFrame frame, String title, ImageIcon icon, List<JPanel> panels) {
		super(frame);
		this.tableData = null;
		this.title = title;
		this.icon = icon;
		this.panels = panels;
		init();
	}

	private void checkEnableElements() {
		setEnableElements(frame.getEnableTypes());
		if (tableData != null) {
			if (tableData.getSelectedRow() != -1) {
				List<ButtonType> of = List.of(ButtonType.ADD, ButtonType.EDIT, ButtonType.DELETE);
				frame.setEnableTypes(of);
				setEnableElements(frame.getEnableTypes());
			}

		}
	}

	public void setEnableElements(List<ButtonType> types) {
		for (JPanel jPanel : panels) {
			if (jPanel instanceof EnableElement) {
				((EnableElement) jPanel).setEnableElement(types);
			}
		}
		frame.getMenu()
				.setEnableElement(types);
	}

	@Override
	public void refresh() {
		super.refresh();
		if (tableData != null) {
			tableData.refresh();
		}
		for (JPanel jPanel : panels) {
			if (jPanel instanceof Refresh) {
				((Refresh) jPanel).refresh();
			}
		}
	}

	@Override
	protected void init() {
		setEnableTypesInFrame();
		checkEnableElements();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(Style.BORDER_PANEL);

		JLabel header = new JLabel(title);
		header.setFont(Style.FONT_RIGHT_PANEL_TITLE);
		header.setIcon(icon);
		header.setAlignmentX(CENTER_ALIGNMENT);
		add(header);

		add(Box.createVerticalStrut(Style.PADDING_RIGHT_PANEL));

		for (JPanel jPanel : panels) {
			add(jPanel);
			add(Box.createVerticalStrut(Style.PADDING_RIGHT_PANEL));
		}

		if (tableData != null) {
			JScrollPane scrollPane = new JScrollPane(tableData);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			ListSelectionModel selectionModel = tableData.getSelectionModel();
			selectionModel.addListSelectionListener(new ListSelectionListener() {

				@Override
				public void valueChanged(ListSelectionEvent e) {
					checkEnableElements();
				}
			});

			add(scrollPane);
		}

	}

	private void setEnableTypesInFrame() {
		for (JPanel jPanel : panels) {
			if (jPanel instanceof EnableElement) {
				frame.setEnableTypes(((EnableElement) jPanel).getEnableTypes());
			}
		}
	}
	protected void setEnableTypesInToolBar(List<ButtonType> enableTypes) {
		for (JPanel jPanel : panels) {
			if (jPanel instanceof EnableElement) {
				frame.setEnableTypes(((EnableElement) jPanel).getEnableTypes());
			}
		}
	}

}
