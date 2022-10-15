package fa.appcode.common.utils;

public class LibraryCustomize {
	
	public static boolean isNumber(String str) {
		return str != null && str.matches(Constants.REGEX_DIGIT);
	}
}
