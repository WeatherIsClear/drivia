package weather.clear.drivia.domain.drivingjoin;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import weather.clear.drivia.domain.driving.Driving;
import weather.clear.drivia.domain.drivingjoin.entity.DrivingJoin;

import java.util.List;

public interface DrivingJoinRepository extends JpaRepository<DrivingJoin, Long> {

    List<DrivingJoin> findByDriving(Driving driving);

    @EntityGraph(attributePaths = {"member"})
    @Query("select dj from DrivingJoin dj where dj.driving = :drving")
    List<DrivingJoin> findWithDrivingDriver(@Param("driving") Driving driving);
}
