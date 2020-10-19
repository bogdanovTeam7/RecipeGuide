package recipeguide.gui.dialog;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import recipeguide.gui.MainFrame;
import recipeguide.settings.Settings;
import recipeguide.settings.Style;
import recipeguide.settings.Text;

public class AboutDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	public AboutDialog() {
		init();
		setTitle(Text.get("dialogAboutTitle"));
		setIconImage(Style.ICON_DIALOG_ABOUT.getImage());
		setResizable(true);

	}

	private void init() {
		String about = null;
		try {
			about = getAbout(Settings.ABOUT_FILE);
		} catch (IOException e) {
			System.out.println("No about file");
			e.printStackTrace();
		} finally {
			about = about.replace("style=\"", "style=\"font-family: '" + Settings.FONT_NAME + "';");
			JEditorPane pane = new JEditorPane("text/html", about == null ? Text.get("aboutProgramm") : about);
			pane.setEditable(false);
			pane.setOpaque(false);
			add(pane);
			JScrollPane scrollPane = new JScrollPane();
			getContentPane().add(scrollPane, BorderLayout.CENTER);
			scrollPane.setViewportView(pane);
			pack();
			setLocationRelativeTo(null);

			pane.addHyperlinkListener(new HyperlinkListener() {

				@Override
				public void hyperlinkUpdate(HyperlinkEvent e) {

					if (HyperlinkEvent.EventType.ACTIVATED.equals(e.getEventType())) {
						try {
							Desktop.getDesktop()
									.browse(e.getURL()
											.toURI());
						} catch (IOException | URISyntaxException e1) {
							ErrorDialog.show(new MainFrame(), Text.get("errorNetConnection"));
							e1.printStackTrace();
						}
					}
				}
			});

		}
	}

	private String getAbout(File aboutFile) throws IOException {
		StringBuilder text = new StringBuilder();
		BufferedReader reader = new BufferedReader(new FileReader(aboutFile));
		String line = reader.readLine();
		while (line != null) {
			text.append(line);
			line = reader.readLine();
		}
		reader.close();
		return text.toString();
	}

}
