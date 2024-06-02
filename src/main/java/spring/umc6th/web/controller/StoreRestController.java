package spring.umc6th.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.umc6th.apiPayload.ApiResponse;
import spring.umc6th.converter.StoreConverter;
import spring.umc6th.domain.Store;
import spring.umc6th.service.store_service.StoreCommandService;
import spring.umc6th.web.dto.StoreRequestDTO;
import spring.umc6th.web.dto.StoreResponseDTO;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/save")
    public ApiResponse<StoreResponseDTO.CreateStoreResultDTO> createStore(
            @RequestBody @Valid StoreRequestDTO.StoreDTO request) {
        Store store = storeCommandService.createStore(request);
        return ApiResponse.onSuccess(StoreConverter.toCreateStoreResultDTO(store));
    }
}
