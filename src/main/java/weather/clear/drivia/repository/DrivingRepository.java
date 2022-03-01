package weather.clear.drivia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import weather.clear.drivia.entity.drivingEntity.Driving;

public interface DrivingRepository extends JpaRepository<Driving, Long> {
}
