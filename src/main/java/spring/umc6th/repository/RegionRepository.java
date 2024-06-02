package spring.umc6th.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import spring.umc6th.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {

    Optional<Region> findByName(String name);
}
