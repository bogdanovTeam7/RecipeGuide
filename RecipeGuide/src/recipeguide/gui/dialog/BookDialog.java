package recipeguide.gui.dialog;

import javax.swing.JTextField;

import recipeguide.exceptions.ModelException;
import recipeguide.gui.MainFrame;
import recipeguide.model.entities.Book;
import recipeguide.model.entities.Entity;
import recipeguide.settings.Style;

public class BookDialog extends AddEditDialog {

	private static final long serialVersionUID = 1L;
	private Book book;

	public BookDialog(MainFrame frame, DialogType type) {
		super(frame, type);
	}

	public BookDialog(MainFrame frame) {
		super(frame, null);
	}

	@Override
	public void setComponents() {
		components.put("bookName", new JTextField());
		components.put("bookAuthor", new JTextField());
	}

	@Override
	public void setIcons() {
		icons.put("bookName", Style.ICON_DIALOG_BOOK_NAME);
		icons.put("bookAuthor", Style.ICON_DIALOG_BOOK_AUTHOR);
	}

	@Override
	public void setValues() {
		if (dialogType.equals(DialogType.EDIT) && book != null) {
			values.put("bookName", book.getNameToDisplay());
			values.put("bookAuthor", book.getAuthor());
		}
	}

	@Override
	public Entity getEntityFromForm() throws ModelException {
		String name = ((JTextField) components.get("bookName")).getText();
		String author = ((JTextField) components.get("bookAuthor")).getText();
		Book newBook = new Book();
		newBook.setName(name != null ? name : "");
		newBook.setAuthor(author != null ? author : "");
		return newBook;
	}

	@Override
	public void setEntity(Entity entity) {
		super.entity = entity;
		if (entity != null && entity instanceof Book) {
			book = (Book) entity;
		} else {
			book = new Book();
		}
	}

}
