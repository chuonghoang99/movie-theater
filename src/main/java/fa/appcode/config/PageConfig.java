package fa.appcode.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@PropertySource("classpath:messages.properties")
@PropertySource("classpath:webConfig.properties")
@Getter
public class PageConfig {

  @Value("${page.init}")
  private Integer initPage;

  @Value("${page.size}")
  private Integer sizePage;

  @Value("${page.showtimes.size}")
  private Integer maxPageShowTime;

  @Value("${login.fail.no.author}")
  private String noAuthor;

  @Value("${login.fail.no.permit}")
  private String noPermit;

  @Value("${login.fail.locked}")
  private String locked;

  @Value("${login.fail.incorrect}")
  private String incorrect;

  @Value("${invoice.score.add}")
  private Double scoreAdd;
  @Value("${save.success}")
  private String saveSuccess;
  @Value("${save.fail}")
  private String saveFail;

  @Value("${movie.type.empty}")
  private String emtyType;

  @Value("${movie.schedule.empty}")
  private String scheduleEmpty;

  @Value("${movie.toDate.notCorrect}")
  private String dateNotCorrect;
  
  @Value("${movie.delete.success}")
  private String deleteMovieSuccess;
  
  @Value("${movie.delete.fail}")
  private String deleteMovieFail;
 
  @Value("${room.image.upload.path}")
	private String roomImageUploadPath;

	@Value("${room.image.load.path}")
	private String roomImageLoadPath;

	@Value("${room.add.ok}")
	private String addRoomOk;

	@Value("${room.add.notok}")
	private String addRoomNotOk;

	@Value("${room.existed.name}")
	private String roomNameExisted;

	@Value("${room.id.invalid}")
	private String roomIdNotValid;

	@Value("${seat.normal.price}")
	private String normalSeatPrice;

	@Value("${seat.vip.price}")
	private String vipSeatPrice;

	@Value("${room.name.blank}")
	private String roomNameBlank;

	@Value("${seat.not.found.size}")
	private Integer zeroSeatFound;

	@Value("${seat.list.update.ok}")
	private String updateListSeatOk;

	@Value("${seat.list.update.notok}")
	private String updateListSeatNotOk;

	@Value("#{'${seat.column.arr}'.split(',')}")
	private List<String> listSeatColumn;

	@Value("#{'${seat.quantity.arr}'.split(',')}")
	private List<Integer> listSeatQuantity;

	@Value("${seat.max.column}")
	private Integer maxSeatColumn;
}
