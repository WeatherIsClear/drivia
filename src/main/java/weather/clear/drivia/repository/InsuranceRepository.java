package weather.clear.drivia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import weather.clear.drivia.entity.insuranceEntity.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}
