package recipeguide.saveload;

public class AdaptedBook {

	private String name;
	private String author;
	private String startedAtString;
	private String lastEditedAtString;

	public AdaptedBook() {
	}

	public AdaptedBook(String name, String author, String startedAtString, String lastEditedAtString) {
		this.name = name;
		this.author = author;
		this.startedAtString = startedAtString;
		this.lastEditedAtString = lastEditedAtString;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getStartedAtString() {
		return startedAtString;
	}

	public void setStartedAtString(String startedAtString) {
		this.startedAtString = startedAtString;
	}

	public String getLastEditedAtString() {
		return lastEditedAtString;
	}

	public void setLastEditedAtString(String lastEditedAtString) {
		this.lastEditedAtString = lastEditedAtString;
	}
}
