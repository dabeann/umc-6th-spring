package spring.umc6th.service.store_service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.umc6th.converter.StoreConverter;
import spring.umc6th.domain.Mission;
import spring.umc6th.domain.Region;
import spring.umc6th.domain.Review;
import spring.umc6th.domain.Store;
import spring.umc6th.repository.MemberRepository;
import spring.umc6th.repository.MissionRepository;
import spring.umc6th.repository.RegionRepository;
import spring.umc6th.repository.ReviewRepository;
import spring.umc6th.repository.StoreRepository;
import spring.umc6th.web.dto.StoreRequestDTO;
import spring.umc6th.web.dto.StoreRequestDTO.MissionDTO;
import spring.umc6th.web.dto.StoreRequestDTO.ReviewDTO;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

    @Override
    public Store createStore(StoreRequestDTO.StoreDTO request) {
        Region region = regionRepository.findByName(request.getRegion())
                .orElse(Region.builder().name(request.getRegion()).build());
        Store store = StoreConverter.toStore(request, region);

        return storeRepository.save(store);
    }

    @Override
    public Review createReview(Long memberId, Long storeId, ReviewDTO request) {
        Review review = StoreConverter.toReview(request);

        review.setMember(memberRepository.findById(memberId).get());
        review.setStore(storeRepository.findById(storeId).get());

        return reviewRepository.save(review);
    }

    @Override
    public Mission createMission(Long storeId, MissionDTO request) {
        Mission mission = StoreConverter.toMission(request);
        mission.setStore(storeRepository.findById(storeId).get());
        return missionRepository.save(mission);
    }
}
