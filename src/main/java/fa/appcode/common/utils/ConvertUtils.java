package fa.appcode.common.utils;

import fa.appcode.common.logging.LogUtils;

import java.time.LocalDate;

public class ConvertUtils {

	public static LocalDate convertStrToDate(String dateOfBirth) {
		LocalDate date = null;
		try {
			 date = LocalDate.parse(dateOfBirth);

		} catch (Exception e) {
			LogUtils.getLogger().info(e.getMessage());
		}
		return date;
	}

	public static Integer convertStrToInt(String number) {
		Integer numberResult = null;
		try {
			 numberResult = Integer.parseInt(number);

		} catch (Exception e) {
			LogUtils.getLogger().info(e.getMessage());
		}
		return numberResult;
	}
}
