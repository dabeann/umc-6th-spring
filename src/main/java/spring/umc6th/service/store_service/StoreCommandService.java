package spring.umc6th.service.store_service;

import spring.umc6th.domain.Store;
import spring.umc6th.web.dto.StoreRequestDTO;

public interface StoreCommandService {

    Store createStore(StoreRequestDTO.StoreDTO request);
}
