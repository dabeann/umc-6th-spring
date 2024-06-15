package spring.umc6th.service.member_service;

import spring.umc6th.domain.Member;
import spring.umc6th.domain.mapping.MemberMission;
import spring.umc6th.web.dto.MemberRequestDTO;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDto request);

    MemberMission completeMission(Long memberMissionId);
}
