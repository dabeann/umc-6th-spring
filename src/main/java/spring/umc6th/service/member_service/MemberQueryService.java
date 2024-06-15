package spring.umc6th.service.member_service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import spring.umc6th.domain.Member;
import spring.umc6th.domain.Review;
import spring.umc6th.domain.mapping.MemberMission;

public interface MemberQueryService {

    Optional<Member> findMember(Long id);

    Page<Review> getReviewListByMemberId(Long memberId, Integer page);

    Page<MemberMission> getMemberMissionListByMemberId(Long memberId, Integer page);
}
