package spring.umc6th.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.umc6th.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
