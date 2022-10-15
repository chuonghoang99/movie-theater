package fa.appcode.services;

import org.springframework.data.domain.Page;

import fa.appcode.web.entities.Promotion;

/**
 * @author TruongNguyen
 */

public interface PromotionService {

	/**
	 * Method search all promotions by search data and paging
	 *
	 * @param searchData
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	Page<Promotion> searchAll(String searchData, Integer pageIndex, Integer pageSize);

	/**
	 * Method save or update a promotion
	 *
	 * @param promotion
	 * @return
	 */
	boolean saveOrUpdate(Promotion promotion);

	/**
	 * Method get a promotion by promotion id
	 *
	 * @param promotionId
	 * @return
	 */
	Promotion getById(Integer promotionId);

	/**
	 * Method delete a promotion by promotion id
	 *
	 * @param promotionId
	 * @return
	 */
	boolean deletePromotionById(Integer promotionId);

	/**
	 * Method check title exist
	 *
	 * @param title
	 * @return
	 */
	boolean checkTitleExist(Integer promotionId, String title);
}
