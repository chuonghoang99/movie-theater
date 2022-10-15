package fa.appcode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fa.appcode.web.entities.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {
	
}
