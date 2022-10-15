package fa.appcode.common.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {
	public static Date convertToDate(LocalDate date) {	
		return Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
}
