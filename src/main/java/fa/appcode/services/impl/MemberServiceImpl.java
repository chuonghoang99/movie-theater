package fa.appcode.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.appcode.common.utils.Constants;
import fa.appcode.repositories.MemberRepository;
import fa.appcode.services.MemberService;
import fa.appcode.web.entities.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberRepository memberRepository;

	@Override
	public Member findByMemberIdOrIdendityCard(String member) {
		if(Constants.DEFAULT_WORD.equals(member) || member == null) {
			return null;
		}
		return memberRepository.findByMemberIdOrIdendityCard(member);
	}

	@Override
	public Member save(Member member) {
		if(member == null) {
			return null;
		}
		return memberRepository.save(member);
	}

}
