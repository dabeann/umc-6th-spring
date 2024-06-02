package spring.umc6th.converter;

import java.time.LocalDateTime;
import spring.umc6th.domain.Region;
import spring.umc6th.domain.Store;
import spring.umc6th.web.dto.StoreRequestDTO;
import spring.umc6th.web.dto.StoreResponseDTO;

public class StoreConverter {

    public static Store toStore(StoreRequestDTO.StoreDTO request, Region region) {
        return Store.builder()
                .region(region)
                .name(request.getName())
                .address(request.getAddress())
                .build();
    }

    public static StoreResponseDTO.CreateStoreResultDTO toCreateStoreResultDTO(Store store) {
        return StoreResponseDTO.CreateStoreResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
