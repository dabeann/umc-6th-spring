package spring.umc6th.service.member_service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.umc6th.apiPayload.code.status.ErrorStatus;
import spring.umc6th.apiPayload.exception.handler.FoodCategoryHandler;
import spring.umc6th.converter.MemberConverter;
import spring.umc6th.converter.MemberPreferConverter;
import spring.umc6th.domain.FoodCategory;
import spring.umc6th.domain.Member;
import spring.umc6th.domain.mapping.MemberPrefer;
import spring.umc6th.repository.FoodCategoryRepository;
import spring.umc6th.repository.MemberRepository;
import spring.umc6th.web.dto.MemberRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(
                        ErrorStatus.FOOD_CATEGORY_NOT_FOUND))).toList();

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> memberPrefer.setMember(newMember));

        return memberRepository.save(newMember);
    }
}
