package spring.umc6th.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.umc6th.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
