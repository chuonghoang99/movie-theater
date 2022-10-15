package fa.appcode.services.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.appcode.repositories.ShowDatesRepository;
import fa.appcode.services.ShowDatesService;
import fa.appcode.web.entities.ShowDates;
@Service
@Transactional
public class ShowDatesServiceImpl implements ShowDatesService {
	@Autowired
	ShowDatesRepository showDatesRepository;
	@Override
	public List<ShowDates> findByFromDateAndToDate(Date fromDate, Date toDate) {
		return showDatesRepository.findByFromDateAndToDate(fromDate, toDate);
	}
	
}
