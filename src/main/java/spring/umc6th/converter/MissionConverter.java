package spring.umc6th.converter;

import java.time.LocalDateTime;
import spring.umc6th.domain.enums.MissionStatus;
import spring.umc6th.domain.mapping.MemberMission;
import spring.umc6th.web.dto.MissionRequestDTO;
import spring.umc6th.web.dto.MissionResponseDTO;

public class MissionConverter {

    public static MemberMission toMemberMission(MissionRequestDTO.ChallengeMissionDTO request) {
        return MemberMission.builder()
                .status(MissionStatus.CHALLENGING)
                .build();
    }

    public static MissionResponseDTO.CreateMemberMissionResultDTO toCreateMemberMissionDTO(
            MemberMission memberMission) {
        return MissionResponseDTO.CreateMemberMissionResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
