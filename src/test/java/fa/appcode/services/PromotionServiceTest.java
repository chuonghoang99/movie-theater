package fa.appcode.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import fa.appcode.common.logging.LogUtils;
import fa.appcode.repositories.PromotionRepository;
import fa.appcode.services.impl.PromotionServiceImpl;
import fa.appcode.web.entities.Promotion;

/**
 * @author TruongNguyen
 */
@SpringBootTest
class PromotionServiceTest {

	@Mock
	private PromotionRepository promotionRepository;

	@InjectMocks
	private PromotionServiceImpl promotionService;

	/**
	 * Test search method witch searchData = "", page index 1, page size 5
	 *
	 * @throws ParseException
	 */
	@Test
	void testSearchAll1() throws ParseException {
		final String searchData = "";
		final String searchVal = "%" + searchData + "%";
		final int pageIndex = 1;
		final int pageSize = 5;

		List<Promotion> list = new ArrayList<Promotion>();

		Date date = new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2021");
		list.add(new Promotion(1, "promotion 1", 8888, date, null, date, "p1"));
		list.add(new Promotion(2, "promotion 2", 8888, date, null, date, "p2"));
		list.add(new Promotion(3, "promotion 3", 8888, date, null, date, "p3"));
		list.add(new Promotion(4, "promotion 4", 8888, date, null, date, "p4"));
		list.add(new Promotion(5, "promotion 5", 8888, date, null, date, "p5"));

		Page<Promotion> page = new PageImpl<>(list);

		Pageable pageable = PageRequest.of(pageIndex - 1, pageSize);

		Mockito.when(promotionRepository.searchText(searchVal, pageable)).thenReturn(page);

		Page<Promotion> actual = promotionService.searchAll(searchData, pageIndex, pageSize);

		LogUtils.getLogger().info(page);
		LogUtils.getLogger().info(actual);

		assertEquals(page, actual);
	}

	/**
	 * Test search method witch searchData = "", page index 1, page size 10
	 *
	 * @throws ParseException
	 */
	@Test
	void testSearchAll2() throws ParseException {
		final String searchData = "";
		final String searchVal = "%" + searchData + "%";
		final int pageIndex = 1;
		final int pageSize = 10;

		List<Promotion> list = new ArrayList<Promotion>();

		Date date = new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2021");
		list.add(new Promotion(1, "promotion 1", 8888, date, null, date, "p1"));
		list.add(new Promotion(2, "promotion 2", 8888, date, null, date, "p2"));
		list.add(new Promotion(3, "promotion 3", 8888, date, null, date, "p3"));
		list.add(new Promotion(4, "promotion 4", 8888, date, null, date, "p4"));
		list.add(new Promotion(5, "promotion 5", 8888, date, null, date, "p5"));
		list.add(new Promotion(6, "promotion 6", 8888, date, null, date, "p6"));
		list.add(new Promotion(7, "promotion 7", 8888, date, null, date, "p7"));
		list.add(new Promotion(8, "promotion 8", 8888, date, null, date, "p8"));
		list.add(new Promotion(9, "promotion 9", 8888, date, null, date, "p9"));
		list.add(new Promotion(10, "promotion 10", 8888, date, null, date, "p10"));

		Page<Promotion> page = new PageImpl<>(list);

		Pageable pageable = PageRequest.of(pageIndex - 1, pageSize);

		Mockito.when(promotionRepository.searchText(searchVal, pageable)).thenReturn(page);

		Page<Promotion> actual = promotionService.searchAll(searchData, pageIndex, pageSize);

		LogUtils.getLogger().info(page);
		LogUtils.getLogger().info(actual);

		assertEquals(page, actual);
	}

	/**
	 * Test search method witch searchData = "p", page index 2, page size 5
	 */
	@Test
	void testSearchAll3() {
		final String searchData = "p";
		final String searchVal = "%" + searchData + "%";
		final int pageIndex = 2;
		final int pageSize = 5;

		List<Promotion> list = new ArrayList<Promotion>();

		list.add(new Promotion(1, "promotion 1"));
		list.add(new Promotion(2, "promotion 2"));

		Page<Promotion> page = new PageImpl<>(list);

		Pageable pageable = PageRequest.of(pageIndex - 1, pageSize);

		Mockito.when(promotionRepository.searchText(searchVal, pageable)).thenReturn(page);

		Page<Promotion> actual = promotionService.searchAll(searchData, pageIndex, pageSize);

		LogUtils.getLogger().info(page);
		LogUtils.getLogger().info(actual);

		assertEquals(page, actual);
	}

