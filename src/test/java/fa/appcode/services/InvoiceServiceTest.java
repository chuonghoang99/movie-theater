package fa.appcode.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import fa.appcode.common.utils.DateUtils;
import fa.appcode.config.PageConfig;
import fa.appcode.repositories.InvoiceRepository;
import fa.appcode.services.impl.InvoiceServiceImpl;
import fa.appcode.web.entities.Account;
import fa.appcode.web.entities.Invoice;
import fa.appcode.web.entities.Member;
import fa.appcode.web.entities.Movie;
import fa.appcode.web.entities.ScheduleSeat;
import fa.appcode.web.entities.Seat;
import fa.appcode.web.entities.Ticket;
import fa.appcode.web.vo.ConfirmTicketVo;

@SpringBootTest
class InvoiceServiceTest {
	
	private static ConfirmTicketVo confirmTicketVo;
	
	private static Member member;
	
	private static Account account;
	
	private static Invoice invoice;
	
	private static List<Ticket> tickets;
	
	private static List<Seat> seats;
	
	private static Movie movie;
	
	@Mock
	private static PageConfig pageConfig;
	
	@Mock
	private static MemberService memberService;
	
	@InjectMocks
	private static InvoiceServiceImpl invoiceService;
	
	@Mock
	private static TicketService ticketService;
	
	@Mock
	private static InvoiceRepository invoiceRepository;
	
	@Mock
	private static SeatService seatService;
	
	@Mock
	private static MovieService movieService;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		movie = new Movie("Movie1", "Actor1", "Movie VN", null);
		
		String[] idSeatSelectings = {"1", "2", "3"};
		confirmTicketVo = new ConfirmTicketVo();
		confirmTicketVo.setDateSelecting("2021-12-20");
		confirmTicketVo.setIdSeatSelecting(idSeatSelectings);
		confirmTicketVo.setMemberId("m123");
		confirmTicketVo.setMovieId("1");
		confirmTicketVo.setScheduleId(1);
		confirmTicketVo.setTimeSelecting("15:00");
		confirmTicketVo.setTotalPrice(30000.0);
		confirmTicketVo.setUseScore(20000.0);
		
		account = new Account();
		account.setAccountId("1");
		
		member = new Member("m123", 35000.0, account);
		
		invoice = new Invoice();
		invoice.setAccount(member.getAccount());
				
		invoice.setBookingDate(DateUtils.convertToDate(LocalDate.now()));
		invoice.setScheduleShow(DateUtils.convertToDate(LocalDate.parse(confirmTicketVo.getDateSelecting())));
		invoice.setMovieName("Movie Name");
		invoice.setScheduleShowTime(confirmTicketVo.getTimeSelecting());
		invoice.setStatus(1);
		invoice.setUseScore(confirmTicketVo.getUseScore());
		invoice.setTotalMoney(confirmTicketVo.getTotalPrice());
		invoice.setAddScore(15000.0);
		invoice.setSeat("1A 2B 3C");
		
		List<ScheduleSeat> scheduleSeats = new ArrayList<ScheduleSeat>();
		seats = new ArrayList<Seat>();
		Seat seat1 = new Seat(1, "A", 1, 0, 0, 2000.0, null);
		Seat seat2 = new Seat(2, "A", 2, 0, 0, 2000.0, null);
		Seat seat3 = new Seat(3, "A", 3, 0, 0, 2000.0, null);
		seats.add(seat1);
		seats.add(seat2);
		seats.add(seat3);
		
		seats.forEach(s -> scheduleSeats.add(
				new ScheduleSeat(
						confirmTicketVo.getMovieId(), confirmTicketVo.getScheduleId(),
						s.getSeatId(), s.getStatus(), s.getSeatType())));
		invoice.setScheduleSeats(scheduleSeats);
		scheduleSeats.forEach(s -> s.setInvoice(invoice));
		
		tickets = new ArrayList<Ticket>();
		seats.forEach(s -> tickets.add(new Ticket(s.getPrice(), s.getSeatType())));
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * TC1: Normal case: ConfirmTicketVo != null
	 */
	@Test
	void testSave_TC1() {
		
		String[] seatIds = {"1","2","3"};
		
		Mockito.when(memberService.save(member)).thenReturn(member);
		Mockito.when(invoiceRepository.save(invoice)).thenReturn(invoice);
		Mockito.when(ticketService.saveAll(tickets)).thenReturn(tickets);
		Mockito.when(seatService.findAllBySeatId(seatIds)).thenReturn(seats);
		Mockito.when(memberService.findByMemberIdOrIdendityCard(confirmTicketVo.getMemberId())).thenReturn(member);
		Mockito.when(movieService.getById(confirmTicketVo.getMovieId())).thenReturn(movie);
		Mockito.when(pageConfig.getScoreAdd()).thenReturn(15000.0);
		
		assertTrue(invoiceService.save(confirmTicketVo));
	}
	
