package spring.umc6th.service.store_service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import spring.umc6th.domain.Review;
import spring.umc6th.domain.Store;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);

    Page<Review> getReviewList(Long storeId, Integer page);
}
