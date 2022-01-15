package weather.clear.drivia.domain.driving.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import weather.clear.drivia.domain.driving.Driving;

public interface DrivingRepository extends JpaRepository<Driving, Long>, DrivingRepositoryCustom {
}
