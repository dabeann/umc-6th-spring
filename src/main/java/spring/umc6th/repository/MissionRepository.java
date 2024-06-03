package spring.umc6th.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.umc6th.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
