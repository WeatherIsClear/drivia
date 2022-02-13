package weather.clear.drivia.domain.drivingjoin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import weather.clear.drivia.domain.drivingjoin.entity.DrivingJoin;

public interface DrivingJoinRepository extends JpaRepository<DrivingJoin, Long>, DrivingJoinRepositoryCustom {

}
