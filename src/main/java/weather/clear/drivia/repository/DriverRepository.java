package weather.clear.drivia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import weather.clear.drivia.entity.driverEntity.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
