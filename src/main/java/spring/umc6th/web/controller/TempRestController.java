package spring.umc6th.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.umc6th.base.Code;
import spring.umc6th.base.ResponseDTO;
import spring.umc6th.converter.TempConverter;
import spring.umc6th.service.temp_service.TempQueryService;
import spring.umc6th.web.dto.TempResponse;
import spring.umc6th.web.dto.TempResponse.TempTestDTO;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {

    private final TempQueryService tempQueryService;

    @GetMapping("/test")
    public ResponseDTO<TempTestDTO> testAPI(){

        return ResponseDTO.onSuccess(TempConverter.toTempTestDTO(), Code.OK);
    }

    @GetMapping("/exception")
    public ResponseDTO<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag){
        tempQueryService.CheckFlag(flag);
        return ResponseDTO.onSuccess(TempConverter.toTempExceptionDTO(flag), Code.OK);
    }
}
