package fa.appcode.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import fa.appcode.web.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