	/**
	 * Test search method witch searchData = "31/12", page index 1, page size 5
	 *
	 * @throws ParseException
	 */
	@Test
	void testSearchAll4() throws ParseException {
		final String searchData = "31/12";
		final String searchVal = "%" + searchData + "%";
		final int pageIndex = 1;
		final int pageSize = 5;

		List<Promotion> list = new ArrayList<Promotion>();

		Date date = new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2021");
		list.add(new Promotion(1, "promotion 1", 8888, date, null, date, "p1"));
		list.add(new Promotion(2, "promotion 2", 8888, date, null, date, "p2"));
		list.add(new Promotion(3, "promotion 3", 8888, date, null, date, "p3"));
		list.add(new Promotion(4, "promotion 4", 8888, date, null, date, "p4"));
		list.add(new Promotion(5, "promotion 5", 8888, date, null, date, "p5"));

		Page<Promotion> page = new PageImpl<>(list);

		Pageable pageable = PageRequest.of(pageIndex - 1, pageSize);

		Mockito.when(promotionRepository.searchText(searchVal, pageable)).thenReturn(page);

		Page<Promotion> actual = promotionService.searchAll(searchData, pageIndex, pageSize);

		LogUtils.getLogger().info(page);
		LogUtils.getLogger().info(actual);

		assertEquals(page, actual);
	}

	/**
	 * Test search method witch searchData = null, page index 1, page size 5
	 *
	 * @throws ParseException
	 */
	@Test
	void testSearchAll5() throws ParseException {
		final String searchData = null;
		final String searchVal = "%%";
		final int pageIndex = 1;
		final int pageSize = 5;

		List<Promotion> list = new ArrayList<Promotion>();

		Date date = new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2021");
		list.add(new Promotion(1, "promotion 1", 8888, date, null, date, "p1"));
		list.add(new Promotion(2, "promotion 2", 8888, date, null, date, "p2"));
		list.add(new Promotion(3, "promotion 3", 8888, date, null, date, "p3"));
		list.add(new Promotion(4, "promotion 4", 8888, date, null, date, "p4"));
		list.add(new Promotion(5, "promotion 5", 8888, date, null, date, "p5"));

		Page<Promotion> page = new PageImpl<>(list);

		Pageable pageable = PageRequest.of(pageIndex - 1, pageSize);

		Mockito.when(promotionRepository.searchText(searchVal, pageable)).thenReturn(page);

		Page<Promotion> actual = promotionService.searchAll(searchData, pageIndex, pageSize);

		LogUtils.getLogger().info(page);
		LogUtils.getLogger().info(actual);

		assertEquals(page, actual);
	}

	/**
	 * Test search method witch searchData = "31/12/2021", page index 1, page size 5
	 *
	 * @throws ParseException
	 */
	@Test
	void testSearchAll6() throws ParseException {
		final String searchData = "31/12/2021";
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = format.parse(searchData);
		final int pageIndex = 1;
		final int pageSize = 5;

		List<Promotion> list = new ArrayList<Promotion>();

		list.add(new Promotion(1, "promotion 1", 8888, date, null, date, "p1"));
		list.add(new Promotion(2, "promotion 2", 8888, date, null, date, "p2"));
		list.add(new Promotion(3, "promotion 3", 8888, date, null, date, "p3"));
		list.add(new Promotion(4, "promotion 4", 8888, date, null, date, "p4"));
		list.add(new Promotion(5, "promotion 5", 8888, date, null, date, "p5"));

		Page<Promotion> page = new PageImpl<>(list);

		Pageable pageable = PageRequest.of(pageIndex - 1, pageSize);

		Mockito.when(promotionRepository.searchDate(date, pageable)).thenReturn(page);

		Page<Promotion> actual = promotionService.searchAll(searchData, pageIndex, pageSize);

		assertEquals(page, actual);
	}

	/**
	 * Test method saveOrUpdate success
	 */
	@Test
	void testSaveOrUpdate1() throws ParseException {
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2021");
		Promotion promotion = new Promotion(1, "promotion 1", 8888, date, null, date, "p1");
		Mockito.when(promotionRepository.save(promotion)).thenReturn(promotion);
		boolean actual = promotionService.saveOrUpdate(promotion);
		assertTrue(actual);
	}

