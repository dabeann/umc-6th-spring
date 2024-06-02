package spring.umc6th.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.umc6th.apiPayload.ApiResponse;
import spring.umc6th.converter.MemberConverter;
import spring.umc6th.domain.Member;
import spring.umc6th.service.member_service.MemberCommandService;
import spring.umc6th.web.dto.MemberRequestDTO;
import spring.umc6th.web.dto.MemberResponseDTO.JoinResultDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}
