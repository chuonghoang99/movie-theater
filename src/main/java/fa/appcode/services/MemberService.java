package fa.appcode.services;

import fa.appcode.web.entities.Member;

public interface MemberService {
	Member findByMemberIdOrIdendityCard(String member);
	Member save(Member member);
}
