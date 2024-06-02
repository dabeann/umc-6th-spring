package spring.umc6th.service.member_service;

import java.util.Optional;
import spring.umc6th.domain.Member;

public interface MemberQueryService {

    Optional<Member> findMember(Long id);
}
