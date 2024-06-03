package spring.umc6th.service.mission_service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.umc6th.domain.Member;
import spring.umc6th.domain.Mission;
import spring.umc6th.domain.mapping.MemberMission;
import spring.umc6th.repository.MemberMissionRepository;
import spring.umc6th.repository.MissionRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService{

    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Optional<Mission> findMission(Long id) {
        return missionRepository.findById(id);
    }

    @Override
    public Optional<MemberMission> findMemberMission(Member member, Mission mission) {
        return memberMissionRepository.findByMemberAndMission(member, mission);
    }
}
