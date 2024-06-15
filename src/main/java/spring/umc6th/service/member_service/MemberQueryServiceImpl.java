package spring.umc6th.service.member_service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.umc6th.domain.Member;
import spring.umc6th.domain.Mission;
import spring.umc6th.domain.Review;
import spring.umc6th.domain.enums.MissionStatus;
import spring.umc6th.domain.mapping.MemberMission;
import spring.umc6th.repository.MemberMissionRepository;
import spring.umc6th.repository.MemberRepository;
import spring.umc6th.repository.ReviewRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Optional<Member> findMember(Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewListByMemberId(Long memberId, Integer page) {

        Member member = memberRepository.findById(memberId).get();

        Page<Review> memberPage = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
        return memberPage;
    }

    @Override
    public Page<MemberMission> getMemberMissionListByMemberId(Long memberId, Integer page) {

        Member member = memberRepository.findById(memberId).get();

        Page<MemberMission> memberMissionPage = memberMissionRepository.findAllByMemberAndStatus(member,
                MissionStatus.CHALLENGING, PageRequest.of(page, 10));
        return memberMissionPage;
    }
}
