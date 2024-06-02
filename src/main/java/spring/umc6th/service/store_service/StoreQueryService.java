package spring.umc6th.service.store_service;

import java.util.Optional;
import spring.umc6th.domain.Store;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
}