	/**
	 * Test method saveOrUpdate with promotion null
	 */
	@Test
	void testSaveOrUpdate2() {
		Promotion promotion = null;
		Mockito.when(promotionRepository.save(promotion)).thenThrow(IllegalArgumentException.class);
		boolean actual = promotionService.saveOrUpdate(promotion);
		assertFalse(actual);
	}

	/**
	 * Test method getById with promotion id exist
	 */
	@Test
	void testGetById1() {
		final Integer promotionId = 1;
		Promotion promotion = new Promotion(1, "promotion 1");
		Mockito.when(promotionRepository.getById(promotionId)).thenReturn(promotion);
		Promotion actual = promotionService.getById(promotionId);
		assertEquals(promotion, actual);
	}

	/**
	 * Test method getById with promotion id null
	 */
	@Test
	void testGetById2() {
		Promotion actual = promotionService.getById(null);
		assertEquals(null, actual);
	}

	/**
	 * Test method getById with promotion id doesn't exist
	 */
	@Test
	void testGetById3() {
		final Integer promotionId = 1000;
		Mockito.when(promotionRepository.getById(promotionId)).thenThrow(EntityNotFoundException.class);
		Promotion actual = promotionService.getById(promotionId);
		assertEquals(null, actual);
	}

	/**
	 * Test method deletePromotionById with promotion id exist
	 */
	@Test
	void testDeletePromotionById1() {
		final Integer promotionId = 1;
		Mockito.doNothing().when(promotionRepository).deleteById(promotionId);
		assertTrue(promotionService.deletePromotionById(promotionId));
	}

	/**
	 * Test method deletePromotionById with promotion id doesn't exist
	 */
	@Test
	void testDeletePromotionById2() {
		final Integer promotionId = 100;
		Mockito.doThrow(new EmptyResultDataAccessException(0)).when(promotionRepository).deleteById(promotionId);
		assertFalse(promotionService.deletePromotionById(promotionId));
	}

	/**
	 * Test method deletePromotionById with promotion id null
	 */
	@Test
	void testDeletePromotionById3() {
		Mockito.doThrow(new EmptyResultDataAccessException(0)).when(promotionRepository).deleteById(null);
		assertFalse(promotionService.deletePromotionById(null));
	}

	/**
	 * Test method checkTitleExist with promotionId null and title not exist
	 */
	@Test
	void testCheckTitleExist1() {
		Integer promotionId = null;
		String title = "title";
		Mockito.when(promotionRepository.findByTitle(title)).thenReturn(null);
		assertFalse(promotionService.checkTitleExist(promotionId, title));
	}

	/**
	 * Test method checkTitleExist with promotionId null and title exist
	 */
	@Test
	void testCheckTitleExist2() {
		Integer promotionId = null;
		String title = "title1";
		Promotion promotion = new Promotion(1, title);
		Mockito.when(promotionRepository.findByTitle(title)).thenReturn(promotion);
		assertTrue(promotionService.checkTitleExist(promotionId, title));
	}

	/**
	 * Test method checkTitleExist with promotionId and title not exist
	 */
	@Test
	void testCheckTitleExist3() {
		Integer promotionId = 1;
		String title = "title";
		Mockito.when(promotionRepository.checkByIdAndTitle(promotionId, title)).thenReturn(null);
		assertFalse(promotionService.checkTitleExist(promotionId, title));
	}

	/**
	 * Test method checkTitleExist with promotionId and title exist
	 */
	@Test
	void testCheckTitleExist4() {
		Integer promotionId = 1;
		String title = "title";
		Promotion promotion = new Promotion(2, title);
		Mockito.when(promotionRepository.checkByIdAndTitle(promotionId, title)).thenReturn(promotion);
		assertTrue(promotionService.checkTitleExist(promotionId, title));
	}

	/**
	 * Test method checkTitleExist with promotionId 0 and title not exist
	 */
	@Test
	void testCheckTitleExist5() {
		Integer promotionId = 0;
		String title = "title";
		Mockito.when(promotionRepository.findByTitle(title)).thenReturn(null);
		assertFalse(promotionService.checkTitleExist(promotionId, title));
	}
}
