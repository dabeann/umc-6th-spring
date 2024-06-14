package spring.umc6th.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.umc6th.apiPayload.ApiResponse;
import spring.umc6th.converter.MissionConverter;
import spring.umc6th.domain.mapping.MemberMission;
import spring.umc6th.service.mission_service.MissionCommandService;
import spring.umc6th.validation.annotation.MissionInChallenging;
import spring.umc6th.web.dto.MissionRequestDTO;
import spring.umc6th.web.dto.MissionResponseDTO;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    // TODO member controller로 리팩토링하기
    @PostMapping("/challenge")
    public ApiResponse<MissionResponseDTO.CreateMemberMissionResultDTO> createChallengingMemberMission(
            @RequestBody @Valid @MissionInChallenging(memberIdField = "memberId", missionIdField = "missionId")
            MissionRequestDTO.ChallengeMissionDTO request) {
        MemberMission memberMission = missionCommandService.createMemberMission(request);
        return ApiResponse.onSuccess(MissionConverter.toCreateMemberMissionDTO(memberMission));
    }
}
