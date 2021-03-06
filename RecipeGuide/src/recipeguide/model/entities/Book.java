package recipeguide.model.entities;

import java.util.Date;
import java.util.Objects;

import recipeguide.settings.Format;

public class Book extends AbstractEntity {

	private String author = "";
	private Date startedAt = new Date();
	private Date lastEditedAt = new Date();

	public Book() {
	}

	public Book(String name, String author, Date startedAt, Date lastEditedAt) {
		super.name = name;
		this.author = author;
		this.startedAt = startedAt;
		this.lastEditedAt = lastEditedAt;
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

	public Date getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(Date startedAt) {
		this.startedAt = startedAt;
	}

	public Date getLastEditedAt() {
		return lastEditedAt;
	}

	public void setLastEditedAt(Date lastEditedAt) {
		this.lastEditedAt = lastEditedAt;
	}

	public String getFormattedStartedAt() {
		return Format.getFormattedDate(startedAt);
	}

	public String getFormattedLastEditedAt() {
		return Format.getFormattedDate(lastEditedAt);
	}

	@Override
	public int hashCode() {
		return Objects.hash(author) + super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Book)) {
			return false;
		}
		return author.equals(((Book) obj).getAuthor()) && name.equals(((Book) obj).getName());
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [name=");
		builder.append(name);
		builder.append(", author=");
		builder.append(author);
		builder.append(", startedAt=");
		builder.append(startedAt);
		builder.append(", lastEditedAt=");
		builder.append(lastEditedAt);
		builder.append("]");
		return builder.toString();
	}

}
