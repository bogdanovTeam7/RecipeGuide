package recipeguide.settings;

import java.time.Duration;

public final class Format {

	public static double getFromString(String number) throws NumberFormatException {
		number = number.replaceAll(",", ".");
		return Double.parseDouble(number);
	}

	public static String measury(double number) {
		return String.format(Settings.FORMAT_DOUBLE, number);
	}

	public static String getTime(long time) {
		Duration duration = Duration.ofSeconds(time);
		if (duration.toHours() == 0) {
			if (duration.toSecondsPart() == 0) {
				return String.format("%d %s", duration.toMinutesPart(), Text.get("min"));
			}
			return String.format("%d %s : %02d %s", duration.toMinutesPart(), Text.get("min"), duration.toSecondsPart(),
					Text.get("sec"));
		} else if (duration.toSecondsPart() == 0) {
			return String.format("%d %s : %02d %s", duration.toHours(), Text.get("h"), duration.toMinutesPart(),
					Text.get("min"));
		}
		return String.format("%d %s : %02d %s : %02d %s", duration.toHours(), Text.get("h"), duration.toMinutesPart(),
				Text.get("min"), duration.toSecondsPart(), Text.get("sec"));
	}

}
