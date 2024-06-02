package spring.umc6th.converter;

import java.util.List;
import spring.umc6th.domain.FoodCategory;
import spring.umc6th.domain.mapping.MemberPrefer;

public class MemberPreferConverter {

    public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodCategoryList) {

        return foodCategoryList.stream()
                .map(foodCategory ->
                        MemberPrefer.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).toList();
    }
}
