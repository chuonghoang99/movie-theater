package fa.appcode.services;

import java.util.List;

import fa.appcode.web.entities.Ticket;

public interface TicketService {
	List<Ticket> saveAll(List<Ticket> tickets);
}
