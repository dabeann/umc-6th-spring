package spring.umc6th.service.mission_service;

import spring.umc6th.domain.mapping.MemberMission;
import spring.umc6th.web.dto.MissionRequestDTO;

public interface MissionCommandService {

    MemberMission createMemberMission(MissionRequestDTO.ChallengeMissionDTO request);
}
