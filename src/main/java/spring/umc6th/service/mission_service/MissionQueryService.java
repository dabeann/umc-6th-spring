package spring.umc6th.service.mission_service;

import java.util.Optional;
import spring.umc6th.domain.Member;
import spring.umc6th.domain.Mission;
import spring.umc6th.domain.mapping.MemberMission;

public interface MissionQueryService {

    Optional<Mission> findMission(Long id);

    Optional<MemberMission> findMemberMission(Member member, Mission mission);
}
