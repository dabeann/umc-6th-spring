package spring.umc6th.service.store_service;

import spring.umc6th.domain.Mission;
import spring.umc6th.domain.Review;
import spring.umc6th.domain.Store;
import spring.umc6th.web.dto.StoreRequestDTO;

public interface StoreCommandService {

    Store createStore(StoreRequestDTO.StoreDTO request);

    Review createReview(Long memberId, Long storeId, StoreRequestDTO.ReviewDTO request);

    Mission createMission(Long storeId, StoreRequestDTO.MissionDTO request);
}
