package spring.umc6th.service.food_category_service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.umc6th.repository.FoodCategoryRepository;

@Service
@RequiredArgsConstructor
public class FoodCategoryServiceImpl implements FoodCategoryService {

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public boolean exitsByIds(List<Long> ids) {
        return ids.stream().allMatch(foodCategoryRepository::existsById);
    }
}
