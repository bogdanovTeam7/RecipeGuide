package recipeguide.exceptions;

public final class CodeScript {

	private final int codeNumber;
	private final String title;

	public CodeScript(int codeNumber, String title) {
		this.codeNumber = codeNumber;
		this.title = title;
	}

	public int getCodeNumber() {
		return codeNumber;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CodeScript [codeNumber=");
		builder.append(codeNumber);
		builder.append(", title=");
		builder.append(title);
		builder.append("]");
		return builder.toString();
	}

}
