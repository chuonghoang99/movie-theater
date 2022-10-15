package fa.appcode.services.impl;

import fa.appcode.common.utils.Constants;
import fa.appcode.common.utils.DateUtils;
import fa.appcode.config.PageConfig;
import fa.appcode.repositories.InvoiceRepository;
import fa.appcode.services.*;
import fa.appcode.web.entities.*;
import fa.appcode.web.vo.ConfirmTicketVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc

/**
 * The Class InvoiceServiceImpl.
 */
@Repository
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private SeatService seatService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private PageConfig pageConfig;


    /**
     * Save ticket, edit member score and save invoice
     *
     * @param confirmTicketVo the confirm ticket Vo.
     * @return the boolean
     */
    @Override
    public Boolean save(ConfirmTicketVo confirmTicketVo) {
        if (confirmTicketVo == null) {
            return false;
        }

        List<Seat> seats = seatService.findAllBySeatId(confirmTicketVo.getIdSeatSelecting());
        Member member = memberService.findByMemberIdOrIdendityCard(confirmTicketVo.getMemberId());

        if (member == null || (seats == null || seats.size() == 0)) {
            return false;
        }
        if (confirmTicketVo.getUseScore() == 0) {
            member.setScore(member.getScore() + pageConfig.getScoreAdd());
        } else {
            member.setScore(pageConfig.getScoreAdd() + (member.getScore() - confirmTicketVo.getUseScore()));
        }
        memberService.save(member);

        Invoice invoice = new Invoice();
        invoice.setAccount(member.getAccount());
        invoice.setBookingDate(DateUtils.convertToDate(LocalDate.now()));
        if (movieService.getById(confirmTicketVo.getMovieId()) != null) {
            invoice.setMovieName(movieService.getById(confirmTicketVo.getMovieId()).getMovieNameVn());
        } else {
            return false;
        }
        invoice.setScheduleShow(DateUtils.convertToDate(LocalDate.parse(confirmTicketVo.getDateSelecting())));
        invoice.setScheduleShowTime(confirmTicketVo.getTimeSelecting());
        invoice.setStatus(Constants.INVOICE_BOOKED);
        invoice.setUseScore(confirmTicketVo.getUseScore());
        invoice.setTotalMoney(confirmTicketVo.getTotalPrice());
        invoice.setAddScore(pageConfig.getScoreAdd());

        StringBuilder seatName = new StringBuilder();

        seats.forEach(s -> {

            seatName.append(s.getSeatRow().toString()).append(s.getSeatColumn().toString()).append(Constants.SPACE_WORD);
        });
        invoice.setSeat(seatName.toString());


        List<ScheduleSeat> scheduleSeats = new ArrayList<ScheduleSeat>();
        seats.forEach(s -> scheduleSeats.add(new ScheduleSeat(confirmTicketVo.getMovieId(),
                confirmTicketVo.getScheduleId(), s.getSeatId(), s.getStatus(), s.getSeatType())));
        invoice.setScheduleSeats(scheduleSeats);
        scheduleSeats.forEach(s -> s.setInvoice(invoice));
        invoiceRepository.save(invoice);

        List<Ticket> tickets = new ArrayList<Ticket>();
        seats.forEach(s -> tickets.add(new Ticket(s.getPrice(), s.getSeatType())));
        ticketService.saveAll(tickets);

        return true;
    }

}
