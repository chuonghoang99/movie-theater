package fa.appcode.services.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import fa.appcode.common.logging.LogUtils;
import fa.appcode.common.utils.Constants;
import fa.appcode.exceptions.CinemaRoomException;
import fa.appcode.repositories.CinemaRoomRepository;
import fa.appcode.services.CinemaRoomService;
import fa.appcode.web.entities.CinemaRoom;
import fa.appcode.web.entities.ScheduleSeat;


/**
 * The Class CinemaRoomServiceImpl.
 */
@Service("cinemaRoomService")
public class CinemaRoomServiceImpl implements CinemaRoomService{

	@Autowired
	private CinemaRoomRepository cinemaRoomRepository;

	/**
	 * Find all.
	 *
	 * @param pageIndex the page index
	 * @param pageSize the page size
	 * @return the page
	 */
	@Override
	public Page<CinemaRoom> findAll(int pageIndex, int pageSize) {
		Pageable pageable = PageRequest.of(pageIndex - 1, pageSize);
		Page<CinemaRoom> rs = cinemaRoomRepository.findAll(pageable);
		LogUtils.getLogger().info("CinemaRoom list found size: " + rs.toList().size());
		return rs;
	}

	/**
	 * Find all by search key.
	 *
	 * @param roomName the room name
	 * @param pageIndex the page index
	 * @param pageSize the page size
	 * @return the page
	 * @throws Exception the exception
	 */
	@Override
	public Page<CinemaRoom> findAllBySearchKey(String roomName, int pageIndex, int pageSize) throws Exception {
		LogUtils.getLogger().info("Room name search key: " + roomName);
		if (roomName == null || roomName.isEmpty()) {
			return null;
		}
		Sort sort = Sort.by("cinemaRoomName");
		Pageable pageable = PageRequest.of(pageIndex - 1, pageSize, sort);
		Page<CinemaRoom> rs = cinemaRoomRepository.findAllByCinemaRoomNameContaining(roomName, pageable);
		LogUtils.getLogger().info("Room list found size: " + rs.toList().size());
		return rs;
	}

	/**
	 * Find by id.
	 *
	 * @param roomId the room id
	 * @return the cinema room
	 */

	@Override
	public CinemaRoom findById(String roomId) {
		int roomIdVal = Integer.parseInt(roomId);
		return cinemaRoomRepository.findById(roomIdVal).orElse(null);
	}

	/**
	 * Find room by movie id.
	 *
	 * @param movieId the movie id
	 * @return the cinema room
	 */
	@Override
	public CinemaRoom findByMovieId(String movieId) {
		if (movieId == null || Constants.DEFAULT_WORD.equals(movieId)) {
			return null;
		}
		return cinemaRoomRepository.findRoomByMovieId(movieId);
	}

	/**
	 * Seat solds hanlder: handler seat already sold in room by seat id.
	 *
	 * @param cinemaRoom the cinema room
	 * @param scheduleSeats the list scheduleseat
	 * @return the cinema room
	 */
	@Override
	public CinemaRoom seatSoldsHanlder(CinemaRoom cinemaRoom, List<ScheduleSeat> scheduleSeats) {
		if (cinemaRoom == null) {
			return null;
		}

		if (scheduleSeats != null && !scheduleSeats.isEmpty()) {
			cinemaRoom.getSeats().forEach(s -> {
				scheduleSeats.forEach(sc -> {
					if (sc.getSeatId() == s.getSeatId()) {
						s.setStatus(Constants.IS_SOLD);
					}
				});
			});
		}
		return cinemaRoom;
	}

  @Override
  public List<CinemaRoom> findAll() {
    return cinemaRoomRepository.findAll();
  }

  @Override
  public CinemaRoom saveCinemaRoom(CinemaRoom cinemaRoom) throws CinemaRoomException {
	  if (cinemaRoom == null) {
		  return null;
	  }

	  return cinemaRoomRepository.save(cinemaRoom);
  }

  // Check if a CinemaRoom existed in database by roomName
  @Override
  public boolean checkExistedRoomName(String roomName) {
	  CinemaRoom findingRoom = cinemaRoomRepository.findRoomByCinemaRoomName(roomName);
	  if (findingRoom == null) {
		  return false;
	  } else {
		  return true;
	  }
  }

}
