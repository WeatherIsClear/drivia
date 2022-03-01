package weather.clear.drivia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import weather.clear.drivia.entity.joinRequestEntity.JoinRequest;

public interface JoinRequestRepository extends JpaRepository<JoinRequest, Long> {
}
