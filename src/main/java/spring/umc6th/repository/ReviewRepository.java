package spring.umc6th.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.umc6th.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
