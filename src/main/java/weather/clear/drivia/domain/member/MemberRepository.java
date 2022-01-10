package weather.clear.drivia.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import weather.clear.drivia.domain.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

    boolean existsByEmail(String email);
}
