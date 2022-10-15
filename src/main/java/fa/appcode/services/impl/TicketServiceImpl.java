package fa.appcode.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.appcode.repositories.TicketRepository;
import fa.appcode.services.TicketService;
import fa.appcode.web.entities.Ticket;

@Repository
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public List<Ticket> saveAll(List<Ticket> tickets) {
		if(tickets == null || tickets.size() == 0) {
			return null;
		}
		return ticketRepository.saveAll(tickets);
	}

}
