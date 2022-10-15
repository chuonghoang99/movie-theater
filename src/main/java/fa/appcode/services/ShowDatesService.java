package fa.appcode.services;

import java.util.Date;
import java.util.List;

import fa.appcode.web.entities.ShowDates;

public interface ShowDatesService {
	List<ShowDates> findByFromDateAndToDate(Date fromDate,Date toDate);
}
