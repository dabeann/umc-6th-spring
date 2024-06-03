package spring.umc6th.service.mission_service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.umc6th.converter.MissionConverter;
import spring.umc6th.domain.mapping.MemberMission;
import spring.umc6th.repository.MemberMissionRepository;
import spring.umc6th.repository.MemberRepository;
import spring.umc6th.repository.MissionRepository;
import spring.umc6th.web.dto.MissionRequestDTO.ChallengeMissionDTO;

@Service
@Transactional
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    public MemberMission createMemberMission(ChallengeMissionDTO request) {
        MemberMission memberMission = MissionConverter.toMemberMission(request);

        memberMission.setMember(memberRepository.findById(request.getMemberId()).get());
        memberMission.setMission(missionRepository.findById(request.getMissionId()).get());

        return memberMissionRepository.save(memberMission);
    }
}
