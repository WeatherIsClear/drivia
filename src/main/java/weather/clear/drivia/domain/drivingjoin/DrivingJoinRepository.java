package weather.clear.drivia.domain.drivingjoin;

import org.springframework.data.jpa.repository.JpaRepository;
import weather.clear.drivia.domain.driving.Driving;
import weather.clear.drivia.domain.drivingjoin.entity.DrivingJoin;

import java.util.List;

public interface DrivingJoinRepository extends JpaRepository<DrivingJoin, Long> {

    public List<DrivingJoin> findByDriving(Driving driving);
}
