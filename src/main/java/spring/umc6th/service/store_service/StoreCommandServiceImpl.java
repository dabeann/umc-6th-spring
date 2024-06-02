package spring.umc6th.service.store_service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.umc6th.converter.StoreConverter;
import spring.umc6th.domain.Region;
import spring.umc6th.domain.Store;
import spring.umc6th.repository.RegionRepository;
import spring.umc6th.repository.StoreRepository;
import spring.umc6th.web.dto.StoreRequestDTO;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    public Store createStore(StoreRequestDTO.StoreDTO request) {
        Region region = regionRepository.findByName(request.getRegion())
                .orElse(Region.builder().name(request.getRegion()).build());
        Store store = StoreConverter.toStore(request, region);

        return storeRepository.save(store);
    }
}
