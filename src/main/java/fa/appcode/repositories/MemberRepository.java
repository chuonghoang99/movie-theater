package fa.appcode.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fa.appcode.web.entities.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

	@Query("SELECT m FROM Member m WHERE m.memberId = ?1 OR m.account.identityCard = ?1")
	Member findByMemberIdOrIdendityCard(String member);
}
