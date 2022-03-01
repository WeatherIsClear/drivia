package weather.clear.drivia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import weather.clear.drivia.entity.carEntitiy.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