	/**
	 * TC2: Abnormal case: 	 = null;
	 */
	@Test
	void testSave_TC2() {
		
		String[] seatIds = null;
		
		Mockito.when(memberService.save(member)).thenReturn(member);
		Mockito.when(invoiceRepository.save(invoice)).thenReturn(invoice);
		Mockito.when(ticketService.saveAll(tickets)).thenReturn(tickets);
		Mockito.when(seatService.findAllBySeatId(seatIds)).thenReturn(seats);
		Mockito.when(memberService.findByMemberIdOrIdendityCard(confirmTicketVo.getMemberId())).thenReturn(member);
		Mockito.when(movieService.getById(confirmTicketVo.getMovieId())).thenReturn(movie);
		Mockito.when(pageConfig.getScoreAdd()).thenReturn(15000.0);
		
		assertTrue(!invoiceService.save(confirmTicketVo));
	}
	
	/**
	 * TC3: Abnormal case: MovieId = null;
	 */
	@Test
	void testSave_TC3() {
		
		String[] seatIds = {"1","2","3"};
		
		Mockito.when(memberService.save(member)).thenReturn(member);
		Mockito.when(invoiceRepository.save(invoice)).thenReturn(invoice);
		Mockito.when(ticketService.saveAll(tickets)).thenReturn(tickets);
		Mockito.when(seatService.findAllBySeatId(seatIds)).thenReturn(seats);
		Mockito.when(memberService.findByMemberIdOrIdendityCard(confirmTicketVo.getMemberId())).thenReturn(member);
		Mockito.when(movieService.getById(confirmTicketVo.getMovieId())).thenReturn(null);
		Mockito.when(pageConfig.getScoreAdd()).thenReturn(15000.0);
		
		assertTrue(!invoiceService.save(confirmTicketVo));
	}
	
	/**
	 * TC4: Abnormal case: SeatIds = null, Tickets = null.
	 */
	@Test
	void testSave_TC4() {
		
		String[] seatIds = null;
		
		Mockito.when(memberService.save(member)).thenReturn(member);
		Mockito.when(invoiceRepository.save(invoice)).thenReturn(invoice);
		Mockito.when(ticketService.saveAll(tickets)).thenReturn(null);
		Mockito.when(seatService.findAllBySeatId(seatIds)).thenReturn(seats);
		Mockito.when(memberService.findByMemberIdOrIdendityCard(confirmTicketVo.getMemberId())).thenReturn(member);
		Mockito.when(movieService.getById(confirmTicketVo.getMovieId())).thenReturn(movie);
		Mockito.when(pageConfig.getScoreAdd()).thenReturn(15000.0);
		
		assertTrue(!invoiceService.save(confirmTicketVo));
	}
	
	/**
	 * TC5: Abnormal case: SeatIds = 0, Tickets = null.
	 */
	@Test
	void testSave_TC5() {
		
		String[] seatIds = {};
		
		Mockito.when(memberService.save(member)).thenReturn(member);
		Mockito.when(invoiceRepository.save(invoice)).thenReturn(invoice);
		Mockito.when(ticketService.saveAll(tickets)).thenReturn(null);
		Mockito.when(seatService.findAllBySeatId(seatIds)).thenReturn(seats);
		Mockito.when(memberService.findByMemberIdOrIdendityCard(confirmTicketVo.getMemberId())).thenReturn(member);
		Mockito.when(movieService.getById(confirmTicketVo.getMovieId())).thenReturn(movie);
		Mockito.when(pageConfig.getScoreAdd()).thenReturn(15000.0);
		
		assertTrue(!invoiceService.save(confirmTicketVo));
	}
	
	/**
	 * TC6: Abnormal case: memberId = null;
	 */
	@Test
	void testSave_TC6() {
		
		String[] seatIds = {"1","2","3"};
		
		Mockito.when(memberService.save(member)).thenReturn(member);
		Mockito.when(invoiceRepository.save(invoice)).thenReturn(invoice);
		Mockito.when(ticketService.saveAll(tickets)).thenReturn(tickets);
		Mockito.when(seatService.findAllBySeatId(seatIds)).thenReturn(seats);
		Mockito.when(memberService.findByMemberIdOrIdendityCard(confirmTicketVo.getMemberId())).thenReturn(null);
		Mockito.when(movieService.getById(confirmTicketVo.getMovieId())).thenReturn(movie);
		Mockito.when(pageConfig.getScoreAdd()).thenReturn(15000.0);
		
		assertTrue(!invoiceService.save(confirmTicketVo));
	}

}
