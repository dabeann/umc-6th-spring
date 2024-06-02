package spring.umc6th.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.umc6th.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
