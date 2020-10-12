package recipeguide.settings;

public final class Format {

	public static double getFromString(String number) throws NumberFormatException {
		number = number.replaceAll(",", ".");
		return Double.parseDouble(number);
	}

	public static String measury(double number) {
		return String.format(Settings.FORMAT_DOUBLE, number);
	}

}
